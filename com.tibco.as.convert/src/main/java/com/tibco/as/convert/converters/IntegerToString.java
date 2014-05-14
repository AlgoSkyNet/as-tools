package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.IntegerFormat;

public class IntegerToString extends Formatter<Integer> {

	public IntegerToString(Attributes attributes) {
		super(ConverterFactory.getNumberFormat(attributes, new IntegerFormat()));
	}

}
