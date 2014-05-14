package com.tibco.as.io.cli;

import com.tibco.as.space.browser.BrowserDef.DistributionScope;

public class BrowserDistributionScopeConverter extends
		EnumConverter<DistributionScope> {

	@Override
	protected DistributionScope valueOf(String name) {
		return DistributionScope.valueOf(name);
	}

	@Override
	protected DistributionScope[] getValues() {
		return DistributionScope.values();
	}

}
