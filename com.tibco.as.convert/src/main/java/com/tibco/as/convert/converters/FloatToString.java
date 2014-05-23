package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.FloatFormat;

public class FloatToString extends Formatter<Float> {

	public FloatToString(Attributes attributes) {
		super(ConverterFactory.getNumberFormat(attributes, new FloatFormat()));
	}

}
