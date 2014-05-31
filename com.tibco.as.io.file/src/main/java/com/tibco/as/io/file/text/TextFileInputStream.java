package com.tibco.as.io.file.text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.MessageFormat;

import org.apache.commons.io.input.CountingInputStream;

import com.tibco.as.io.IInputStream;

public abstract class TextFileInputStream implements IInputStream<String[]> {

	private File directory;
	private TextFileImport config;
	private CountingInputStream inputStream;
	private InputStreamReader inputStreamReader;
	private LineNumberReader lineNumberReader;

	public TextFileInputStream(File directory, TextFileImport config) {
		this.directory = directory;
		this.config = config;
	}

	@Override
	public void open() throws IOException {
		openFile();
		if (Boolean.TRUE.equals(config.getHeader())) {
			read();
		}
	}
	
	@Override
	public long getOpenTime() {
		return 0;
	}

	private File getFile() {
		return new File(directory, config.getFilename());
	}

	public void openFile() throws FileNotFoundException {
		File file = getFile();
		this.inputStream = new CountingInputStream(new FileInputStream(file));
		this.inputStreamReader = new InputStreamReader(inputStream);
		this.lineNumberReader = new LineNumberReader(inputStreamReader);
		openParser(config);
	}

	protected abstract void openParser(TextFileImport config);

	@Override
	public long size() {
		return getFile().length();
	}

	protected abstract boolean isPending();

	protected abstract String[] parse(String line) throws IOException;

	@Override
	public String[] read() throws IOException {
		String[] result = null;
		do {
			String line = lineNumberReader.readLine();
			if (line == null) {
				return null; // should throw if still pending?
			}
			String[] r = parse(line);
			if (r.length > 0) {
				if (result == null) {
					result = r;
				} else {
					String[] t = new String[result.length + r.length];
					System.arraycopy(result, 0, t, 0, result.length);
					System.arraycopy(r, 0, t, result.length, r.length);
					result = t;
				}
			}
		} while (isPending());
		return result;
	}

	public void skip(long lines) throws IOException {
		for (long i = 0; i < lines; i++) {
			lineNumberReader.readLine();
		}
	}

	@Override
	public void close() throws IOException {
		if (isClosed()) {
			return;
		}
		closeParser();
		lineNumberReader.close();
		inputStreamReader.close();
		inputStream.close();
		lineNumberReader = null;
		inputStreamReader = null;
		inputStream = null;
	}

	protected abstract void closeParser();

	@Override
	public boolean isClosed() {
		return inputStream == null;
	}

	@Override
	public long getPosition() {
		return inputStream.getByteCount();
	}

	@Override
	public String getName() {
		return MessageFormat.format("file ''{0}''", getFile());
	}

}
