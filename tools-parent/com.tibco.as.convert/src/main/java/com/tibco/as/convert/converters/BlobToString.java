package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;

public class BlobToString extends Formatter<byte[]> {

	public BlobToString(Attributes attributes) {
		super(ConverterFactory.getBlobFormat(attributes));
	}

}
