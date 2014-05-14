package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.RandomWord;

public class RandomWordProvider implements IValueProvider {

	private DataFactory df;
	private RandomWord field;

	public RandomWordProvider(DataFactory df, RandomWord field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		if (field.getMinLength() == null)
			if (field.isExactLength() == null)
				if (field.getLength() == null)
					return df.getRandomWord();
				else
					return df.getRandomWord(field.getLength());
			else
				return df.getRandomWord(field.getLength(),
						field.isExactLength());
		else
			return df.getRandomWord(field.getMinLength(), field.getMaxLength());
	}

}
