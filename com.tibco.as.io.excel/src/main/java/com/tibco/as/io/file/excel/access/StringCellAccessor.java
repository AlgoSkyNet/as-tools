package com.tibco.as.io.file.excel.access;

import org.apache.poi.ss.usermodel.Cell;

public class StringCellAccessor extends AbstractCellAccessor<String> {

	public StringCellAccessor(int cellnum) {
		super(cellnum);
	}

	@Override
	protected String get(Cell cell) {
		return cell.getStringCellValue();
	}

	@Override
	protected void set(Cell cell, String value) {
		cell.setCellValue(value);
	}

}
