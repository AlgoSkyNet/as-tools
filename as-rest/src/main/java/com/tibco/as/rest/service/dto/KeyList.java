package com.tibco.as.rest.service.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class KeyList extends BaseDto{

	public KeyList(List<String> keys) {
		this.keys = keys;
	}
	private List<String> keys;
	public List<String> getKeys() {
		return keys;
	}
	

	public static KeyList valueOf(String string) {
		List<String> list = new ArrayList<String>();
		try {
			for (String part : string.split("/")){ 
					list.add(URLDecoder.decode(part, "utf-8"));
			}
		} catch (UnsupportedEncodingException e) {
		}
		return new KeyList(list);
	}

}
