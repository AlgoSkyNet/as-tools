package com.tibco.as.io.simulation.provider;

import java.util.Random;

import com.tibco.as.io.simulation.IValueProvider;

public class BooleanProvider implements IValueProvider {

	private Random random;

	public BooleanProvider(Random random) {
		this.random = random;
	}

	@Override
	public Boolean getValue() {
		return random.nextBoolean();
	}
}
