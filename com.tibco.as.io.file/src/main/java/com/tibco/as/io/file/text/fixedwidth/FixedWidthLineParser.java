package com.tibco.as.io.file.text.fixedwidth;

public class FixedWidthLineParser {

	private int[] widths;

	public FixedWidthLineParser(int[] widths) {
		this.widths = widths;
	}

	/**
	 * Parses an incoming String and returns an array of elements.
	 * 
	 * @param line
	 *            the string to parse
	 * @return the array of elements, or null if line is null
	 */
	public String[] parse(String line) {
		if (line == null) {
			return null;
		}
		String[] result = new String[widths.length];
		int beginIndex = 0;
		for (int index = 0; index < widths.length; index++) {
			int endIndex = beginIndex + widths[index];
			result[index] = line.substring(beginIndex, endIndex);
			beginIndex = endIndex;
		}
		return result;
	}

	public boolean isPending() {
		return false;
	}

}
