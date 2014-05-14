package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.ShortFormat;

public class ShortToString extends Formatter<Short> {

	public ShortToString(Attributes attributes) {
		super(ConverterFactory.getNumberFormat(attributes, new ShortFormat()));
	}

}
