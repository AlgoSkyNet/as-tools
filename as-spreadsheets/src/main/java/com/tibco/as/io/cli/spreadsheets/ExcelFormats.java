package com.tibco.as.io.cli.spreadsheets;

import com.beust.jcommander.Parameter;
import com.tibco.as.convert.Attribute;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory.Blob;
import com.tibco.as.io.cli.BlobConverter;

public class ExcelFormats {

	@Parameter(description = "Blob format (base64, hex)", names = { "-blob_format" }, converter = BlobConverter.class, validateWith = BlobConverter.class)
	private Blob blobFormat;

	public Attributes getConversion() {
		Attributes conversion = new Attributes();
		conversion.put(Attribute.BLOB, blobFormat);
		return conversion;
	}

	public Blob getBlobFormat() {
		return blobFormat;
	}

	public void setBlobFormat(Blob blobFormat) {
		this.blobFormat = blobFormat;
	}

}
