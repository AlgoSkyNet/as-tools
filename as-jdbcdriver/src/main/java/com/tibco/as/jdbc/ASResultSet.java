// -------------------------------------------------------------------
//  Copyright (c) 2012-2014 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.tibco.as.sql.ASSQLResult;

/**
 * ASResultSet contains the results of SQL queries against the ActiveSpaces data grid.
 * In general, these results are not scrollable as the data is contained in an
 * ASBrowser which only provides for moving forward thru the data by calling next()
 * on the browser.
 *
 * SQL query results will have: statement, sqlResult, resultMetaData, and columnNames.
 * SQL query results are best accessed using column labels/names.
 *
 * Currently, ASResultSet cannot be updated and the cursor moves forward only.
 * The Updater methods have not been implemented.
 *
 * For a description of what each of the methods does, see the JavaDoc for java.sql.ResultSet.
 */
public class ASResultSet extends AbstractResultSet implements ResultSet
{

    protected Statement           m_statement;       // the Statement object that produced this result
    protected ASSQLResult         m_sqlResult;       // the result generated from processing the SQL query
    protected ASResultSetMetaData m_resultMetaData;  // the meta data describing the results

    // The names of the fields/columns in the result tuples which has
    // been ordered according to the order specified in the SQL statement.
    // In the case of non-queries, the column names will correspond to what
    // the JDBC interface requires of the result.
    protected List<String>        m_columnNames;

    protected int                 m_rowCounter = 0;
    protected boolean             m_lastValueNull = false;

    protected int                 m_fetchDirection = FETCH_FORWARD;
    protected int                 m_rsType = TYPE_FORWARD_ONLY;
    protected int                 m_concurrency = CONCUR_READ_ONLY;

    public ASResultSet (ASSQLResult inResult, Statement statement) throws SQLException
    {
        // This constructor is used to populate the result set based
        // upon the results of an SQL statement being executed
        if (inResult == null)
            throw new SQLDataException("Missing query result parameter.");
        if (statement == null)
            throw new SQLDataException("Missing SQL statement parameter.");
        m_sqlResult = inResult;
        m_statement = statement;
        m_columnNames = inResult.getQueryColumnNames();
        if (m_columnNames == null)
            throw new SQLSyntaxErrorException("Invalid query string passed for processing.");
        m_resultMetaData = new ASResultSetMetaData(inResult);
    }

    protected ASResultSet()
    {
        // needed for derived classes
    }

    public void close () throws SQLException
    {
        m_columnNames = null;
        if (m_sqlResult != null)
            m_sqlResult.close();
        m_sqlResult = null;
        m_statement = null;
        m_rowCounter = 0;
    }

    public Statement getStatement () throws SQLException
    {
        return m_statement;
    }

    public ResultSetMetaData getMetaData () throws SQLException
    {
        return m_resultMetaData;
    }

    public boolean isClosed () throws SQLException
    {
        return m_columnNames == null ? true : false;
    }

    /**
     * Moves the cursor forward one row from its current position. A <code>ResultSet</code> cursor
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
        if (m_sqlResult != null)
        {
            result = m_sqlResult.next();
            if (result == true)
                m_rowCounter++;
        }
        return result;
    }

    public boolean isBeforeFirst () throws SQLException
    {
        boolean bresult = true;
        if (m_sqlResult != null)
            bresult = m_sqlResult.isBeforeFirst();
        return bresult;
    }

    public void beforeFirst () throws SQLException
    {
        if (getType() == TYPE_FORWARD_ONLY)
            throw new SQLFeatureNotSupportedException();
        else
            m_rowCounter = 0;
    }

    public boolean first () throws SQLException
    {
        checkNotClosed();
        if (getType() == TYPE_FORWARD_ONLY)
            throw new SQLFeatureNotSupportedException();
        // by default return false the above exception should be thrown
        return false;
    }

    public int getRow () throws SQLException
    {
        return m_rowCounter;
    }

    public int findColumn (String columnLabel) throws SQLException
    {
        checkNotClosed();
        // no need to check the column label as we are basically doing the
        // same thing in this method, if the label isn't found an exception
        // is thrown

        int index = 0;
        boolean found = false;
        for (int i=0; i<m_columnNames.size(); i++)
        {
            // need to check using lowercase as column labels are case insensitive
            // and we don't know the case of the columnNames list
            if (m_columnNames.get(i).toLowerCase().equals(columnLabel.toLowerCase()))
            {
                // add 1 to the index of the column name since columns are numbered from 1
                // but Lists are indexed from 0
                index = i + 1;
                found = true;
                break;
            }
        }
        if (!found)
        {
            throw new SQLException(String.format(
                    "The specified column %s is not found in the result set.", columnLabel));
        }
        return index;
    }

    // Did the last column that was read have a value of null
    public boolean wasNull () throws SQLException
    {
        boolean bresult = false;
        if (m_sqlResult != null)
            bresult = m_sqlResult.wasLastValueNull();
        return bresult;
    }

    public boolean isAfterLast () throws SQLException
    {
        boolean bresult = false;
        if (m_sqlResult != null)
            bresult = m_sqlResult.isAfterLast();
        return bresult;
    }

    public boolean isFirst () throws SQLException
    {
        boolean bresult = false;
        if (m_sqlResult != null)
            bresult = m_sqlResult.isFirst();
        return bresult;
    }

    public Object getObject (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            return m_sqlResult.getObject(columnLabel);
        else
            return null;
    }

    public Object getObject (int columnIndex) throws SQLException
    {
        Object result = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            result = getObject(columnLabel);
        }
        return result;
    }

    public String getString (String columnLabel) throws SQLException
    {
        String result = null;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            result = m_sqlResult.getString(columnLabel);
        return result;
    }

    public String getString (int columnIndex) throws SQLException
    {
        String result = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            result = getString(columnLabel);
        }
        return result;
    }

    public boolean getBoolean (String columnLabel) throws SQLException
    {
        boolean bresult = false;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            bresult = m_sqlResult.getBoolean(columnLabel);
        return bresult;
    }

    public boolean getBoolean (int columnIndex) throws SQLException
    {
        boolean bresult = false;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            bresult = getBoolean(columnLabel);
        }
        return bresult;
    }

    public byte getByte (String columnLabel) throws SQLException
    {
        byte result = 0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            result = m_sqlResult.getByte(columnLabel);
        return result;
    }

    public byte getByte (int columnIndex) throws SQLException
    {
        byte bresult = 0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            bresult = getByte(columnLabel);
        }
        return bresult;
    }

    public short getShort (String columnLabel) throws SQLException
    {
        short sresult = (short)0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            sresult = m_sqlResult.getShort(columnLabel);
        return sresult;
    }

    public short getShort (int columnIndex) throws SQLException
    {
        short sresult = (short)0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            sresult = getShort(columnLabel);
        }
        return sresult;
    }

    public int getInt (String columnLabel) throws SQLException
    {
        int iresult = (int)0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            iresult = m_sqlResult.getInt(columnLabel);
        return iresult;
    }

    public int getInt (int columnIndex) throws SQLException
    {
        int iresult = 0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            iresult = m_sqlResult.getInt(columnLabel);
        }
        return iresult;
    }

    public long getLong (String columnLabel) throws SQLException
    {
        long lresult = (long)0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            lresult = m_sqlResult.getLong(columnLabel);
        return lresult;
    }

    public long getLong (int columnIndex) throws SQLException
    {
        long lresult = (long)0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            lresult = m_sqlResult.getLong(columnLabel);
        }
        return lresult;
    }

    public float getFloat (String columnLabel) throws SQLException
    {
        float fresult = (float)0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            fresult = m_sqlResult.getFloat(columnLabel);
        return fresult;
    }

    public float getFloat (int columnIndex) throws SQLException
    {
        float fresult = (float)0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            fresult = m_sqlResult.getFloat(columnLabel);
        }
        return fresult;
    }

    public double getDouble (String columnLabel) throws SQLException
    {
        double dresult = (double)0;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            dresult = m_sqlResult.getDouble(columnLabel);
        return dresult;
    }

    public double getDouble (int columnIndex) throws SQLException
    {
        double dresult = (double)0;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            dresult = m_sqlResult.getDouble(columnLabel);
        }
        return dresult;
    }

    public byte[] getBytes (String columnLabel) throws SQLException
    {
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
            return m_sqlResult.getBytes(columnLabel);
        return null;
    }

    public byte[] getBytes (int columnIndex) throws SQLException
    {
        byte[] bresult = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            bresult = getBytes(columnLabel);
        }
        return bresult;
    }

    public Date getDate (String columnLabel) throws SQLException
    {
        Date date = null;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
        {
            date = m_sqlResult.getDate(columnLabel);
        }
        return date;
    }

    public Date getDate (int columnIndex) throws SQLException
    {
        Date date = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            date = getDate(columnLabel);
        }
        return date;
    }

    public Time getTime (String columnLabel) throws SQLException
    {
        Time time = null;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
        {
            time = m_sqlResult.getTime(columnLabel);
        }
        return time;
    }

    public Time getTime (int columnIndex) throws SQLException
    {
        Time time = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            time = getTime(columnLabel);
        }
        return time;
    }

    public Timestamp getTimestamp (String columnLabel) throws SQLException
    {
        Timestamp ts = null;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
        {
            ts = m_sqlResult.getTimestamp(columnLabel);
        }
        return ts;
    }

    public Timestamp getTimestamp (int columnIndex) throws SQLException
    {
        Timestamp ts = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            ts = getTimestamp(columnLabel);
        }
        return ts;
    }

    public Blob getBlob (String columnLabel) throws SQLException
    {
        Blob blob = null;
        checkPosition();
        checkLabel(columnLabel);
        if (m_sqlResult != null)
        {
            blob = m_sqlResult.getBlob(columnLabel);
        }
        return blob;
    }

    public Blob getBlob (int columnIndex) throws SQLException
    {
        Blob blob = null;
        if (m_sqlResult != null)
        {
            String columnLabel = getColumnLabel(columnIndex);
            blob = getBlob(columnLabel);
        }
        return blob;
    }

    public int getFetchDirection () throws SQLException
    {
        return m_fetchDirection;
    }

    public void setFetchDirection (int direction) throws SQLException
    {
        checkNotClosed();
        if (direction != FETCH_FORWARD)
            throw new SQLDataException("Invalid fetch direction specified. Only fetch forward is supported.");
    }

    public int getType () throws SQLException
    {
        return m_rsType;
    }

    public int getConcurrency () throws SQLException
    {
        return m_concurrency;
    }

    /* -- internal supporting methods -- */

    protected final String getColumnLabel (int index) throws SQLException
    {
        checkNotClosed();
        checkIndex(index);
        // columnNames is a List which starts indexing from zero
        // but columns are numbered from 1, so subtract 1 from the given index
        return m_columnNames.get(index - 1);
    }

    protected void checkPosition () throws SQLException
    {
        checkNotClosed();
        if (m_sqlResult != null && !m_sqlResult.checkPosition())
        {
            throw new SQLException("you must call next() on a ResultSet first!");
        }
    }

    protected void checkNotClosed () throws SQLException
    {
        if (m_columnNames == null)
            throw new SQLRecoverableException("Method invoked on a closed ResultSet");
    }

    protected final void checkLabel (String columnLabel) throws SQLException
    {
        boolean found = false;
        // column labels are case insensitive, so try checking the column names
        // against the given column label in lower case
        for (int i=0; i<m_columnNames.size(); i++)
        {
            if (m_columnNames.get(i).toLowerCase().equals(columnLabel.toLowerCase()))
                found = true;
        }
        if (!found)
            throw new SQLException(String.format(
                    "The specified column %s is not found in the result set.", columnLabel));
    }

    protected final void checkIndex (int index) throws SQLException
    {
        // 1 <= index <= size()
        if (index < 1 || index > m_columnNames.size())
            throw new SQLException(String.format(
                    "The index %s must be a number >= 1 and less than %d the number of columns in the result.",
                    String.valueOf(index))
                    + " " + m_columnNames.size());
    }

}
