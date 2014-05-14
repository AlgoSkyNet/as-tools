package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class FloatToBlob extends AbstractToBlob<Float> {

	public FloatToBlob() {
		super(Float.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Float value) {
		return buffer.putFloat(value);
	}

}