package com.tibco.as.io.cli.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.cli.CommandImport;
import com.tibco.as.io.file.text.delimited.DelimitedImport;
import com.tibco.as.io.file.text.delimited.DelimitedImporter;
import com.tibco.as.space.Metaspace;

@Parameters(commandNames = "import", commandDescription = "Import CSV file(s)")
public class CommandImportDelimited extends CommandImport {

	@Parameter(description = "The list of files to import")
	private List<String> files = new ArrayList<String>();

	@Parameter(names = { "-header" }, description = "Treat first line as header containing field names")
	private Boolean header;
	@Parameter(names = { "-strict_quotes" }, description = "Ignore characters outside the quotes")
	private Boolean strictQuotes;
	@Parameter(names = { "-ignore_leading_whitespace" }, description = "Ignore white space in front of a quote in a field")
	private Boolean ignoreLeadingWhitespace;
	@Parameter(names = { "-separator" }, description = "The delimiter to use for separating entries")
	private String delimiter;
	@Parameter(names = { "-quote" }, description = "Character to use for quoted elements")
	private String quote;
	@Parameter(names = { "-escape" }, description = "Character to use for escaping a separator or quote")
	private String escape;
	@ParametersDelegate
	private DelimitedFormats formats = new DelimitedFormats();
	@Parameter(description = "Comma separated fields", names = { "-fields" }, variableArity = true)
	private List<String> fieldDefs;

	private void configure(DelimitedImport transfer) {
		super.configure(transfer);
		transfer.setEscapeChar(getChar(escape));
		transfer.setHeader(header);
		transfer.setIgnoreLeadingWhiteSpace(ignoreLeadingWhitespace);
		transfer.setQuoteChar(getChar(quote));
		transfer.setSeparator(getChar(delimiter));
		transfer.setStrictQuotes(strictQuotes);
		transfer.getAttributes().putAll(formats.getAttributes());
		transfer.setFields(FieldUtils.getFields(fieldDefs));
	}

	private Character getChar(String string) {
		if (string == null || string.length() == 0) {
			return null;
		}
		return string.charAt(0);
	}

	@Override
	protected Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace) {
		Collection<IMetaspaceTransfer> transfers = new ArrayList<IMetaspaceTransfer>();
		if (files.isEmpty()) {
			System.out.println("No file specified");
		}
		Map<File, Collection<String>> files = new LinkedHashMap<File, Collection<String>>();
		for (String path : this.files) {
			File dir;
			Collection<String> filenames = new ArrayList<String>();
			File file = new File(path);
			if (file.isDirectory()) {
				dir = file;
				filenames.addAll(Arrays.asList(file.list()));
			} else {
				dir = file.getParentFile();
				filenames.add(file.getName());
			}
			if (files.containsKey(dir)) {
				files.get(dir).addAll(filenames);
			} else {
				files.put(dir, filenames);
			}
		}
		for (Entry<File, Collection<String>> entry : files.entrySet()) {
			DelimitedImporter importer = new DelimitedImporter(metaspace,
					entry.getKey());
			DelimitedImport transfer = new DelimitedImport();
			configure(transfer);
			importer.setDefaultTransfer(transfer);
			for (String filename : entry.getValue()) {
				importer.addImport(filename);
			}
			transfers.add(importer);
		}
		return transfers;
	}

}
