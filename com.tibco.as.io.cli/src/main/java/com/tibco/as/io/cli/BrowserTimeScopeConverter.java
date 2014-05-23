package com.tibco.as.io.cli;

import com.tibco.as.space.browser.BrowserDef.TimeScope;

public class BrowserTimeScopeConverter extends EnumConverter<TimeScope> {

	@Override
	protected TimeScope valueOf(String name) {
		return TimeScope.valueOf(name);
	}

	@Override
	protected TimeScope[] getValues() {
		return TimeScope.values();
	}

}