package com.tibco.as.convert.converters;

import java.text.Format;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class Formatter<T> implements IConverter<T, String> {

	private Format format;

	public Formatter(Format format) {
		this.format = format;
	}

	@Override
	public String convert(T value) throws ConvertException {
		try {
			return format.format(value);
		} catch (IllegalArgumentException e) {
			throw new ConvertException(e, value);
		}
	}
}
