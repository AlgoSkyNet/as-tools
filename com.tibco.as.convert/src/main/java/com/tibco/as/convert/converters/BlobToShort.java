package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToShort extends AbstractBlobTo<Short> {

	@Override
	protected Short getNumber(ByteBuffer buffer) {
		return buffer.getShort();
	}

}
