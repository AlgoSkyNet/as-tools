package com.tibco.as.io.file.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.io.Field;
import com.tibco.as.io.FieldUtils;
import com.tibco.as.io.IOUtils;
import com.tibco.as.io.Import;
import com.tibco.as.io.Importer;
import com.tibco.as.io.Transfer;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public abstract class TextFileImporter extends Importer<String[]> {

	private Logger logger = Logger.getLogger(TextFileImporter.class.getName());

	private ConverterFactory converterFactory = new ConverterFactory();

	private File directory;

	protected TextFileImporter(Metaspace metaspace, File directory) {
		super(metaspace);
		this.directory = directory;
	}

	@Override
	protected TextFileInputStream getInputStream(Metaspace metaspace,
			Transfer transfer, SpaceDef spaceDef) {
		return getInputStream(directory, (TextFileImport) transfer);
	}

	protected abstract TextFileInputStream getInputStream(File directory,
			TextFileImport config);

	@Override
	protected String getInputSpaceName(Import config) {
		String filename = ((TextFileImport) config).getFilename();
		return IOUtils.getBaseName(filename);
	}

	@Override
	protected SpaceDef createSpaceDef(String spaceName, Import config) {
		TextFileImport textFileImport = (TextFileImport) config;
		if (textFileImport.getFields().isEmpty()) {
			if (Boolean.TRUE.equals(textFileImport.getHeader())) {
				TextFileInputStream in = getInputStream(directory,
						textFileImport);
				try {
					in.openFile();
					String[] header = in.read();
					Collection<Field> fields = FieldUtils.getFields(Arrays
							.asList(header));
					textFileImport.getFields().addAll(fields);
				} catch (FileNotFoundException e) {
					System.err.println(MessageFormat.format(
							"File not found: {0}", in.getFile()));
				} catch (IOException e) {
					logger.log(Level.SEVERE, "Could not read header", e);
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						logger.log(Level.WARNING,
								"Could not close input stream", e);
					}
				}
			} else {
				System.err.println("No header, could not define space");
			}
		}
		return FieldUtils.createSpaceDef(spaceName, textFileImport.getFields());
	}

	@Override
	protected Collection<Transfer> getTransfers(Metaspace metaspace) {
		Collection<Transfer> imports = new ArrayList<Transfer>();
		TextFilenameFilter filter = new TextFilenameFilter(getExtensions());
		for (String filename : directory.list(filter)) {
			imports.add(getImport(filename));
		}
		return imports;
	}

	protected TextFileImport getImport(String filename) {
		TextFileImport textFileImport = ((TextFileImport) getDefaultTransfer())
				.clone();
		textFileImport.setFilename(filename);
		return textFileImport;
	}

	protected abstract Collection<String> getExtensions();

	@Override
	protected IConverter<String[], Tuple> getConverter(Transfer transfer,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		TextFileImport config = (TextFileImport) transfer;
		return FieldUtils.getArrayToTupleConverter(converterFactory, spaceDef,
				config.getFields(), String.class, config.getAttributes());
	}

	public TextFileImport addImport(String filename) {
		TextFileImport transfer = (TextFileImport) getDefaultTransfer().clone();
		transfer.setFilename(filename);
		addTransfer(transfer);
		return transfer;
	}

}
