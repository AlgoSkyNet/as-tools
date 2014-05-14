package com.tibco.as.convert.converters;

import java.nio.ByteBuffer;

public class CharacterToBlob extends
		AbstractToBlob<Character> {

	public CharacterToBlob() {
		super(Character.SIZE);
	}

	@Override
	protected ByteBuffer put(ByteBuffer buffer, Character value) {
		return buffer.putChar(value);
	}

}
