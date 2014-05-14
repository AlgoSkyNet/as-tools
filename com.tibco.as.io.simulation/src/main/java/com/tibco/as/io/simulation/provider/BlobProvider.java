package com.tibco.as.io.simulation.provider;

import java.util.Random;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.RandomBlob;

public class BlobProvider implements IValueProvider {

	private Random random;
	private RandomBlob field;

	public BlobProvider(Random random, RandomBlob field) {
		this.random = random;
		this.field = field;
	}

	@Override
	public byte[] getValue() {
		int size = getSize();
		byte[] bytes = new byte[size];
		random.nextBytes(bytes);
		return bytes;
	}

	private int getSize() {
		if (field.getSize() == null) {
			return field.getMinSize()
					+ random.nextInt(field.getMaxSize() - field.getMinSize());
		} else {
			return field.getSize();
		}
	}

}
