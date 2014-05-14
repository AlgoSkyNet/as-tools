package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToFloat extends AbstractBlobTo<Float> {

	@Override
	protected Float getNumber(ByteBuffer buffer) {
		return buffer.getFloat();
	}

}
