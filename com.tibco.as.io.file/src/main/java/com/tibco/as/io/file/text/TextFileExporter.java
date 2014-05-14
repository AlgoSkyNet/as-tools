package com.tibco.as.io.file.text;

import java.io.File;
import java.util.Collection;

import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.io.Exporter;
import com.tibco.as.io.Field;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IOUtils;
import com.tibco.as.io.IOutputStream;
import com.tibco.as.io.Transfer;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public abstract class TextFileExporter<T extends TextFileExport> extends
		Exporter<String[]> {

	private ConverterFactory converterFactory = new ConverterFactory();

	private File directory;

	public TextFileExporter(Metaspace metaspace, File directory) {
		super(metaspace);
		this.directory = directory;
	}

	@Override
	protected IOutputStream<String[]> getOutputStream(Metaspace metaspace,
			Transfer transfer, SpaceDef spaceDef) {
		TextFileExport export = (TextFileExport) transfer;
		String filename = getFilename(export);
		File file = new File(directory, filename);
		FieldUtils.setFields(export.getFields(), spaceDef);
		return getOutputStream(file, export, export.getFields());
	}

	protected abstract TextFileOutputStream getOutputStream(File directory,
			TextFileExport export, Collection<Field> fields);

	private String getFilename(TextFileExport export) {
		String filename = export.getFilename();
		if (filename == null) {
			return export.getSpaceName() + IOUtils.EXTENSION_SEPARATOR
					+ getExtension();
		}
		return filename;
	}

	protected abstract String getExtension();

	@Override
	protected IConverter<Tuple, String[]> getConverter(Transfer transfer,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		TextFileExport export = (TextFileExport) transfer;
		return FieldUtils.getTupleToArrayConverter(converterFactory, spaceDef,
				export.getFields(), String.class, export.getAttributes(), String.class);
	}
}
