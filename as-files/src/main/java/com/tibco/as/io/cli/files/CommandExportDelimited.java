package com.tibco.as.io.cli.files;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.convert.ConverterFactory.Blob;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.cli.CommandExport;
import com.tibco.as.io.file.text.delimited.DelimitedExport;
import com.tibco.as.io.file.text.delimited.DelimitedExporter;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Tuple;

@Parameters(commandNames = "export", commandDescription = "Export space(s) to CSV")
public class CommandExportDelimited extends CommandExport {

	private static final String FIELD_DIRECTORY = "directory";

	private static final String FIELD_NO_HEADER = "noHeader";

	private static final String FIELD_DELIMITER = "delimiter";

	private static final String FIELD_QUOTE = "quote";

	private static final String FIELD_ESCAPE = "escape";

	private static final String FIELD_BLOB_FORMAT = "blobFormat";

	private static final String FIELD_BOOLEAN_FORMAT = "booleanFormat";

	private static final String FIELD_DATE_FORMAT = "dateFormat";

	private static final String FIELD_NUMBER_FORMAT = "numberFormat";

	@Parameter(names = { "-directory" }, description = "Export directory")
	private String directoryPath = ".";

	@Parameter(names = { "-no_header" }, description = "Do not write a first line containing field names")
	private Boolean noHeader;

	@Parameter(names = { "-separator" }, description = "The delimiter to use for separating entries")
	private String delimiter;

	@Parameter(names = { "-quote" }, description = "Character to use for quoted elements")
	private String quote;

	@Parameter(names = { "-escape" }, description = "Character to use for escaping a separator or quote")
	private String escape;

	@ParametersDelegate
	private DelimitedFormats formats = new DelimitedFormats();

	private void configure(DelimitedExport transfer) {
		super.configure(transfer);
		transfer.setEscapeChar(getChar(escape));
		transfer.setHeader(!Boolean.TRUE.equals(noHeader));
		transfer.setQuoteChar(getChar(quote));
		transfer.setSeparator(getChar(delimiter));
		transfer.getAttributes().putAll(formats.getAttributes());
	}

	@Override
	protected void configure(Tuple context) {
		super.configure(context);
		context.putString(FIELD_DIRECTORY, directoryPath);
		if (noHeader != null) {
			context.putBoolean(FIELD_NO_HEADER, noHeader);
		}
		context.putString(FIELD_DELIMITER, delimiter);
		context.putString(FIELD_QUOTE, quote);
		context.putString(FIELD_ESCAPE, escape);
		Blob blobFormat = formats.getBlobFormat();
		if (blobFormat != null) {
			context.putString(FIELD_BLOB_FORMAT, blobFormat.name());
		}
		context.putString(FIELD_BOOLEAN_FORMAT, formats.getBooleanFormat());
		context.putString(FIELD_DATE_FORMAT, formats.getDateFormat());
		context.putString(FIELD_NUMBER_FORMAT, formats.getNumberFormat());
	}

	@Override
	protected void initialize(Tuple context) {
		super.initialize(context);
		if (context.containsKey(FIELD_DIRECTORY)) {
			directoryPath = context.getString(FIELD_DIRECTORY);
		}
		noHeader = context.getBoolean(FIELD_NO_HEADER);
		delimiter = context.getString(FIELD_DELIMITER);
		quote = context.getString(FIELD_QUOTE);
		escape = context.getString(FIELD_ESCAPE);
		String blobFormatName = context.getString(FIELD_BLOB_FORMAT);
		if (blobFormatName != null) {
			formats.setBlobFormat(Blob.valueOf(blobFormatName));
		}
		formats.setBooleanFormat(context.getString(FIELD_BOOLEAN_FORMAT));
		formats.setDateFormat(context.getString(FIELD_DATE_FORMAT));
		formats.setNumberFormat(context.getString(FIELD_NUMBER_FORMAT));
	}

	private Character getChar(String string) {
		if (string == null || string.length() == 0) {
			return null;
		}
		return string.charAt(0);
	}

	@Override
	protected Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace, Collection<String> spaceNames) {
		File directory = new File(directoryPath);
		DelimitedExporter exporter = new DelimitedExporter(metaspace, directory);
		DelimitedExport export = new DelimitedExport();
		configure(export);
		exporter.setDefaultTransfer(export);
		for (String spaceName : spaceNames) {
			exporter.addExport(spaceName);
		}
		return Arrays.asList((IMetaspaceTransfer) exporter);
	}

}
