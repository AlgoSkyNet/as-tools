package com.tibco.as.io.simulation.provider;

import java.util.Random;

import com.tibco.as.io.simulation.IValueProvider;

public class FloatProvider implements IValueProvider {

	private Random random;

	public FloatProvider(Random random) {
		this.random = random;
	}

	@Override
	public Float getValue() {
		return random.nextFloat();
	}

}
