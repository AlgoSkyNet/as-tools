package com.tibco.as.io.excel2as;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

import com.tibco.as.io.IOUtils;

public class TestUtils {

	public static File createTempDirectory() throws IOException {
		File dir = File.createTempFile(TestUtils.class.getName(),
				String.valueOf(System.currentTimeMillis()));
		if (!dir.delete()) {
			throw new IOException(MessageFormat.format(
					"Could not delete temp file: {0}", dir.getAbsolutePath()));
		}
		if (!dir.mkdir()) {
			throw new IOException(MessageFormat.format(
					"Could not create temp directory: {0}",
					dir.getAbsolutePath()));
		}
		return dir;
	}

	public static void copy(String resource, File destination)
			throws IOException {
		OutputStream out = new FileOutputStream(destination);
		try {
			InputStream in = getResourceAsStream(resource);
			if (in == null) {
				throw new FileNotFoundException(resource);
			}
			try {
				IOUtils.copy(in, out);
			} finally {
				in.close();
			}
		} finally {
			out.close();
		}
	}

	public static InputStream getResourceAsStream(String resource) {
		return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
	}

}
