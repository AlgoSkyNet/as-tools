package com.tibco.as.convert.converters;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ChainedConverter;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.format.ShortFormat;

public class StringToShort extends ChainedConverter {

	public StringToShort(Attributes attributes) {
		super(new Parser<Number>(ConverterFactory.getNumberFormat(attributes,
				new ShortFormat())), new NumberToShort());
	}

}
