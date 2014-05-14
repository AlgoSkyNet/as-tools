package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToDouble extends
		AbstractBlobTo<Double> {

	@Override
	protected Double getNumber(ByteBuffer buffer) {
		return buffer.getDouble();
	}
}
