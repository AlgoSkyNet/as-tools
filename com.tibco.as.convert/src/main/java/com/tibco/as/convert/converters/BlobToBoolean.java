package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToBoolean extends AbstractBlobTo<Boolean> {

	@Override
	protected Boolean getNumber(ByteBuffer buffer) {
		return buffer.get() != 0;
	}
}
