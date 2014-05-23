package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToInteger extends AbstractBlobTo<Integer> {

	@Override
	protected Integer getNumber(ByteBuffer buffer) {
		return buffer.getInt();
	}

}
