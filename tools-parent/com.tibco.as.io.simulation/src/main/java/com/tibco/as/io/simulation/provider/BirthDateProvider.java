package com.tibco.as.io.simulation.provider;

import java.util.Calendar;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.IValueProvider;

public class BirthDateProvider implements IValueProvider {

	private DataFactory df;

	public BirthDateProvider(DataFactory df) {
		this.df = df;
	}

	@Override
	public Calendar getValue() {
		Calendar result = Calendar.getInstance();
		result.setTime(df.getBirthDate());
		return result;
	}

}
