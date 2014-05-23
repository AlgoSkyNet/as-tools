package com.tibco.as.io.file.excel.access;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.tibco.as.io.file.excel.IRowAccessor;

public abstract class AbstractCellAccessor<T> implements IRowAccessor {

	private int cellnum;

	public AbstractCellAccessor(int cellnum) {
		this.cellnum = cellnum;
	}

	@Override
	public T get(Row row) {
		Cell cell = row.getCell(cellnum);
		if (cell == null) {
			return null;
		}
		return get(cell);
	}

	protected abstract T get(Cell cell);

	@SuppressWarnings("unchecked")
	@Override
	public T set(Row row, Object value) {
		if (value == null) {
			return null;
		}
		T oldValue = get(row);
		set(row.getCell(cellnum, Row.CREATE_NULL_AS_BLANK), (T) value);
		return oldValue;
	}

	protected abstract void set(Cell cell, T value);

}
