package com.tibco.as.io.file.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import com.tibco.as.io.Field;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IOutputStream;

public abstract class TextFileOutputStream implements IOutputStream<String[]> {

	private File file;
	private TextFileExport export;
	private Field[] fields;

	public TextFileOutputStream(File file, TextFileExport export, Field[] fields) {
		this.file = file;
		this.export = export;
		this.fields = fields;
	}

	@Override
	public void open() throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		PrintWriter writer = getPrintWriter(fos);
		openWriter(writer, export);
		if (Boolean.TRUE.equals(export.getHeader())) {
			write(FieldUtils.format(fields));
		}
	}

	private PrintWriter getPrintWriter(OutputStream out) {
		return new PrintWriter(out, Boolean.TRUE.equals(export.getAutoflush()));
	}

	protected abstract void openWriter(Writer writer, TextFileExport export);

	@Override
	public void close() throws IOException {
		if (isClosed()) {
			return;
		}
		closeWriter();
	}

	protected abstract void closeWriter() throws IOException;

}
