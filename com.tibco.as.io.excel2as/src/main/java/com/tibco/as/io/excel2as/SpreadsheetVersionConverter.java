package com.tibco.as.io.excel2as;

import org.apache.poi.ss.SpreadsheetVersion;

import com.tibco.as.io.cli.EnumConverter;

public class SpreadsheetVersionConverter extends
		EnumConverter<SpreadsheetVersion> {

	@Override
	protected SpreadsheetVersion valueOf(String name) {
		return SpreadsheetVersion.valueOf(name);
	}

	@Override
	protected SpreadsheetVersion[] getValues() {
		return SpreadsheetVersion.values();
	}

}
