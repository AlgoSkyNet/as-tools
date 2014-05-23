package com.tibco.as.io.file.text.delimited;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import com.tibco.as.io.file.text.TextFileImport;
import com.tibco.as.io.file.text.TextFileImporter;
import com.tibco.as.io.file.text.TextFileInputStream;
import com.tibco.as.space.Metaspace;

public class DelimitedImporter extends TextFileImporter {

	public static final String EXTENSION = "csv";

	public DelimitedImporter(Metaspace metaspace, File directory) {
		super(metaspace, directory);
	}

	@Override
	protected DelimitedImport createTransfer() {
		return new DelimitedImport();
	}

	@Override
	protected Collection<String> getExtensions() {
		return Arrays.asList(EXTENSION);
	}

	@Override
	protected TextFileInputStream getInputStream(File directory,
			TextFileImport config) {
		return new DelimitedInputStream(directory, config);
	}

}
