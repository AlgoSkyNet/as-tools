package com.tibco.as.io.file.excel.access;

import org.apache.poi.ss.usermodel.Cell;

public class DoubleCellAccessor extends AbstractCellAccessor<Double> {

	public DoubleCellAccessor(int cellnum) {
		super(cellnum);
	}

	@Override
	protected Double get(Cell cell) {
		return cell.getNumericCellValue();
	}

	@Override
	protected void set(Cell cell, Double value) {
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
	}

}
