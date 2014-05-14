package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.DoubleFormat;

public class DoubleToString extends Formatter<Double> {

	public DoubleToString(Attributes attributes) {
		super(ConverterFactory.getNumberFormat(attributes, new DoubleFormat()));
	}

}
