package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class DoubleToBlob extends AbstractToBlob<Double> {

	public DoubleToBlob() {
		super(Double.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Double value) {
		return buffer.putDouble(value);
	}

}
