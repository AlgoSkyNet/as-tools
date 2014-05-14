package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToLong extends AbstractBlobTo<Long> {

	@Override
	protected Long getNumber(ByteBuffer buffer) {
		return buffer.getLong();
	}

}
