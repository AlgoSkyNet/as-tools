package com.tibco.as.convert.converters;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class LongToFloat implements IConverter<Long, Float> {

	@Override
	public Float convert(Long source) throws ConvertException {
		return source.floatValue();
	}

}
