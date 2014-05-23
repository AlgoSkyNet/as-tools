package com.tibco.as.convert.converters;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class LongToShort implements IConverter<Long, Short> {

	@Override
	public Short convert(Long source) throws ConvertException {
		return source.shortValue();
	}

}
