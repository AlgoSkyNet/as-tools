package com.tibco.as.convert;

import com.tibco.as.convert.ConverterFactory.Blob;

public class Attribute<T> {

	public static final Attribute<Blob> FORMAT_BLOB = new Attribute<Blob>();

	public static final Attribute<String> FORMAT_BOOLEAN = new Attribute<String>();

	public static final Attribute<String> FORMAT_DATE = new Attribute<String>();

	public static final Attribute<String> FORMAT_NUMBER = new Attribute<String>();

}
