package com.tibco.as.convert.converters;

import java.util.Date;

import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;

public class DateToString extends Formatter<Date> {

	public DateToString(Attributes attributes) {
		super(ConverterFactory.getDateFormat(attributes));
	}

}
