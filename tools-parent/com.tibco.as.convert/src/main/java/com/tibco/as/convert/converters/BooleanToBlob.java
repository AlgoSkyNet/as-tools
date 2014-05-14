package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BooleanToBlob extends AbstractToBlob<Boolean> {

	public BooleanToBlob() {
		super(1);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Boolean value) {
		return buffer.put((byte) (value ? 1 : 0));
	}

}
