package com.tibco.as.io.cli;

import com.tibco.as.convert.ConverterFactory.Blob;

public class BlobConverter extends EnumConverter<Blob> {

	@Override
	protected Blob valueOf(String name) {
		return Blob.valueOf(name);
	}

	@Override
	protected Blob[] getValues() {
		return Blob.values();
	}

}
