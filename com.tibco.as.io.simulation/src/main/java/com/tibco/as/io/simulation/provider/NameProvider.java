package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;

public class NameProvider implements IValueProvider {

	private DataFactory df;

	public NameProvider(DataFactory df) {
		this.df = df;
	}

	@Override
	public String getValue() {
		return df.getName();
	}

}
