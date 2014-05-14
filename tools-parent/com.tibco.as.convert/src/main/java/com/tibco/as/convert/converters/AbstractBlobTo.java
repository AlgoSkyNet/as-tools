package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

import com.tibco.as.convert.IConverter;

public abstract class AbstractBlobTo<T> implements IConverter<byte[], T> {

	@Override
	public T convert(byte[] value) {
		return getNumber(ByteBuffer.wrap(value));
	}

	protected abstract T getNumber(ByteBuffer buffer);

}
