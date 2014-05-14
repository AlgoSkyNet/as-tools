package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ChainedConverter;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.LongFormat;

public class StringToLong extends ChainedConverter {

	public StringToLong(Attributes attributes) {
		super(new Parser<Number>(ConverterFactory.getNumberFormat(attributes,
				new LongFormat())), new NumberToLong());

	}
}
