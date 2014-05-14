package com.tibco.as.convert.converters;

import java.math.BigInteger;

import com.tibco.as.convert.IConverter;

public class BigIntegerToBlob implements
		IConverter<BigInteger, byte[]> {

	@Override
	public byte[] convert(BigInteger value) {
		return value.toByteArray();
	}

}
