package com.tibco.as.io.cli;

import com.tibco.as.io.Operation;

public class OperationTypeConverter extends EnumConverter<Operation> {

	@Override
	protected Operation valueOf(String name) {
		return Operation.valueOf(name);
	}

	@Override
	protected Operation[] getValues() {
		return Operation.values();
	}

}
