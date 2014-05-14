package com.tibco.as.io.file.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.tibco.as.io.Export;
import com.tibco.as.io.Field;

public class TextFileExport extends Export {

	private Boolean autoflush;

	private Boolean header;

	private String filename;

	private Collection<Field> fields = new ArrayList<Field>();

	public Collection<Field> getFields() {
		return fields;
	}

	public void setFields(Field... fields) {
		this.fields.addAll(Arrays.asList(fields));
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
		target.fields = new ArrayList<Field>();
		for (Field field : fields) {
			target.fields.add(field.clone());
		}
		super.copyTo(target);
	}

}
