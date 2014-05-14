package com.tibco.as.io.simulation.provider;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;

public class BusinessNameProvider implements IValueProvider {

	private DataFactory df;

	public BusinessNameProvider(DataFactory df) {
		this.df = df;
	}

	@Override
	public String getValue() {
		return df.getBusinessName();
	}

}
