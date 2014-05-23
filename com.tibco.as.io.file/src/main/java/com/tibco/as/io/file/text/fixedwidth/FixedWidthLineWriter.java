package com.tibco.as.io.file.text.fixedwidth;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class FixedWidthLineWriter  {

	public static final int INITIAL_STRING_SIZE = 128;

	public static final char DEFAULT_PAD_CHAR = ' ';

	/** Default line terminator uses platform encoding. */
	public static final String DEFAULT_LINE_END = "\n";

	private Writer rawWriter;

	private PrintWriter pw;

	private String lineEnd;

	private int[] widths;

	private char pad;

	public FixedWidthLineWriter(Writer writer, int[] widths, char pad,
			String lineEnd) {
		this.rawWriter = writer;
		this.pw = new PrintWriter(writer);
		this.widths = widths;
		this.pad = pad;
		this.lineEnd = lineEnd;
	}

	/**
	 * Writes the entire list to a CSV file. The list is assumed to be a
	 * String[]
	 * 
	 * @param allLines
	 *            a List of String[], with each String[] representing a line of
	 *            the file.
	 */
	public void write(List<String[]> lines) {
		for (String[] line : lines) {
			write(line);
		}
	}

	/**
	 * Writes the next line to the file.
	 * 
	 * @param nextLine
	 *            a string array with each comma-separated element as a separate
	 *            entry.
	 */
	public void write(String[] nextLine) {
		if (nextLine != null) {
			StringBuilder sb = new StringBuilder(INITIAL_STRING_SIZE);
			for (int i = 0; i < nextLine.length; i++) {
				int width = widths[i];
				String nextElement = nextLine[i];
				int length;
				if (nextElement == null) {
					length = 0;
				} else {
					length = nextElement.length();
					if (length > width) {
						sb.append(nextElement.substring(0, width));
						length = width;
					} else {
						sb.append(nextElement);
					}
				}
				for (int pos = length; pos < width; pos++) {
					sb.append(pad);
				}
			}
			sb.append(lineEnd);
			pw.write(sb.toString());
		}
	}

	/**
	 * Flush underlying stream to writer.
	 * 
	 * @throws IOException
	 *             if bad things happen
	 */
	private void flush() throws IOException {
		pw.flush();
	}

	/**
	 * Close the underlying stream writer flushing any buffered content.
	 * 
	 * @throws IOException
	 *             if bad things happen
	 * 
	 */
	public void close() throws IOException {
		flush();
		pw.close();
		rawWriter.close();
	}

	/**
	 * Checks to see if the there has been an error in the printstream.
	 */
	public boolean checkError() {
		return pw.checkError();
	}

}
