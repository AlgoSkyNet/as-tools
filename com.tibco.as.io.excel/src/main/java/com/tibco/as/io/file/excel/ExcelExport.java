package com.tibco.as.io.file.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.tibco.as.io.Export;
import com.tibco.as.io.Field;

public class ExcelExport extends Export implements Cloneable {

	private Boolean header;

	private String sheetName;

	private Collection<Field> fields = new ArrayList<Field>();

	public Collection<Field> getFields() {
		return fields;
	}

	public void setFields(Field... fields) {
		this.fields.addAll(Arrays.asList(fields));
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
