package com.tibco.as.io.file.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.tibco.as.convert.Attribute;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.io.Exporter;
import com.tibco.as.io.Field;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IOUtils;
import com.tibco.as.io.IOutputStream;
import com.tibco.as.io.Transfer;
import com.tibco.as.io.TransferException;
import com.tibco.as.io.file.excel.access.BooleanCellAccessor;
import com.tibco.as.io.file.excel.access.DoubleCellAccessor;
import com.tibco.as.io.file.excel.access.FormattedDateCellAccessor;
import com.tibco.as.io.file.excel.access.StringCellAccessor;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class ExcelExporter extends Exporter<Object[]> {

	public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-ddTHH:mm:ss.000";

	public static final String EXTENSION_XLSX = "xlsx";

	public static final String EXTENSION_XLS = "xls";

	private ConverterFactory converterFactory = new ConverterFactory();

	private File file;

	private Workbook workbook;

	public ExcelExporter(Metaspace metaspace, File file) {
		super(metaspace);
		this.file = file;
	}

	public ExcelExporter(Metaspace metaspace, File directory,
			SpreadsheetVersion version) {
		super(metaspace);
		this.file = new File(directory, getFilename(metaspace.getName(),
				version));
	}

	public File getFile() {
		return file;
	}

	private String getFilename(String name, SpreadsheetVersion version) {
		return name + IOUtils.EXTENSION_SEPARATOR + getExtension(version);
	}

	private String getExtension(SpreadsheetVersion version) {
		switch (version) {
		case EXCEL2007:
			return EXTENSION_XLSX;
		default:
			return EXTENSION_XLS;
		}
	}

	@Override
	public void execute() throws TransferException {
		try {
			workbook = createWorkbook();
		} catch (InvalidFormatException e) {
			throw new TransferException("Invalid file format", e);
		} catch (FileNotFoundException e) {
			throw new TransferException("File not found", e);
		} catch (IOException e) {
			throw new TransferException("Could not read file", e);
		}
		super.execute();
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			throw new TransferException("File not found", e);
		}
		try {
			try {
				workbook.write(out);
			} catch (IOException e) {
				throw new TransferException("Could not write workbook", e);
			}
		} finally {
			try {
				try {
					out.close();
				} catch (IOException e) {
					throw new TransferException(
							"Could not close file output stream", e);
				}
			} finally {
				if (workbook instanceof SXSSFWorkbook) {
					((SXSSFWorkbook) workbook).dispose();
				}
			}
		}
	}

	private Workbook createWorkbook() throws InvalidFormatException,
			IOException {
		if (file.exists()) {
			return WorkbookFactory.create(file);
		} else {
			String extension = IOUtils.getExtension(file.getName());
			if (EXTENSION_XLS.equals(extension)) {
				return new HSSFWorkbook();
			}
			return new SXSSFWorkbook(100);
		}
	}

	@Override
	protected IOutputStream<Object[]> getOutputStream(Metaspace metaspace,
			Transfer transfer, SpaceDef spaceDef) {
		ExcelExport export = (ExcelExport) transfer;
		String sheetName = getSheetName(export);
		Sheet sheet = getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}
		Collection<Field> fields = export.getFields();
		FieldUtils.setFields(fields, spaceDef);
		Collection<IRowAccessor> accessors = new ArrayList<IRowAccessor>();
		Attributes conversion = transfer.getAttributes();
		Iterator<Field> fieldIterator = fields.iterator();
		while (fieldIterator.hasNext()) {
			Field field = (Field) fieldIterator.next();
			IRowAccessor accessor;
			if (field.getName() == null) {
				accessor = null;
			} else {
				accessor = createCellAccessor(accessors.size(),
						spaceDef.getFieldDef(field.getName()), conversion);
			}
			accessors.add(accessor);
		}
		return new ExcelOutputStream(sheet, export,
				accessors.toArray(new IRowAccessor[accessors.size()]), fields);
	}

	private Sheet getSheet(String sheetName) {
		return workbook.getSheet(sheetName);
	}

	private String getSheetName(ExcelExport export) {
		if (export.getSheetName() == null) {
			return export.getSpaceName();
		}
		return export.getSheetName();
	}

	@Override
	protected IConverter<Tuple, Object[]> getConverter(Transfer transfer,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		ExcelExport export = (ExcelExport) transfer;
		Collection<FieldDef> fieldDefs = FieldUtils.getFieldDefs(spaceDef,
				export.getFields());
		Class<?>[] types = getTypes(fieldDefs.toArray(new FieldDef[fieldDefs
				.size()]));
		return FieldUtils
				.getTupleToArrayConverter(converterFactory, spaceDef,
						export.getFields(), Object.class,
						export.getAttributes(), types);
	}

	private Class<?>[] getTypes(FieldDef[] fieldDefs) {
		Class<?>[] types = new Class<?>[fieldDefs.length];
		for (int index = 0; index < types.length; index++) {
			types[index] = getType(fieldDefs[index]);
		}
		return types;
	}

	private Class<?> getType(FieldDef fieldDef) {
		switch (fieldDef.getType()) {
		case FLOAT:
		case INTEGER:
		case LONG:
		case SHORT:
		case DOUBLE:
			return Double.class;
		case BLOB:
		case CHAR:
		case STRING:
			return String.class;
		case BOOLEAN:
			return Boolean.class;
		case DATETIME:
			return Date.class;
		}
		return null;
	}

	private IRowAccessor createCellAccessor(int cellnum, FieldDef fieldDef,
			Attributes conversion) {
		switch (fieldDef.getType()) {
		case FLOAT:
		case INTEGER:
		case LONG:
		case SHORT:
		case DOUBLE:
			return new DoubleCellAccessor(cellnum);
		case BLOB:
		case CHAR:
		case STRING:
			return new StringCellAccessor(cellnum);
		case BOOLEAN:
			return new BooleanCellAccessor(cellnum);
		case DATETIME:
			CellStyle style = workbook.createCellStyle();
			String pattern = conversion.get(Attribute.FORMAT_DATE,
					fieldDef.getName());
			if (pattern == null) {
				pattern = DEFAULT_DATETIME_PATTERN;
			}
			style.setDataFormat(workbook.createDataFormat().getFormat(pattern));
			return new FormattedDateCellAccessor(cellnum, style);
		}
		return new StringCellAccessor(cellnum);
	}

	@Override
	protected ExcelExport createTransfer() {
		return new ExcelExport();
	}

}
