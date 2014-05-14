package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;

public class StringToBlob extends Parser<byte[]> {

	public StringToBlob(Attributes attributes) {
		super(ConverterFactory.getBlobFormat(attributes));
	}

}
