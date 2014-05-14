package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.Suffix;

public class SuffixProvider implements IValueProvider {

	private DataFactory df;
	private Suffix field;

	public SuffixProvider(DataFactory df, Suffix field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		return df.getSuffix(field.getChance());
	}

}
