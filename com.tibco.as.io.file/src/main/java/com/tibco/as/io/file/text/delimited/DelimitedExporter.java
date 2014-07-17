package com.tibco.as.io.file.text.delimited;

import java.io.File;

import com.tibco.as.io.Field;
import com.tibco.as.io.file.text.TextFileExport;
import com.tibco.as.io.file.text.TextFileExporter;
import com.tibco.as.io.file.text.TextFileOutputStream;
import com.tibco.as.space.Metaspace;

public class DelimitedExporter extends TextFileExporter<DelimitedExport> {

	public DelimitedExporter(Metaspace metaspace, File directory) {
		super(metaspace, directory);
	}

	@Override
	protected String getExtension() {
		return DelimitedImporter.EXTENSION;
	}

	@Override
	protected DelimitedExport createTransfer() {
		return new DelimitedExport();
	}

	@Override
	protected TextFileOutputStream getOutputStream(File file,
			TextFileExport export, Field[] fields) {
		return new DelimitedOutputStream(file, (DelimitedExport) export, fields);
	}

}
