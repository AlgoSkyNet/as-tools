package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.RandomText;

public class RandomTextProvider implements IValueProvider {

	private DataFactory df;
	private RandomText field;

	public RandomTextProvider(DataFactory df, RandomText field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		if (field.getLength() == null)
			return df.getRandomText(field.getMinLength(), field.getMaxLength());
		else
			return df.getRandomText(field.getLength());
	}

}
