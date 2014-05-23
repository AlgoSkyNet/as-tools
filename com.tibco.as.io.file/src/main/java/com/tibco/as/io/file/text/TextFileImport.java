package com.tibco.as.io.file.text;

import java.util.ArrayList;
import java.util.Collection;

import com.tibco.as.io.Field;
import com.tibco.as.io.Import;

public class TextFileImport extends Import implements Cloneable {

	private Collection<Field> fields = new ArrayList<Field>();

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

	public Collection<Field> getFields() {
		return fields;
	}

	public void setFields(Collection<Field> fields) {
		this.fields = fields;
	}

	public void copyTo(TextFileImport target) {
		target.filename = filename;
		target.header = header;
		target.fields = new ArrayList<Field>();
		for (Field field : fields) {
			target.fields.add(field.clone());
		}
		super.copyTo(target);
	}

}
