package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class LongToBlob extends AbstractToBlob<Long> {

	public LongToBlob() {
		super(Long.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Long value) {
		return buffer.putLong(value);
	}

}