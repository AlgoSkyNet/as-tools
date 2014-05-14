package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ChainedConverter;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.DoubleFormat;

public class StringToDouble extends ChainedConverter {

	public StringToDouble(Attributes attributes) {
		super(new Parser<Number>(ConverterFactory.getNumberFormat(attributes,
				new DoubleFormat())), new NumberToDouble());
	}

}
