package com.tibco.as.io.db;

import static java.sql.Types.ARRAY;
import static java.sql.Types.BIGINT;
import static java.sql.Types.BINARY;
import static java.sql.Types.BIT;
import static java.sql.Types.BLOB;
import static java.sql.Types.BOOLEAN;
import static java.sql.Types.CLOB;
import static java.sql.Types.DATALINK;
import static java.sql.Types.DATE;
import static java.sql.Types.DECIMAL;
import static java.sql.Types.DISTINCT;
import static java.sql.Types.DOUBLE;
import static java.sql.Types.FLOAT;
import static java.sql.Types.INTEGER;
import static java.sql.Types.JAVA_OBJECT;
import static java.sql.Types.LONGVARBINARY;
import static java.sql.Types.NULL;
import static java.sql.Types.NUMERIC;
import static java.sql.Types.OTHER;
import static java.sql.Types.REAL;
import static java.sql.Types.REF;
import static java.sql.Types.SMALLINT;
import static java.sql.Types.STRUCT;
import static java.sql.Types.TIME;
import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.TINYINT;
import static java.sql.Types.VARBINARY;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tibco.as.accessors.AccessorFactory;
import com.tibco.as.accessors.ITupleAccessor;
import com.tibco.as.convert.Attributes;
import com.tibco.as.convert.ConverterFactory;
import com.tibco.as.convert.IConverter;
import com.tibco.as.convert.UnsupportedConversionException;
import com.tibco.as.convert.array.ArrayToTupleConverter;
import com.tibco.as.io.EventManager;
import com.tibco.as.io.Import;
import com.tibco.as.io.Importer;
import com.tibco.as.io.Transfer;
import com.tibco.as.io.TransferException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;

public class DatabaseImporter extends Importer<Object[]> {

	private final static int DOUBLE_SIZE = Double.toString(Math.PI).length();
	private final static int FLOAT_SIZE = Float.toString((float) Math.PI)
			.length();
	private final static int LONG_SIZE = Long.toString(Long.MAX_VALUE).length();
	private final static int INTEGER_SIZE = Integer.toString(Integer.MAX_VALUE)
			.length();
	private final static int SHORT_SIZE = Short.toString(Short.MAX_VALUE)
			.length();

	private static final String COLUMN_TABLE_NAME = "TABLE_NAME";

	private static final String[] TABLE_TYPES = { "TABLE" };

	private Database database;
	private Connection connection;
	private Map<TableImport, DatabaseInputStream> inputStreams = new HashMap<TableImport, DatabaseInputStream>();

	public DatabaseImporter(Metaspace metaspace, Database database) {
		super(metaspace);
		this.database = database;
	}

	@Override
	protected boolean isParallelTransfers() {
		return true;
	}

	@Override
	protected Import createTransfer() {
		return new TableImport();
	}

	@Override
	protected Collection<Transfer> getTransfers(Metaspace metaspace) {
		Collection<Transfer> imports = new ArrayList<Transfer>();
		Collection<Table> tables = new ArrayList<Table>(database.getTable());
		if (tables.isEmpty()) {
			try {
				ResultSet rs = connection.getMetaData().getTables(
						database.getCatalog(), database.getSchema(), null,
						TABLE_TYPES);
				while (rs.next()) {
					Table table = new Table();
					String tableName = rs.getString(COLUMN_TABLE_NAME);
					table.setName(tableName);
					tables.add(table);
				}
			} catch (SQLException e) {
				EventManager.error(e, "Could not get tables from metadata");
			}
		}
		for (Table table : tables) {
			TableImport tableImport = ((TableImport) getDefaultTransfer())
					.clone();
			tableImport.setDatabase(database);
			tableImport.setTable(table);
			if (tableImport.getSpaceName() == null) {
				String spaceName = table.getSpace();
				if (spaceName == null) {
					spaceName = table.getName();
				}
				tableImport.setSpaceName(spaceName);
			}
			if (table.getBatchSize() != null) {
				tableImport.setBatchSize(table.getBatchSize());
			}
			if (table.getDistributionRole() != null) {
				tableImport.setDistributionRole(table.getDistributionRole());
			}
			imports.add(tableImport);
		}
		return imports;
	}

	@Override
	protected SpaceDef createSpaceDef(String spaceName, Import config)
			throws SQLException {
		TableImport tableImport = (TableImport) config;
		SpaceDef spaceDef = SpaceDef.create(spaceName);
//		DatabaseInputStream inputStream = new DatabaseInputStream(connection,
//				tableImport);
		if (tableImport.getTable().getColumns() == null) {
			tableImport.getTable().setColumns(new Columns());
		}
		List<Column> columns = tableImport.getTable().getColumns().getColumn();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int count = metaData.getColumnCount();
		columnNames = new String[count];
		for (int index = 0; index < count; index++) {
			int columnIndex = index + 1;
			String name = metaData.getColumnLabel(columnIndex);
			columnNames[index] = name;
			Column column = getColumn(columns, name, index);
			column.setDataType(JDBCType.valueOf(metaData
					.getColumnType(columnIndex)));
			column.setDecimalDigits(metaData.getScale(columnIndex));
			column.setNullable(ResultSetMetaData.columnNullable == metaData
					.isNullable(columnIndex));
			column.setSize(metaData.getPrecision(columnIndex));
		}
		return columns;

		Collection<String> keys = new ArrayList<String>();
		for (Column column : inputStream.getColumns()) {
			String fieldName = getFieldName(column);
			FieldType fieldType = getFieldType(column);
			FieldDef fieldDef = FieldDef.create(fieldName, fieldType);
			fieldDef.setNullable(Boolean.TRUE.equals(column.isNullable()));
			if (Boolean.TRUE.equals(column.isKey())) {
				keys.add(fieldName);
			}
			spaceDef.getFieldDefs().add(fieldDef);
		}
		spaceDef.setKey(keys.toArray(new String[keys.size()]));
		inputStreams.put(tableImport, inputStream);
		return spaceDef;
	}
	
	

	private String getFieldName(Column column) {
		if (column.getField() == null) {
			return column.getName();
		}
		return column.getField();
	}

	private FieldType getFieldType(Column column) {
		if (column.getDataType() == null) {
			EventManager.warn(
					"Datatype of column ''{0}'' not set. Defaulting to STRING",
					column.getName());
			return FieldType.STRING;
		}
		switch (column.getDataType()) {
		case BIGINT:
			return FieldType.LONG;
		case BIT:
			return FieldType.BOOLEAN;
		case BLOB:
			return FieldType.BLOB;
		case BOOLEAN:
			return FieldType.BOOLEAN;
		case CHAR:
			return getStringType(column);
		case CLOB:
			return getStringType(column);
		case DATE:
			return FieldType.DATETIME;
		case DECIMAL:
			return getNumericalType(column);
		case DOUBLE:
			return FieldType.DOUBLE;
		case FLOAT:
			return FieldType.FLOAT;
		case INTEGER:
			return FieldType.INTEGER;
		case LONGNVARCHAR:
			return getStringType(column);
		case LONGVARBINARY:
			return FieldType.BLOB;
		case LONGVARCHAR:
			return getStringType(column);
		case NCHAR:
			return getStringType(column);
		case NCLOB:
			return getStringType(column);
		case NUMERIC:
			return getNumericalType(column);
		case NVARCHAR:
			return getStringType(column);
		case REAL:
			return getNumericalType(column);
		case SMALLINT:
			return FieldType.SHORT;
		case SQLXML:
			return getStringType(column);
		case TIME:
			return FieldType.DATETIME;
		case TIMESTAMP:
			return FieldType.DATETIME;
		case TINYINT:
			return FieldType.SHORT;
		case VARBINARY:
			return FieldType.BLOB;
		case VARCHAR:
			return getStringType(column);
		default:
			return FieldType.STRING;
		}
	}

	private FieldType getStringType(Column column) {
		Integer size = column.getSize();
		if (size == null) {
			return FieldType.STRING;
		}
		if (size == 1) {
			return FieldType.CHAR;
		}
		return FieldType.STRING;
	}

	private FieldType getNumericalType(Column column) {
		Integer size = column.getSize();
		Integer decimalDigits = column.getDecimalDigits();
		if (size == null) {
			return FieldType.LONG;
		}
		if (decimalDigits > 0) {
			if (size > AccessorFactory.FLOAT_SIZE) {
				return FieldType.DOUBLE;
			}
			return FieldType.FLOAT;
		}
		if (size > AccessorFactory.INTEGER_SIZE) {
			return FieldType.LONG;
		}
		if (size > AccessorFactory.SHORT_SIZE) {
			return FieldType.INTEGER;
		}
		return FieldType.SHORT;
	}

	@Override
	protected String getInputSpaceName(Import config) {
		return ((TableImport) config).getSpaceName();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected ArrayToTupleConverter<Object> getConverter(SpaceDef spaceDef,
			Transfer transfer) throws UnsupportedConversionException {
		TableImport config = (TableImport) transfer;
		Table table = config.getTable();
		FieldDef[] fieldDefs = getFieldDefs(spaceDef, transfer);
		ITupleAccessor[] accessors = AccessorFactory.create(fieldDefs);
		ConverterFactory factory = new ConverterFactory();
		Class[] types = getTypes(table, spaceDef);
		IConverter[] converters = factory.getConverters(new Attributes(),
				types, fieldDefs);
		return new ArrayToTupleConverter<Object>(accessors, converters);
	}

	@SuppressWarnings("rawtypes")
	private Class[] getTypes(Table table, SpaceDef spaceDef) {
		List<Column> fields = getColumns(table, spaceDef);
		Class[] types = new Class[fields.size()];
		for (int index = 0; index < fields.size(); index++) {
			types[index] = getType(fields.get(index), spaceDef);
		}
		return types;
	}

	@SuppressWarnings("rawtypes")
	private Class getType(Column column, SpaceDef spaceDef) {
		return getType(column.getDataType().getType());
	}

	@SuppressWarnings("rawtypes")
	public Class getType(int typeCode) {
		switch (typeCode) {
		case ARRAY:
			return Array.class;
		case DECIMAL:
		case BIGINT:
		case NUMERIC:
			return BigDecimal.class;
		case BLOB:
		case BINARY:
		case LONGVARBINARY:
		case VARBINARY:
			return Blob.class;
		case CLOB:
			return Clob.class;
		case BOOLEAN:
			return Boolean.class;
		case DISTINCT:
		case DATALINK:
		case JAVA_OBJECT:
		case OTHER:
		case REF:
			return Object.class;
		case NULL:
			return void.class;
		case DATE:
			return Date.class;
		case TIMESTAMP:
			return Timestamp.class;
		case DOUBLE:
			return Double.class;
		case REAL:
		case FLOAT:
			return Float.class;
		case INTEGER:
			return Integer.class;
		case BIT:
		case SMALLINT:
		case TINYINT:
			return Short.class;
		case STRUCT:
			return Struct.class;
		case TIME:
			return Time.class;
		default:
			return String.class;
		}
	}

	private List<Column> getColumns(Table table, SpaceDef spaceDef) {
		List<Column> columns = getColumns(table);
		if (columns.isEmpty()) {
			Collection<String> keys = spaceDef.getKeyDef().getFieldNames();
			for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
				Column column = createColumn(fieldDef);
				column.setKey(keys.contains(fieldDef.getName()));
				columns.add(column);
			}
		}
		return columns;
	}

	private JDBCType getDataType(FieldType type) {
		if (type == null) {
			return JDBCType.VARCHAR;
		}
		switch (type) {
		case BLOB:
			return JDBCType.BLOB;
		case BOOLEAN:
			return JDBCType.BOOLEAN;
		case CHAR:
			return JDBCType.CHAR;
		case DATETIME:
			return JDBCType.TIMESTAMP;
		case DOUBLE:
			return JDBCType.DOUBLE;
		case FLOAT:
			return JDBCType.FLOAT;
		case INTEGER:
			return JDBCType.INTEGER;
		case LONG:
			return JDBCType.BIGINT;
		case SHORT:
			return JDBCType.SMALLINT;
		default:
			return JDBCType.VARCHAR;
		}
	}

	private Integer getDecimalDigits(FieldType type) {
		if (type == null) {
			return null;
		}
		switch (type) {
		case DOUBLE:
			return DOUBLE_SIZE;
		case FLOAT:
			return FLOAT_SIZE;
		default:
			return null;
		}
	}

	private Column createColumn(FieldDef fieldDef) {
		Column column = new Column();
		column.setDataType(getDataType(fieldDef.getType()));
		column.setDecimalDigits(getDecimalDigits(fieldDef.getType()));
		column.setEncrypted(fieldDef.isEncrypted());
		column.setField(fieldDef.getName());
		column.setName(fieldDef.getName());
		column.setNullable(fieldDef.isNullable());
		column.setSize(getSize(fieldDef.getType()));
		return column;
	}

	private Integer getSize(FieldType fieldType) {
		if (fieldType == null) {
			return null;
		}
		switch (fieldType) {
		case BOOLEAN:
		case CHAR:
			return 1;
		case INTEGER:
			return INTEGER_SIZE;
		case SHORT:
			return SHORT_SIZE;
		case LONG:
			return LONG_SIZE;
		case DOUBLE:
			return DOUBLE_SIZE;
		case FLOAT:
			return FLOAT_SIZE;
		default:
			return null;
		}
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

	private List<Column> getColumns(Table table) {
		if (table.getColumns() == null) {
			table.setColumns(new Columns());
		}
		return table.getColumns().getColumn();
	}

	@Override
	protected DatabaseInputStream getInputStream(Metaspace metaspace,
			Transfer transfer, SpaceDef spaceDef) throws TransferException {
		return inputStreams.get(transfer);
	}

}
