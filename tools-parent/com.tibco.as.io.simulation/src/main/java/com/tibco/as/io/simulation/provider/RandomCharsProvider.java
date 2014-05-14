package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.RandomChars;

public class RandomCharsProvider implements IValueProvider {

	private DataFactory df;
	private RandomChars field;

	public RandomCharsProvider(DataFactory df, RandomChars field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		String chars;
		if (field.getLength() == null)
			chars = df.getRandomChars(field.getMinLength(),
					field.getMaxLength());
		else
			chars = df.getRandomChars(field.getLength());
		return toCase(chars);
	}

	private String toCase(String string) {
		switch (field.getCase()) {
		case LOWER:
			return string.toLowerCase();
		case UPPER:
			return string.toUpperCase();
		default:
			return string;
		}
	}

}
