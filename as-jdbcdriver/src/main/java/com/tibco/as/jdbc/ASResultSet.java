// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.tibco.as.sql.ASSQLResult;

/**
 * ASResultSet contains the results of SQL queries against the ActiveSpaces data grid.
 *
 * Currently, ASResultSet is not updatable and the cursor moves forward only. The Updater methods
 * have not been implemented.
 *
 * For a description of what each of the methods does, see the JavaDoc for java.sql.ResultSet.
 */
public class ASResultSet extends AbstractResultSet implements ResultSet
{

    protected Statement         statement;     // the Statement object that produced this result
    protected ASSQLResult       sqlResult;     // the result generated from processing the SQL query

    protected ResultSetMetaData resultMetaData;

    // the names of the fields/columns in the result tuples which has
    // been ordered according to the order specified in the SQL statement
    private List<String>        columnNames;

    private int                 rowCounter = 0;

    public ASResultSet (ASSQLResult inResult, Statement statement) throws SQLException
    {
        if (inResult == null)
            throw new SQLDataException("Missing query result parameter.");
        if (statement == null)
            throw new SQLDataException("Missing SQL statement parameter.");
        this.sqlResult = inResult;
        this.statement = statement;
        this.columnNames = inResult.getQueryColumnNames();
        if (this.columnNames == null)
            throw new SQLSyntaxErrorException("Invalid query string passed for processing.");
        this.resultMetaData = new ASResultSetMetaData(inResult);
    }

    public void close () throws SQLException
    {
        columnNames = null;
        if (sqlResult != null)
            sqlResult.close();
        sqlResult = null;
        statement = null;
        rowCounter = 0;
    }

    public Statement getStatement () throws SQLException
    {
        return statement;
    }

    public ResultSetMetaData getMetaData () throws SQLException
    {
        return resultMetaData;
    }

    public boolean isClosed () throws SQLException
    {
        return columnNames == null ? true : false;
    }

    /**
     * Moves the cursor froward one row from its current position. A <code>ResultSet</code> cursor
     * is initially positioned before the first row; the first call to the method <code>next</code>
     * makes the first row the current row; the second call makes the second row the current row,
     * and so on.
     * <p>
     *
     * @return <code>true</code> if the new current row is valid; <code>false</code> if there are no
     *         more rows
     * @exception SQLException
     *                if a database access error occurs or this method is called on a closed result
     *                set
     */
    public boolean next () throws SQLException
    {
        boolean result = false;
        if (sqlResult != null)
        {
            result = sqlResult.next();
            if (result == true)
                rowCounter++;
        }
        return result;
    }

    public int getRow () throws SQLException
    {
        return rowCounter;
    }

    public int findColumn (String columnLabel) throws SQLException
    {
        checkNotClosed();
        checkLabel(columnLabel);
        // add 1 to the index of the column name since columns are numbered from 1
        // but Lists are indexed from 0
        return columnNames.indexOf(columnLabel) + 1;
    }

    public boolean wasNull () throws SQLException
    {
        return sqlResult.wasLastValueNull();
    }

    public boolean isBeforeFirst () throws SQLException
    {
        return sqlResult.isBeforeFirst();
    }

    public boolean isAfterLast () throws SQLException
    {
        return sqlResult.isAfterLast();
    }

    public boolean isFirst () throws SQLException
    {
        return sqlResult.isFirst();
    }

    public Object getObject (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getObject(columnLabel);
    }

    public Object getObject (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getObject(columnLabel);
    }

    public String getString (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getString(columnLabel);
    }

    public String getString (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getString(columnLabel);
    }

    public boolean getBoolean (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getBoolean(columnLabel);
    }

    public boolean getBoolean (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getBoolean(columnLabel);
    }

    public byte getByte (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getByte(columnLabel);
    }

    public byte getByte (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getByte(columnLabel);
    }

    public short getShort (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getShort(columnLabel);
    }

    public short getShort (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getShort(columnLabel);
    }

    public int getInt (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getInt(columnLabel);
    }

    public int getInt (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getInt(columnLabel);
    }

    public long getLong (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getLong(columnLabel);
    }

    public long getLong (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getLong(columnLabel);
    }

    public float getFloat (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getFloat(columnLabel);
    }

    public float getFloat (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getFloat(columnLabel);
    }

    public double getDouble (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getDouble(columnLabel);
    }

    public double getDouble (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getDouble(columnLabel);
    }

    public byte[] getBytes (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getBytes(columnLabel);
    }

    public byte[] getBytes (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getBytes(columnLabel);
    }

    public Date getDate (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getDate(columnLabel);
    }

    public Date getDate (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getDate(columnLabel);
    }

    public Time getTime (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getTime(columnLabel);
    }

    public Time getTime (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getTime(columnLabel);
    }

    public Timestamp getTimestamp (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        return sqlResult.getTimestamp(columnLabel);
    }

    public Timestamp getTimestamp (int columnIndex) throws SQLException
    {
        String columnLabel = getColumnLabel(columnIndex);
        return getTimestamp(columnLabel);
    }

    public int getFetchDirection () throws SQLException
    {
        return FETCH_FORWARD;
    }

    public void setFetchDirection (int direction) throws SQLException
    {
        if (direction != FETCH_FORWARD)
            throw new SQLDataException("Invalid fetch direction specified. Only fetch forward is supported.");
    }

    public int getType () throws SQLException
    {
        return TYPE_FORWARD_ONLY;
    }

    public int getConcurrency () throws SQLException
    {
        return CONCUR_READ_ONLY;
    }

    /* -- internal supporting methods -- */

    private final String getColumnLabel (int index) throws SQLException
    {
        checkNotClosed();
        checkIndex(index);
        // columnNames is a List which starts indexing from zero
        // but columns are numbered from 1, so subtract 1 from the given index
        return columnNames.get(index - 1);
    }

    private void checkPosition () throws SQLException
    {
        checkNotClosed();
        if (sqlResult != null && !sqlResult.checkPosition())
        {
            throw new SQLException("you must call next() on a ResultSet first!");
        }
    }

    private void checkNotClosed () throws SQLException
    {
        if (columnNames == null)
            throw new SQLRecoverableException("Method invoked on a closed ResultSet");
    }

    private final void checkLabel (String columnLabel) throws SQLException
    {
        if (!columnNames.contains(columnLabel))
            throw new SQLSyntaxErrorException(String.format(
                    "The specified column %s is not found in the SQL query result.", columnLabel));
    }

    private final void checkIndex (int index) throws SQLException
    {
        // 1 <= index <= size()
        if (index < 1 || index > columnNames.size())
            throw new SQLSyntaxErrorException(String.format(
                    "The index %s must be a number >= 1 and less than %d the number of columns in the result.",
                    String.valueOf(index))
                    + " " + columnNames.size());
    }

}
