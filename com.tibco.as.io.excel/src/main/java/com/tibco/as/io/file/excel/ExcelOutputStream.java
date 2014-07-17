package com.tibco.as.io.file.excel;

import java.text.MessageFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.tibco.as.io.Field;
import com.tibco.as.io.FieldFormat;
import com.tibco.as.io.IOutputStream;

public class ExcelOutputStream implements IOutputStream<Object[]> {

	private static final String SHEET_NAME_FORMAT = "{0}-{1}";

	private ExcelExport export;

	private Sheet sheet;
	private int sheetIndex = 0;
	private IRowAccessor[] accessors;
	private Field[] fields;
	private int rownum = 0;
	private boolean excel97;
	private String sheetName;

	public ExcelOutputStream(Sheet sheet, ExcelExport export,
			IRowAccessor[] accessors, Field[] fields) {
		this.sheet = sheet;
		this.export = export;
		this.accessors = accessors;
		this.fields = fields;
	}

	@Override
	public void open() throws Exception {
		sheetName = sheet.getSheetName();
		Workbook workbook = sheet.getWorkbook();
		excel97 = workbook instanceof HSSFWorkbook;
		if (Boolean.TRUE.equals(export.getHeader())) {
			Row header = createRow();
			// CreationHelper factory = workbook.getCreationHelper();
			// Drawing drawing = sheet.createDrawingPatriarch();
			FieldFormat format = new FieldFormat();
			for (int columnIndex = 0; columnIndex < fields.length; columnIndex++) {
				Field field = fields[columnIndex];
				Cell cell = header.createCell(columnIndex);
				Font font = workbook.createFont();
				font.setBoldweight(getFontWeight(field.isKey()));
				CellStyle style = workbook.createCellStyle();
				style.setFont(font);
				cell.setCellStyle(style);
				cell.setCellValue(format.format(field));
				// ClientAnchor anchor = factory.createClientAnchor();
				// anchor.setCol1(cell.getColumnIndex());
				// anchor.setCol2(cell.getColumnIndex() + 1);
				// anchor.setRow1(header.getRowNum());
				// anchor.setRow2(header.getRowNum() + 2);
				// Comment comment = drawing.createCellComment(anchor);
				// RichTextString commentString = factory
				// .createRichTextString(fieldDef.getType().name());
				// comment.setColumn(columnIndex);
				// comment.setRow(header.getRowNum());
				// comment.setString(commentString);
				// comment.setAuthor("TIBCO ActiveSpaces®");
				// cell.setCellComment(comment);
			}
		}
	}

	private short getFontWeight(boolean bold) {
		if (bold) {
			return Font.BOLDWEIGHT_BOLD;
		}
		return Font.BOLDWEIGHT_NORMAL;
	}

	public Sheet getSheet() {
		return sheet;
	}

	private String getNextSheetName() {
		return MessageFormat.format(SHEET_NAME_FORMAT, sheetName,
				sheetIndex + 1);
	}

	@Override
	public void write(List<Object[]> elements) {
		for (Object[] element : elements) {
			write(element);
		}
	}

	@Override
	public void write(Object[] element) {
		if (exceedsMaxRows(rownum)) {
			sheet = sheet.getWorkbook().createSheet(getNextSheetName());
			sheetIndex++;
			rownum = 0;
		}
		Row row = createRow();
		for (int columnIndex = 0; columnIndex < element.length; columnIndex++) {
			IRowAccessor accessor = accessors[columnIndex];
			if (accessor != null) {
				accessor.set(row, element[columnIndex]);
			}
		}
	}

	private boolean exceedsMaxRows(int rowNum) {
		return excel97 && rowNum >= SpreadsheetVersion.EXCEL97.getMaxRows();
	}

	public Row createRow() {
		return sheet.createRow(rownum++);
	}

	@Override
	public void close() {
		sheet = null;
	}

	@Override
	public boolean isClosed() {
		return sheet == null;
	}

}
