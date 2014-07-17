package com.tibco.as.io.file.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.ObjectToTupleConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;

public class RowToTupleConverter extends ObjectToTupleConverter<Row> {

	private DataFormatter formatter = new DataFormatter();

	private ConverterFactory factory = new ConverterFactory();

	private Attributes conversion;
	private FieldDef[] fieldDefs;

	private FormulaEvaluator evaluator;

	public RowToTupleConverter(ITupleAccessor[] accessors,
			Attributes conversion, FieldDef[] fieldDefs,
			FormulaEvaluator evaluator) {
		super(accessors);
		this.conversion = conversion;
		this.fieldDefs = fieldDefs;
		this.evaluator = evaluator;
	}

	private Object getValue(Cell cell, FieldType type) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();
		case Cell.CELL_TYPE_ERROR:
			return cell.getErrorCellValue();
		case Cell.CELL_TYPE_FORMULA:
			CellValue value = evaluator.evaluate(cell);
			switch (value.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				return null;
			case Cell.CELL_TYPE_BOOLEAN:
				return value.getBooleanValue();
			case Cell.CELL_TYPE_ERROR:
				return value.getErrorValue();
				// CELL_TYPE_FORMULA will never happen
			case Cell.CELL_TYPE_FORMULA:
				return null;
			case Cell.CELL_TYPE_NUMERIC:
				return value.getNumberValue();
			case Cell.CELL_TYPE_STRING:
				return value.getStringValue();
			}
		case Cell.CELL_TYPE_NUMERIC:
			if (type == FieldType.DATETIME
					|| DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			}
			if (type == FieldType.STRING || type == FieldType.CHAR) {
				return formatter.formatCellValue(cell);
			}
			return cell.getNumericCellValue();
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object get(Row row, int index) throws ConvertException {
		if (row == null) {
			return null;
		}
		int cellnum = row.getFirstCellNum() + index;
		if (cellnum > row.getLastCellNum()) {
			return null;
		}
		Cell cell = row.getCell(cellnum);
		if (cell == null) {
			return null;
		}
		FieldDef fieldDef = fieldDefs[index];
		Object value = getValue(cell, fieldDef.getType());
		if (value == null) {
			return null;
		}
		try {
			return factory.getConverter(conversion, value.getClass(), fieldDef)
					.convert(value);
		} catch (UnsupportedConversionException e) {
			throw new ConvertException(e, value);
		}
	}
}
