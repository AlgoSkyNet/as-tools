package com.tibco.as.io.cli.spreadsheets;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.cli.CommandImport;
import com.tibco.as.io.file.excel.ExcelImport;
import com.tibco.as.io.file.excel.ExcelImporter;
import com.tibco.as.space.Metaspace;

@Parameters(commandNames = "import", commandDescription = "Import Excel file(s)")
public class CommandImportExcel extends CommandImport {

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

	@Parameter(names = { "-sheet" }, description = "Name of sheet to import")
	private String sheetName;

	@Parameter(description = "Comma separated fields", names = { "-fields" }, variableArity = true)
	private List<String> fieldDefs;

	@ParametersDelegate
	private ExcelFormats formats = new ExcelFormats();

	private void configure(ExcelImport transfer) {
		super.configure(transfer);
		transfer.setHeader(header);
		transfer.getAttributes().putAll(formats.getConversion());
		transfer.setSheetName(sheetName);
		transfer.setFields(FieldUtils.getFields(fieldDefs));
	}

	@Override
	protected Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace) {
		Collection<IMetaspaceTransfer> transfers = new ArrayList<IMetaspaceTransfer>();
		if (files.isEmpty()) {
			System.out.println("No file specified");
		}
		for (String filepath : files) {
			File file = new File(filepath);
			ExcelImporter importer = new ExcelImporter(metaspace, file);
			ExcelImport transfer = new ExcelImport();
			configure(transfer);
			importer.setDefaultTransfer(transfer);
			transfers.add(importer);
		}
		return transfers;
	}

}
