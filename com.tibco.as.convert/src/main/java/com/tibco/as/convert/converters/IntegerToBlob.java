package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class IntegerToBlob extends AbstractToBlob<Integer> {

	public IntegerToBlob() {
		super(Integer.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Integer value) {
		return buffer.putInt(value);
	}

}