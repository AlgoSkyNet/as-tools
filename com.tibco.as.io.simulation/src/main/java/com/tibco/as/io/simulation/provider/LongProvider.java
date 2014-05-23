package com.tibco.as.io.simulation.provider;

import java.util.Random;

import com.tibco.as.io.simulation.IValueProvider;

public class LongProvider implements IValueProvider {

	private Random random;

	public LongProvider(Random random) {
		this.random = random;
	}

	@Override
	public Long getValue() {
		return random.nextLong();
	}

}
