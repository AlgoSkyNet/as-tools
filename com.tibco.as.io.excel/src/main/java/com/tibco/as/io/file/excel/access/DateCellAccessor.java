package com.tibco.as.io.file.excel.access;

import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

public class DateCellAccessor extends AbstractCellAccessor<Date> {

	public DateCellAccessor(int cellnum) {
		super(cellnum);
	}

	@Override
	protected Date get(Cell cell) {
		return cell.getDateCellValue();
	}

	@Override
	protected void set(Cell cell, Date value) {
		cell.setCellValue(value);
	}

}
