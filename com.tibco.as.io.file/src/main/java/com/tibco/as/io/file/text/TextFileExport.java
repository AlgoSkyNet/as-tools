package com.tibco.as.io.file.text;

import com.tibco.as.io.Export;
import com.tibco.as.io.Field;

public class TextFileExport extends Export {

	private Boolean autoflush;

	private Boolean header;

	private String filename;

	private Field[] fields;

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field... fields) {
		this.fields = fields;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Boolean getAutoflush() {
		return autoflush;
	}

	public void setAutoflush(Boolean autoflush) {
		this.autoflush = autoflush;
	}

	public Boolean getHeader() {
		return header;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public void copyTo(TextFileExport target) {
		target.autoflush = autoflush;
		target.filename = filename;
		target.header = header;
		if (fields != null) {
			target.fields = new Field[fields.length];
			for (int index = 0; index < fields.length; index++) {
				target.fields[index] = fields[index].clone();
			}
		}
		super.copyTo(target);
	}

}
