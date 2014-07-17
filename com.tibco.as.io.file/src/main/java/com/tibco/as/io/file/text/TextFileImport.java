package com.tibco.as.io.file.text;

import com.tibco.as.io.Field;
import com.tibco.as.io.Import;

public class TextFileImport extends Import implements Cloneable {

	private Field[] fields;

	private String filename;

	private Boolean header;

	@Override
	public TextFileImport clone() {
		TextFileImport textFileImport = new TextFileImport();
		copyTo(textFileImport);
		return textFileImport;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public Boolean getHeader() {
		return header;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field... fields) {
		this.fields = fields;
	}

	public void copyTo(TextFileImport target) {
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
