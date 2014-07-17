package com.tibco.as.io.file.excel;

import com.tibco.as.io.Field;
import com.tibco.as.io.Import;

public class ExcelImport extends Import {

	private Boolean header;

	private String sheetName;

	private Field[] fields;

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field... fields) {
		this.fields = fields;
	}

	public Boolean getHeader() {
		return header;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	@Override
	public ExcelImport clone() {
		ExcelImport clone = new ExcelImport();
		copyTo(clone);
		return clone;
	}

	public void copyTo(ExcelImport target) {
		target.header = header;
		target.sheetName = sheetName;
		if (fields != null) {
			target.fields = new Field[fields.length];
			for (int index = 0; index < fields.length; index++) {
				target.fields[index] = fields[index].clone();
			}
		}
		super.copyTo(target);
	}

}
