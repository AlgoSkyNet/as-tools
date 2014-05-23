package com.tibco.as.convert.converters;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class LongToInteger implements IConverter<Long, Integer> {

	@Override
	public Integer convert(Long source) throws ConvertException {
		return source.intValue();
	}

}
