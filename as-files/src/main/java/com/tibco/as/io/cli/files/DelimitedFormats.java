package com.tibco.as.io.cli.files;

import com.beust.jcommander.Parameter;
import com.tibco.as.convert.Attribute;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory.Blob;
import com.tibco.as.io.cli.BlobConverter;

public class DelimitedFormats {

	@Parameter(description = "Blob format (base64, hex)", names = { "-blob_format" }, converter = BlobConverter.class, validateWith = BlobConverter.class)
	private Blob blobFormat;

	@Parameter(description = "Boolean format", names = { "-boolean_format" })
	private String booleanFormat;

	@Parameter(description = "Date/time format", names = { "-datetime_format" })
	private String dateFormat;

	@Parameter(description = "Number format", names = { "-number_format" })
	private String numberFormat;

	public Attributes getAttributes() {
		Attributes attributes = new Attributes();
		attributes.put(Attribute.FORMAT_BLOB, blobFormat);
		attributes.put(Attribute.FORMAT_BOOLEAN, booleanFormat);
		attributes.put(Attribute.FORMAT_DATE, dateFormat);
		attributes.put(Attribute.FORMAT_NUMBER, numberFormat);
		return attributes;
	}

	public Blob getBlobFormat() {
		return blobFormat;
	}

	public void setBlobFormat(Blob blobFormat) {
		this.blobFormat = blobFormat;
	}

	public String getBooleanFormat() {
		return booleanFormat;
	}

	public void setBooleanFormat(String booleanFormat) {
		this.booleanFormat = booleanFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}

}
