package com.tibco.as.convert.converters;

import com.tibco.as.convert.ConvertException;
import com.tibco.as.convert.IConverter;

public class LongToBoolean implements IConverter<Long, Boolean> {

	@Override
	public Boolean convert(Long source) throws ConvertException {
		return source != 0;
	}

}
