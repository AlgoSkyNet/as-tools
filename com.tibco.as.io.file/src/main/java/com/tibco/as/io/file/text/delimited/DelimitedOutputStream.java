package com.tibco.as.io.file.text.delimited;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.tibco.as.io.Field;
import com.tibco.as.io.file.text.TextFileExport;
import com.tibco.as.io.file.text.TextFileOutputStream;

public class DelimitedOutputStream extends TextFileOutputStream {

	private CSVWriter writer;

	public DelimitedOutputStream(File file, DelimitedExport config,
			Field[] fields) {
		super(file, config, fields);
	}

	@Override
	protected void openWriter(Writer writer, TextFileExport export) {
		DelimitedExport delimitedExport = (DelimitedExport) export;
		char separator = getValue(delimitedExport.getSeparator(),
				CSVWriter.DEFAULT_SEPARATOR);
		char quote = getValue(delimitedExport.getQuoteChar(),
				CSVWriter.NO_QUOTE_CHARACTER);
		char escape = getValue(delimitedExport.getEscapeChar(),
				CSVWriter.NO_ESCAPE_CHARACTER);
		String lineEnd = getValue(delimitedExport.getLineEnd(),
				CSVWriter.DEFAULT_LINE_END);
		this.writer = new CSVWriter(writer, separator, quote, escape, lineEnd);
	}

	private <T> T getValue(T value, T defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	@Override
	public void write(String[] line) {
		writer.writeNext(line);
	}

	@Override
	public void write(List<String[]> elements) {
		writer.writeAll(elements);
	}

	@Override
	protected void closeWriter() throws IOException {
		writer.close();
		writer = null;
	}

	@Override
	public boolean isClosed() {
		return writer == null;
	}

}
