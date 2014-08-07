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

	@Parameter(description = "Integer format", names = { "-integer_format" })
	private String integerFormat;

	@Parameter(description = "Decimal format", names = { "-decimal_format" })
	private String decimalFormat;

	public Attributes getAttributes() {
		Attributes attributes = new Attributes();
		attributes.put(Attribute.BLOB, blobFormat);
		attributes.put(Attribute.BOOLEAN, booleanFormat);
		attributes.put(Attribute.DATE, dateFormat);
		attributes.put(Attribute.INTEGER, integerFormat);
		attributes.put(Attribute.DECIMAL, decimalFormat);
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
		return integerFormat;
	}

	public void setNumberFormat(String numberFormat) {
		this.integerFormat = numberFormat;
	}

}
