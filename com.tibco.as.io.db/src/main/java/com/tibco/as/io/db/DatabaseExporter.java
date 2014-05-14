package com.tibco.as.io.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collection;

import com.tibco.as.accessors.AccessorFactory;
import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.convert.array.TupleToArrayConverter;
import com.tibco.as.io.Exporter;
import com.tibco.as.io.Transfer;
import com.tibco.as.io.TransferException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class DatabaseExporter extends Exporter<Object[]> {

	private Database database;

	private Connection connection;

	public DatabaseExporter(Metaspace metaspace, Database database) {
		super(metaspace);
		this.database = database;
	}

	@Override
	public void execute() throws TransferException {
		try {
			Class.forName(database.getDriver());
		} catch (ClassNotFoundException e) {
			String message = MessageFormat.format(
					"Could not find driver ''{0}''", database.getDriver());
			throw new TransferException(message, e);
		}
		try {
			connection = DriverManager.getConnection(database.getUrl(),
					database.getUser(), database.getPassword());
		} catch (SQLException e) {
			throw new TransferException("Could not connect to database", e);
		}
		super.execute();
		try {
			connection.close();
		} catch (SQLException e) {
			throw new TransferException("Could not close connection", e);
		}
	}

	@Override
	protected IConverter<Tuple, Object[]> getConverter(Transfer transfer,
			SpaceDef spaceDef) throws UnsupportedConversionException {
		TableImport config = (TableImport) transfer;
		Table table = config.getTable();
		Collection<FieldDef> fieldDefs = spaceDef.getFieldDefs();
		Collection<ITupleAccessor> accessors = AccessorFactory
				.create(fieldDefs);
		ConverterFactory factory = new ConverterFactory();
//		Class[] types = getTypes(table, spaceDef);
//		IConverter[] converters = factory.getConverters(new Attributes(),
//				types, fieldDefs);
//		return new TupleToArrayConverter<Object>(accessors, converters,
//				Object.class);
	}
}
