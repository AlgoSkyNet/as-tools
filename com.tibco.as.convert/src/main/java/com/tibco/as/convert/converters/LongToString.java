package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.LongFormat;

public class LongToString extends Formatter<Long> {

	public LongToString(Attributes attributes) {
		super(ConverterFactory.getNumberFormat(attributes, new LongFormat()));
	}

}
