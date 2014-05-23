package com.tibco.as.io.db;

import com.tibco.as.io.Import;

public class TableImport extends Import {

	private Database database;

	private Table table;
	
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	@Override
	public TableImport clone() {
		TableImport result = new TableImport();
		copyTo(result);
		return result;
	}

	public void copyTo(TableImport target) {
		target.setDatabase(database);
		target.setTable(table);
		super.copyTo(target);
	}

}
