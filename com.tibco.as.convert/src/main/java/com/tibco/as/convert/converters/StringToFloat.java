package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ChainedConverter;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.FloatFormat;

public class StringToFloat extends ChainedConverter {

	public StringToFloat(Attributes attributes) {
		super(new Parser<Number>(ConverterFactory.getNumberFormat(attributes,
				new FloatFormat())), new NumberToFloat());
	}

}
