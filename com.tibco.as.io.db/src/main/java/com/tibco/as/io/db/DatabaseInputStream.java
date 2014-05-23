package com.tibco.as.io.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;

import com.tibco.as.io.EventManager;
import com.tibco.as.io.IInputStream;

public class DatabaseInputStream implements IInputStream<Object[]> {

	private static final char QUOTE = '\"';

	private Connection connection;

	private TableImport config;

	private ResultSet resultSet;

	private long position;

	private Statement statement;

	private String[] columnNames;

	public DatabaseInputStream(Connection connection, TableImport config) {
		this.connection = connection;
		this.config = config;
	}

	private String generateSQL() {
		String[] columnNames = getColumnNames();
		String names = "";
		for (int index = 0; index < columnNames.length; index++) {
			if (index > 0) {
				names += ", ";
			}
			names += columnNames[index];
		}
		String tableName = getTableName();
		return MessageFormat.format("SELECT {0} FROM {1}", names, tableName);
	}

	private String getTableName() {
		String tableName = "";
		if (config.getDatabase().getCatalog() != null) {
			tableName += config.getDatabase().getCatalog() + ".";
		}
		if (config.getDatabase().getSchema() != null) {
			tableName += config.getDatabase().getSchema() + ".";
		}
		tableName += config.getTable().getName();
		return QUOTE + tableName + QUOTE;
	}

	private String[] getColumnNames() {
		if (config.getTable().getColumns() == null
				|| config.getTable().getColumns().getColumn().isEmpty()) {
			return new String[] { "*" };
		}
		List<Column> columns = config.getTable().getColumns().getColumn();
		String[] columnNames = new String[columns.size()];
		for (int index = 0; index < columnNames.length; index++) {
			Column column = columns.get(index);
			columnNames[index] = QUOTE + column.getName() + QUOTE;
		}
		return columnNames;
	}

	@Override
	public void open() throws SQLException {
		if (isOpen()) {
			return;
		}
		doOpen();
	}

	private void doOpen() throws SQLException {
		String sql = getSQL();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		try {
			resultSet.setFetchDirection(ResultSet.FETCH_FORWARD);
		} catch (SQLException e) {
			EventManager.warn(e);
		}
		if (config.getTable().getFetchSize() != null) {
			resultSet.setFetchSize(config.getTable().getFetchSize());
		}
	}

	private String getSQL() {
		if (config.getTable().getSql() == null) {
			return generateSQL();
		}
		return config.getTable().getSql();
	}

	@Override
	public long size() {
		return IInputStream.UNKNOWN_SIZE;
	}

	@Override
	public Object[] read() throws Exception {
		if (resultSet.next()) {
			Object[] result = new Object[columnNames.length];
			for (int index = 0; index < columnNames.length; index++) {
				result[index] = resultSet.getObject(columnNames[index]);
			}
			position++;
			return result;
		}
		return null;
	}

	@Override
	public long getPosition() {
		return position;
	}

	@Override
	public void close() throws Exception {
		if (resultSet == null) {
			return;
		}
		try {
			resultSet.close();
		} finally {
			statement.close();
		}
	}

	@Override
	public boolean isClosed() {
		try {
			return !isOpen() && resultSet.isClosed();
		} catch (SQLException e) {
			EventManager.error(e, "Could not close ResultSet");
			return false;
		}
	}

	private boolean isOpen() {
		return resultSet != null;
	}

	private Column getColumn(List<Column> columns, String name, int index) {
		for (Column column : columns) {
			if (name.equals(column.getName())) {
				return column;
			}
		}
		Column column;
		if (index < columns.size()) {
			column = columns.get(index);
		} else {
			column = new Column();
			columns.add(column);
		}
		column.setName(name);
		return column;
	}

}