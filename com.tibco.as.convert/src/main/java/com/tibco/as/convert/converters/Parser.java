package com.tibco.as.convert.converters;

import java.text.Format;
import java.text.ParseException;

import com.tibco.as.convert.ConvertException;

public class Parser<T> extends AbstractStringParser<T> {

	Format format;

	public Parser(Format format) {
		this.format = format;
	}

	@Override
	protected T parse(String string) throws ConvertException {
		try {
			return convertObject(format.parseObject(string));
		} catch (ParseException e) {
			throw new ConvertException(e, string);
		} catch (NumberFormatException e) {
			throw new ConvertException(e, string);
		}
	}

	@SuppressWarnings("unchecked")
	protected T convertObject(Object parsedObject) {
		return (T) parsedObject;
	}

}
