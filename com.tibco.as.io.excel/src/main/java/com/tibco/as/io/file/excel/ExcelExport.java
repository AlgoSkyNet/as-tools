package com.tibco.as.io.file.excel;

import com.tibco.as.io.Export;
import com.tibco.as.io.Field;

public class ExcelExport extends Export implements Cloneable {

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
	public ExcelExport clone() {
		ExcelExport export = new ExcelExport();
		copyTo(export);
		return export;
	}

	public void copyTo(ExcelExport export) {
		export.header = header;
		export.sheetName = sheetName;
		super.copyTo(export);
	}

}
