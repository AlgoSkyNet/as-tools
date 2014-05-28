// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.sql;

import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.SpaceResult;
import com.tibco.as.space.SpaceResultList;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.browser.Browser;

public class ASSQLResult
{
    // the simplest result just contains the count of rows affected by an SQL query statement
    // the name of the table/space, and the columns in the row which were affected
    protected int                   queryUpdateCount = -1;
    protected List<String>          queryColumnNames;
    protected List<Tuple>           queryColumnInfo;

    // results which return data contain the table/space information, the rows of data (contained
    // in the AS browser or an ArrayList for simple queries which can be performed as gets), the
    // name and type of each column
    protected List<String>          querySpaceNames;
    protected List<Browser>         queryBrowserList;
    protected SpaceResultList       queryTupleList;
    protected Map<String, FieldDef> queryColumnSpec;

    protected ASSQLTuple            currentTuple;
    protected boolean               queryBeforeFirst = true;
    protected boolean               queryAfterLast   = false;
    protected boolean               queryIsFirst     = false;

    public ASSQLResult (String spaceName, int updateCount, List<Tuple> cinfo, Map<String, FieldDef> cspec)
    {
        // constructor used when SQL query statements do not return data from the database
        querySpaceNames = new ArrayList<String>();
        querySpaceNames.add(spaceName);
        queryUpdateCount = updateCount;
        queryColumnInfo = cinfo;
        queryColumnNames = getColumnNameList(cinfo);
        queryColumnSpec = cspec;
    }

    public ASSQLResult (List<String> snames, List<Browser> browsers, List<Tuple> cinfo, Map<String, FieldDef> cspec)
    {
        querySpaceNames = snames;
        queryBrowserList = browsers;
        queryColumnInfo = cinfo;
        queryColumnSpec = cspec;
        queryColumnNames = new ArrayList<String>();
        int csize = queryColumnInfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple tuple = queryColumnInfo.get(i);
            String calias = tuple.getString(ASSQLUtils.COLUMN_ALIAS);
            queryColumnNames.add(calias);
        }
    }

    public ASSQLResult (List<String> snames, SpaceResultList tuples, List<Tuple> cinfo, Map<String, FieldDef> cspec)
    {
        querySpaceNames = snames;
        queryTupleList = tuples;
        queryColumnInfo = cinfo;
        queryColumnSpec = cspec;
        queryColumnNames = new ArrayList<String>();
        int csize = queryColumnInfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple tuple = queryColumnInfo.get(i);
            String calias = tuple.getString(ASSQLUtils.COLUMN_ALIAS);
            queryColumnNames.add(calias);
        }
    }

    public void close ()
    {
        try
        {
            if (queryBrowserList != null && !queryBrowserList.isEmpty())
            {
                int bsize = queryBrowserList.size();
                for (int i = 0; i < bsize; i++)
                    queryBrowserList.get(i).stop();
            }
        }
        catch (ASException ex)
        {
            // do nothing
        }
    }

    public int getQueryUpdateCount ()
    {
        return queryUpdateCount;
    }

    public List<String> getQueryColumnNames ()
    {
        return queryColumnNames;
    }

    public List<Tuple> getQueryColumnInfo ()
    {
        return queryColumnInfo;
    }

    public Map<String, FieldDef> getQueryColumnSpec ()
    {
        return queryColumnSpec;
    }

    public boolean checkPosition ()
    {
        boolean result = false;
        if ((queryTupleList != null || (queryBrowserList != null && !queryBrowserList.isEmpty()))
                && currentTuple != null)
            result = true;
        return result;
    }

    public boolean wasLastValueNull ()
    {
        return currentTuple.wasLastValueNull();
    }

    /**
     * Returns whether the cursor is before the first tuple in the result set.
     */
    public boolean isBeforeFirst ()
    {
        return queryBeforeFirst;
    }

    /**
     * Returns whether the cursor is after the last tuple in the result set.
     */
    public boolean isAfterLast ()
    {
        return queryAfterLast;
    }

    /**
     * Returns whether the current tuple is the first tuple in the result set.
     */
    public boolean isFirst ()
    {
        return queryIsFirst;
    }

    /**
     * Retrieves the next row of data.
     * <p>
     *
     * @return <code>true</code> if there is a new current row; <code>false</code> if there are no
     *         more rows
     * @exception SQLException
     *                if a space access error occurs
     */
    public boolean next () throws SQLException
    {
        boolean result = false;
        // holds all of the tuples which should be returned as a single row of data
        // e.g. one tuple from each space
        List<Tuple> tupleList = new ArrayList<Tuple>();

        // queryTupleList will be non-null when we were able to do a get on a single
        // space instead of having to create browsers to browse for tuples
        if (queryTupleList != null && !queryTupleList.isEmpty())
        {
            // get the first tuple in the results list and add it to our
            // tupleList, then remove it from the results list
            SpaceResult sresult = queryTupleList.get(0);
            Tuple tuple = sresult.getTuple();
            if (tuple != null)
            {
                tupleList.add(tuple);
                queryTupleList.remove(0);
            }
        }
        else if (queryBrowserList != null && !queryBrowserList.isEmpty())
        {
            // we have a list of spaces and we have a list of corresponding browsers
            // now get the next tuple from each browser
            // we end up with a list of tuples which have a 1-to-1 correspondence to
            // the list of spaces
            int bsize = queryBrowserList.size();
            for (int i = 0; i < bsize; i++)
            {
                Browser browser = queryBrowserList.get(i);
                try
                {
                    Tuple tuple = browser.next();
                    if (tuple != null)
                        tupleList.add(tuple);
                    else
                    {
                        // add an empty tuple as a place holder
                        // we will fill the columns for this space with null
                        // when we see an empty tuple
                        tuple = Tuple.create();
                        tupleList.add(tuple);
                    }
                }
                catch (ASException ex)
                {
                    // there was some kind of error accessing the database
                    // user should close the connection and retry the query
                    throw new SQLRecoverableException(ex);
                }
            }
        }
        if (isTupleListEmpty(tupleList))
        {
            currentTuple = null;
            queryBeforeFirst = false;
            queryIsFirst = false;
            queryAfterLast = true;
            tupleList.clear();
        }
        else
        {
            try
            {
                currentTuple = new ASSQLTuple(querySpaceNames, tupleList, queryColumnInfo, queryColumnSpec);
                if (queryBeforeFirst)
                {
                    queryIsFirst = true;
                    queryBeforeFirst = false;
                }
                else
                {
                    queryIsFirst = false;
                }
                result = true;
            }
            catch (IllegalArgumentException ex)
            {
                throw new SQLException(ex);
            }
        }
        return result;
    }

    public Object getObject (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getObject(fieldName);
    }

    public String getString (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getString(fieldName);
    }

    public Boolean getBoolean (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getBoolean(fieldName);
    }

    public byte getByte (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getByte(fieldName);
    }

    public short getShort (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getShort(fieldName);
    }

    public int getInt (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getInt(fieldName);
    }

    public long getLong (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getLong(fieldName);
    }

    public float getFloat (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getFloat(fieldName);
    }

    public double getDouble (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getDouble(fieldName);
    }

    public byte[] getBytes (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getBytes(fieldName);
    }

    public Date getDate (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getDate(fieldName);
    }

    public Time getTime (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getTime(fieldName);
    }

    public Timestamp getTimestamp (String fieldName) throws SQLException
    {
        checkFieldName(fieldName);
        checkCurrentTuple();
        return currentTuple.getTimestamp(fieldName);
    }

    /* -- Internal methods -- */

    private List<String> getColumnNameList (List<Tuple> cinfo)
    {
        List<String> result = new ArrayList<String>();
        int csize = cinfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple tuple = cinfo.get(i);
            String calias = tuple.getString(ASSQLUtils.COLUMN_ALIAS);
            result.add(calias);
        }
        return result;
    }

    private final void checkFieldName (String fieldName) throws SQLException
    {
        if (fieldName == null)
            throw new SQLDataException("Missing field name parameter.");
        if (!queryColumnNames.contains(fieldName))
            throw new SQLDataException("Invalid field name used.");
    }

    private final void checkCurrentTuple () throws SQLException
    {
        if (currentTuple == null)
            throw new SQLDataException("No data to read.");
    }

    private final boolean isTupleListEmpty (List<Tuple> tupleList)
    {
        boolean result = true;
        if (tupleList != null)
        {
            int lsize = tupleList.size();
            for (int i = 0; i < lsize; i++)
            {
                Tuple tuple = tupleList.get(i);
                if (tuple.size() != 0)
                    result = false;
            }
        }
        return result;
    }

}
