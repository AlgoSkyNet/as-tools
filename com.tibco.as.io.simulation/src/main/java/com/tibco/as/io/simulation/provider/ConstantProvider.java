package com.tibco.as.io.simulation.provider;

import com.tibco.as.io.simulation.IValueProvider;
import com.tibco.as.io.simulation.Constant;

public class ConstantProvider implements IValueProvider {

	private Constant field;

	public ConstantProvider(Constant field) {
		this.field = field;
	}

	@Override
	public Object getValue() {
		return field.getValue();
	}

}
