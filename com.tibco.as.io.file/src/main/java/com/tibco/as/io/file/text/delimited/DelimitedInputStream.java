package com.tibco.as.io.file.text.delimited;

import java.io.File;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVParser;

import com.tibco.as.io.file.text.TextFileImport;
import com.tibco.as.io.file.text.TextFileInputStream;

public class DelimitedInputStream extends TextFileInputStream {

	private CSVParser parser;

	public DelimitedInputStream(File directory, TextFileImport config) {
		super(directory, config);
	}

	@Override
	protected void openParser(TextFileImport transfer) {
		DelimitedImport config = (DelimitedImport) transfer;
		char separator = getValue(config.getSeparator(),
				CSVParser.DEFAULT_SEPARATOR);
		char quote = getValue(config.getQuoteChar(), CSVParser.NULL_CHARACTER);
		char escape = getValue(config.getEscapeChar(), CSVParser.NULL_CHARACTER);
		boolean strictQuotes = getValue(config.getStrictQuotes(),
				CSVParser.DEFAULT_STRICT_QUOTES);
		boolean ignore = getValue(config.getIgnoreLeadingWhiteSpace(),
				CSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE);
		parser = new CSVParser(separator, quote, escape, strictQuotes, ignore);
	}

	private <T> T getValue(T value, T defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	@Override
	protected void closeParser() {
		parser = null;
	}

	@Override
	protected String[] parse(String line) throws IOException {
		return parser.parseLineMulti(line);
	}

	@Override
	protected boolean isPending() {
		if (parser == null) {
			return false;
		}
		return parser.isPending();
	}

}
