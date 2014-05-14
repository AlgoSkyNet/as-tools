package com.tibco.as.io.file.excel.access;

import org.apache.poi.ss.usermodel.Cell;

public class BooleanCellAccessor extends AbstractCellAccessor<Boolean> {

	public BooleanCellAccessor(int cellnum) {
		super(cellnum);
	}

	@Override
	protected Boolean get(Cell cell) {
		return cell.getBooleanCellValue();
	}

	@Override
	protected void set(Cell cell, Boolean value) {
		cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
		cell.setCellValue(value);
	}

}
