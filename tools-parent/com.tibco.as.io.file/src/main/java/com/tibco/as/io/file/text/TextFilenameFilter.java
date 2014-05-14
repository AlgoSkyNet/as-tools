package com.tibco.as.io.file.text;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;

import com.tibco.as.io.IOUtils;

public class TextFilenameFilter implements FilenameFilter {

	private Collection<String> extensions;

	public TextFilenameFilter(Collection<String> extensions) {
		this.extensions = extensions;
	}

	@Override
	public boolean accept(File dir, String name) {
		return extensions.contains(IOUtils.getExtension(name));
	}
}
