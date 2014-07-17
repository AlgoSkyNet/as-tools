package com.tibco.as.io.file.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import com.tibco.as.accessors.AccessorFactory;
import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.io.Field;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.Import;
import com.tibco.as.io.Importer;
import com.tibco.as.io.Transfer;
import com.tibco.as.io.TransferException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class ExcelImporter extends Importer<Row> {

	private final static String REGEX = "(.+)-(\\d+)";
	private final static Pattern PATTERN = Pattern.compile(REGEX);

	private File file;
	private Workbook workbook;

	public ExcelImporter(Metaspace metaspace, File file) {
		super(metaspace);
		this.file = file;
	}

	@Override
	protected ExcelImport createTransfer() {
		return new ExcelImport();
	}

	@Override
	protected ExcelInputStream getInputStream(Metaspace metaspace,
			Transfer transfer, SpaceDef spaceDef) {
		ExcelImport excelImport = (ExcelImport) transfer;
		return getInputStream(excelImport);
	}

	@Override
	public void execute() throws TransferException {
		try {
			this.workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			throw new TransferException("Invalid file format", e);
		} catch (FileNotFoundException e) {
			throw new TransferException("File not found", e);
		} catch (IOException e) {
			throw new TransferException("Could not read file", e);
		}
		super.execute();
	}

	private ExcelInputStream getInputStream(ExcelImport config) {
		return new ExcelInputStream(config, workbook);
	}

	@Override
	protected SpaceDef createSpaceDef(String spaceName, Import config) {
		ExcelImport excelImport = (ExcelImport) config;
		if (excelImport.getFields() == null) {
			if (Boolean.TRUE.equals(excelImport.getHeader())) {
				Cell[] cells = getHeader(getInputStream(excelImport));
				String[] header = new String[cells.length];
				for (int index = 0; index < cells.length; index++) {
					header[index] = cells[index].getStringCellValue();
				}
				Field[] fields = FieldUtils.getFields(header);
				for (int index = 0; index < cells.length; index++) {
					Cell cell = cells[index];
					Font font = getFont(cell);
					if (isBold(font)) {
						fields[index].setKey(true);
					}
				}
				excelImport.setFields(fields);
			}
		}
		return FieldUtils.createSpaceDef(spaceName, excelImport.getFields());
	}

	private Cell[] getHeader(ExcelInputStream inputStream) {
		try {
			inputStream.openSheet();
			Row row = inputStream.read();
			if (row == null) {
				return null;
			}
			short minColumnIndex = row.getFirstCellNum();
			short maxColumnIndex = row.getLastCellNum();
			Cell[] result = new Cell[maxColumnIndex];
			for (short cellnum = minColumnIndex; cellnum < maxColumnIndex; cellnum++) {
				result[cellnum] = row.getCell(cellnum);
			}
			return result;
		} finally {
			inputStream.close();
		}
	}

	private Font getFont(Cell cell) {
		Workbook workbook = cell.getSheet().getWorkbook();
		CellStyle style = cell.getCellStyle();
		short fontIndex = style.getFontIndex();
		Font font = workbook.getFontAt(fontIndex);
		if (font != null) {
			return font;
		}
		RichTextString string = cell.getRichStringCellValue();
		if (string instanceof HSSFRichTextString) {
			short fontIdx = ((HSSFRichTextString) string).getFontAtIndex(0);
			if (fontIdx == HSSFRichTextString.NO_FONT) {
				return null;
			}
			return workbook.getFontAt(fontIdx);
		} else {
			XSSFRichTextString xstring = (XSSFRichTextString) string;
			try {
				return xstring.getFontAtIndex(0);
			} catch (NullPointerException e) {
				return null;
			}
		}
	}

	private boolean isBold(Font font) {
		if (font == null) {
			return false;
		}
		return font.getBoldweight() == Font.BOLDWEIGHT_BOLD;
	}

	@Override
	protected String getInputSpaceName(Import transfer) {
		String sheetName = ((ExcelImport) transfer).getSheetName();
		if (sheetName == null) {
			return workbook.getSheetAt(0).getSheetName();
		}
		return sheetName;
	}

	@Override
	protected Collection<Transfer> getTransfers(Metaspace metaspace) {
		ExcelImport defaultImport = (ExcelImport) getDefaultTransfer();
		if (defaultImport.getSheetName() == null) {
			int numberOfSheets = workbook.getNumberOfSheets();
			Collection<Transfer> imports = new ArrayList<Transfer>();
			List<String> sheetNames = new ArrayList<String>();
			for (int index = 0; index < numberOfSheets; index++) {
				Sheet sheet = workbook.getSheetAt(index);
				String sheetName = sheet.getSheetName();
				Matcher matcher = PATTERN.matcher(sheetName);
				if (matcher.find()) {
					sheetName = matcher.group(1);
					if (sheetNames.contains(sheetName)) {
						continue;
					}
				}
				sheetNames.add(sheetName);
				ExcelImport excelImport = defaultImport.clone();
				excelImport.setSheetName(sheet.getSheetName());
				imports.add(excelImport);
			}
			return imports;
		}
		return Arrays.asList((Transfer) defaultImport.clone());
	}

	@Override
	protected IConverter<Row, Tuple> getConverter(Transfer transfer,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		ExcelImport excelImport = (ExcelImport) transfer;
		FieldDef[] fieldDefs = FieldUtils.getFieldDefs(spaceDef,
				excelImport.getFields());
		ITupleAccessor[] accessors = AccessorFactory.create(fieldDefs);
		FormulaEvaluator evaluator = workbook.getCreationHelper()
				.createFormulaEvaluator();
		return new RowToTupleConverter(accessors, transfer.getAttributes(),
				fieldDefs, evaluator);
	}

}
