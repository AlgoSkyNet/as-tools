package com.tibco.as.io.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

import org.apache.poi.util.IOUtils;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.tibco.as.io.EventManager;
import com.tibco.as.io.IEvent;
import com.tibco.as.io.IEventListener;

public class TestBase {

	@BeforeClass
	public static void setupLogging() {
		EventManager.addListener(new IEventListener() {

			@Override
			public void onEvent(IEvent event) {
				switch (event.getSeverity()) {
				case ERROR:
				case WARN:
					event.getException().printStackTrace();
					Assert.fail(event.getMessage());
					break;
				default:
				}
			}
		});
	}

	protected static File createTempDirectory() throws IOException {
		File dir = File.createTempFile(TestBase.class.getName(),
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

	protected File copy(String resource, File dir) throws IOException {
		File file = new File(dir, resource);
		OutputStream out = new FileOutputStream(file);
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
		return file;
	}

	protected InputStream getResourceAsStream(String resource) {
		return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
	}

}
