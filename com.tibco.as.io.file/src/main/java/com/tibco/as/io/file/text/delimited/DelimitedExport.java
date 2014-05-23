package com.tibco.as.io.file.text.delimited;

import com.tibco.as.io.file.text.TextFileExport;

public class DelimitedExport extends TextFileExport implements Cloneable {

	private Character separator;

	private Character quoteChar;

	private Character escapeChar;

	private String lineEnd;

	public Character getSeparator() {
		return separator;
	}

	public void setSeparator(Character separator) {
		this.separator = separator;
	}

	public Character getQuoteChar() {
		return quoteChar;
	}

	public void setQuoteChar(Character quoteChar) {
		this.quoteChar = quoteChar;
	}

	public Character getEscapeChar() {
		return escapeChar;
	}

	public void setEscapeChar(Character escapeChar) {
		this.escapeChar = escapeChar;
	}

	public String getLineEnd() {
		return lineEnd;
	}

	public void setLineEnd(String lineEnd) {
		this.lineEnd = lineEnd;
	}

	@Override
	public DelimitedExport clone() {
		DelimitedExport export = new DelimitedExport();
		copyTo(export);
		return export;
	}

	public void copyTo(DelimitedExport export) {
		export.separator = separator;
		export.quoteChar = quoteChar;
		export.escapeChar = escapeChar;
		export.lineEnd = lineEnd;
		super.copyTo(export);
	}

}
