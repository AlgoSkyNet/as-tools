package com.tibco.as.convert.converters;

import java.util.Date;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;

public class StringToDate extends Parser<Date> {

	public StringToDate(Attributes attributes) {
		super(ConverterFactory.getDateFormat(attributes));
	}

}
