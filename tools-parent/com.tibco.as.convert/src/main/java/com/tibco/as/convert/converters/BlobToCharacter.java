package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class BlobToCharacter extends
		AbstractBlobTo<Character> {

	@Override
	protected Character getNumber(ByteBuffer buffer) {
		return buffer.getChar();
	}
}
