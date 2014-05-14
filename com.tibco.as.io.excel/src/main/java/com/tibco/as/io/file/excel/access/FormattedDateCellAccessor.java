package com.tibco.as.io.file.excel.access;

import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class FormattedDateCellAccessor extends AbstractCellAccessor<Date> {

	private CellStyle style;

	public FormattedDateCellAccessor(int cellnum, CellStyle style) {
		super(cellnum);
		this.style = style;
	}

	@Override
	protected Date get(Cell cell) {
		return cell.getDateCellValue();
	}

	@Override
	protected void set(Cell cell, Date value) {
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

}
