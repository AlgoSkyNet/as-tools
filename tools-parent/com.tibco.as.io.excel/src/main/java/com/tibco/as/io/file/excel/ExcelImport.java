package com.tibco.as.io.file.excel;

import java.util.ArrayList;
import java.util.Collection;

import com.tibco.as.io.Field;
import com.tibco.as.io.Import;

public class ExcelImport extends Import {

	private Boolean header;

	private String sheetName;

	private Collection<Field> fields = new ArrayList<Field>();

	public Collection<Field> getFields() {
		return fields;
	}

	public void setFields(Collection<Field> fields) {
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
		target.fields = new ArrayList<Field>();
		for (Field field : fields) {
			target.fields.add(field.clone());
		}
		super.copyTo(target);
	}

}
