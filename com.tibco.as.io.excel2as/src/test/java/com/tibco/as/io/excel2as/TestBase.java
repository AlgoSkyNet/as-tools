package com.tibco.as.io.excel2as;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import com.tibco.as.io.EventManager;
import com.tibco.as.io.IEvent;
import com.tibco.as.io.IEvent.Severity;
import com.tibco.as.io.IEventListener;
import com.tibco.as.io.IOUtils;
import com.tibco.as.space.ASException;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;

public class TestBase {

	private static File dir;

	@BeforeClass
	public static void setupClass() throws IOException {
		dir = createTempDirectory();
	}

	@AfterClass
	public static void teardownClass() {
		dir.delete();
	}

	protected static File getDir() {
		return dir;
	}

	private Metaspace metaspace;

	@Before
	public void connectMetaspace() throws ASException {
		MemberDef memberDef = MemberDef.create(null, "tcp", null);
		memberDef.setConnectTimeout(10000);
		metaspace = Metaspace.connect(null, memberDef);
		EventManager.addListener(new IEventListener() {

			@Override
			public void onEvent(IEvent event) {
				if (event.getSeverity() == Severity.ERROR) {
					event.getException().printStackTrace();
					Assert.fail(event.getMessage());
				}
			}
		});
	}

	@After
	public void closeMetaspace() throws ASException {
		metaspace.closeAll();
	}

	protected Metaspace getMetaspace() {
		return metaspace;
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
