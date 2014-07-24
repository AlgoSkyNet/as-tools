package com.tibco.as.io.simulation;

import java.util.List;

import org.fluttercode.datafactory.ContentDataValues;

public class CustomContentDataValues implements ContentDataValues {

	private Contents contents;

	public CustomContentDataValues(Contents contents) {
		this.contents = contents;
	}

	@Override
	public String[] getWords() {
		List<String> words = contents.getWord();
		return words.toArray(new String[words.size()]);
	}

	@Override
	public String[] getBusinessTypes() {
		List<String> businessTypes = contents.getBusinessType();
		return businessTypes.toArray(new String[businessTypes.size()]);
	}

	@Override
	public String[] getEmailHosts() {
		List<String> emailHosts = contents.getEmailHost();
		return emailHosts.toArray(new String[emailHosts.size()]);
	}

	@Override
	public String[] getTlds() {
		List<String> tlds = contents.getTld();
		return tlds.toArray(new String[tlds.size()]);
	}

}
