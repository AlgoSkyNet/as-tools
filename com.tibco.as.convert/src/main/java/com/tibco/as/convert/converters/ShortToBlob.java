package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class ShortToBlob extends AbstractToBlob<Short> {

	public ShortToBlob() {
		super(Short.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Short value) {
		return buffer.putShort(value);
	}

}