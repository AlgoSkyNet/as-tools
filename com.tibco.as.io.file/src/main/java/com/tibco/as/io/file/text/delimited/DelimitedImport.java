package com.tibco.as.io.file.text.delimited;

import com.tibco.as.io.file.text.TextFileImport;

public class DelimitedImport extends TextFileImport implements Cloneable {

	private Character separator;

	private Character quotechar;

	private Character escapeChar;

	private Boolean strictQuotes;

	private Boolean ignoreLeadingWhiteSpace;

	@Override
	public DelimitedImport clone() {
		DelimitedImport clone = new DelimitedImport();
		copyTo(clone);
		return clone;
	}

	public Character getSeparator() {
		return separator;
	}

	public void setSeparator(Character separator) {
		this.separator = separator;
	}

	public Character getQuoteChar() {
		return quotechar;
	}

	public void setQuoteChar(Character quotechar) {
		this.quotechar = quotechar;
	}

	public Character getEscapeChar() {
		return escapeChar;
	}

	public void setEscapeChar(Character escapeChar) {
		this.escapeChar = escapeChar;
	}

	public Boolean getStrictQuotes() {
		return strictQuotes;
	}

	public void setStrictQuotes(Boolean strictQuotes) {
		this.strictQuotes = strictQuotes;
	}

	public Boolean getIgnoreLeadingWhiteSpace() {
		return ignoreLeadingWhiteSpace;
	}

	public void setIgnoreLeadingWhiteSpace(Boolean ignoreLeadingWhiteSpace) {
		this.ignoreLeadingWhiteSpace = ignoreLeadingWhiteSpace;
	}

	public void copyTo(DelimitedImport target) {
		target.escapeChar = escapeChar;
		target.ignoreLeadingWhiteSpace = ignoreLeadingWhiteSpace;
		target.quotechar = quotechar;
		target.separator = separator;
		target.strictQuotes = strictQuotes;
		super.copyTo(target);
	}

}
