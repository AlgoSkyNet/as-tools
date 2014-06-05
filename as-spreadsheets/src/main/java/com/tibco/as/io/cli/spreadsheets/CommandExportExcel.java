package com.tibco.as.io.cli.spreadsheets;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.ss.SpreadsheetVersion;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.tibco.as.convert.Attribute;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory.Blob;
import com.tibco.as.io.IMetaspaceTransfer;
import com.tibco.as.io.cli.CommandExport;
import com.tibco.as.io.file.excel.ExcelExport;
import com.tibco.as.io.file.excel.ExcelExporter;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Tuple;

@Parameters(commandNames = "export", commandDescription = "Export space(s) to Excel")
public class CommandExportExcel extends CommandExport {

	private static final String FIELD_FILE = "file";

	private static final String FIELD_NO_HEADER = "noHeader";

	private static final String FIELD_EXCEL_VERSION = "excelVersion";

	private static final String FIELD_BLOB_FORMAT = "blobFormat";

	private static final String FIELD_DATE_FORMAT = "dateFormat";

	@Parameter(names = { "-file" }, description = "File to export to")
	private String filepath;

	@Parameter(names = { "-no_header" }, description = "Do not write a header")
	private Boolean noHeader;

	@Parameter(names = { "-excel_version" }, description = "Excel version", converter = SpreadsheetVersionConverter.class, validateWith = SpreadsheetVersionConverter.class)
	private SpreadsheetVersion version = SpreadsheetVersion.EXCEL97;

	@ParametersDelegate
	private ExcelFormats formats = new ExcelFormats();

	@Parameter(names = { "-datetime_format" }, description = "Date/time format")
	private String dateFormat;

	private void configure(ExcelExport transfer) {
		super.configure(transfer);
		transfer.setHeader(!Boolean.TRUE.equals(noHeader));
		Attributes conversion = formats.getConversion();
		conversion.put(Attribute.FORMAT_DATE, dateFormat);
		transfer.getAttributes().putAll(conversion);
	}

	@Override
	protected void configure(Tuple context) {
		super.configure(context);
		context.putString(FIELD_FILE, filepath);
		if (noHeader != null) {
			context.putBoolean(FIELD_NO_HEADER, noHeader);
		}
		if (version != null) {
			context.putString(FIELD_EXCEL_VERSION, version.name());
		}
		Blob blobFormat = formats.getBlobFormat();
		if (blobFormat != null) {
			context.putString(FIELD_BLOB_FORMAT, blobFormat.name());
		}
		context.putString(FIELD_DATE_FORMAT, dateFormat);
	}

	@Override
	protected void initialize(Tuple context) {
		super.initialize(context);
		if (context.containsKey(FIELD_FILE)) {
			filepath = context.getString(FIELD_FILE);
		}
		noHeader = context.getBoolean(FIELD_NO_HEADER);
		String versionName = context.getString(FIELD_EXCEL_VERSION);
		if (versionName != null) {
			version = SpreadsheetVersion.valueOf(versionName);
		}
		String blobFormatName = context.getString(FIELD_BLOB_FORMAT);
		if (blobFormatName != null) {
			formats.setBlobFormat(Blob.valueOf(blobFormatName));
		}
		dateFormat = context.getString(FIELD_DATE_FORMAT);
	}

	@Override
	protected Collection<IMetaspaceTransfer> getMetaspaceTransfers(
			Metaspace metaspace, Collection<String> spaceNames) {
		ExcelExporter exporter = getExporter(metaspace);
		ExcelExport export = new ExcelExport();
		configure(export);
		exporter.setDefaultTransfer(export);
		for (String spaceName : spaceNames) {
			exporter.addExport(spaceName);
		}
		return Arrays.asList((IMetaspaceTransfer) exporter);
	}

	private ExcelExporter getExporter(Metaspace metaspace) {
		if (filepath == null) {
			return new ExcelExporter(metaspace, new File("."), getVersion());
		}
		return new ExcelExporter(metaspace, new File(filepath));
	}

	private SpreadsheetVersion getVersion() {
		if (version == null) {
			return SpreadsheetVersion.EXCEL97;
		}
		return version;
	}

}
