package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ChainedConverter;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.IntegerFormat;

public class StringToInteger extends ChainedConverter {

	public StringToInteger(Attributes attributes) {
		super(new Parser<Number>(ConverterFactory.getNumberFormat(attributes,
				new IntegerFormat())), new NumberToInteger());
	}

}
