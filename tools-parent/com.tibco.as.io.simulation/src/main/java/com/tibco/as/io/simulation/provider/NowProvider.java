package com.tibco.as.io.simulation.provider;

import java.util.Calendar;

import com.tibco.as.io.simulation.IValueProvider;

public class NowProvider implements IValueProvider {

	@Override
	public Calendar getValue() {
		return Calendar.getInstance();
	}

}
