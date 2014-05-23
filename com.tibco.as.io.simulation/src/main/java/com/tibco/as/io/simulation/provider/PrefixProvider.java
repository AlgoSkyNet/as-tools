package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.Prefix;

public class PrefixProvider implements IValueProvider {

	private DataFactory df;
	private Prefix field;

	public PrefixProvider(DataFactory df, Prefix field) {
		this.df = df;
		this.field = field;
	}

	@Override
	public String getValue() {
		return df.getPrefix(field.getChance());
	}

}
