package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.NumberText;

public class NumberTextProvider implements IValueProvider {

	private DataFactory df;
	private NumberText field;

	public NumberTextProvider(DataFactory df, NumberText field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		return df.getNumberText(field.getDigits());
	}

}
