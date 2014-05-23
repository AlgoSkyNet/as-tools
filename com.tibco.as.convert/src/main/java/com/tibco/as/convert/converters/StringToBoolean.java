package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;

public class StringToBoolean extends Parser<Boolean> {

	public StringToBoolean(Attributes attributes) {
		super(ConverterFactory.getBooleanFormat(attributes));
	}

}
