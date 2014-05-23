package com.tibco.as.convert.converters;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class LongToDouble implements IConverter<Long, Double> {

	@Override
	public Double convert(Long source) throws ConvertException {
		return source.doubleValue();
	}

}
