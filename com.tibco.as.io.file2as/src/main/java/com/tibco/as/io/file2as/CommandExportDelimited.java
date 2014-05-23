package com.tibco.as.io.file2as;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.cli.CommandExport;
import com.tibco.as.io.file.text.delimited.DelimitedExport;
import com.tibco.as.io.file.text.delimited.DelimitedExporter;
import com.tibco.as.space.Metaspace;

@Parameters(commandNames = "export", commandDescription = "Export space(s) to CSV")
public class CommandExportDelimited extends CommandExport {

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
