// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.tibco.as.space.ASException;
import com.tibco.as.space.ASStatus;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.SpaceResultList;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.browser.Browser;
import com.tibco.as.space.browser.BrowserDef;
import com.tibco.as.space.browser.BrowserDef.BrowserType;
import com.tibco.as.space.browser.BrowserDef.TimeScope;

public class SelectStatement implements ASSQLQueryStatement
{
    protected List<String>              spaceNames;
    protected List<Tuple>               columnInfo;
    protected HashMap<String, FieldDef> columnSpec;
    protected String                    filter;
    protected String                    quantifier;
    protected String                    currentSpaceName;

    public SelectStatement (String quantifier, List<Tuple> columnInfo, List<String> tableNames, String filter)
    {
        this.quantifier = quantifier;
        this.columnInfo = columnInfo;
        this.spaceNames = tableNames;
        this.filter = filter;
        // uncomment the following to help debugging filters
        //if (filter != null)
        //    System.out.println("filter: " + filter);
    }

    public ASSQLResult processQuery (Metaspace metaspace) throws SQLException
    {
        ASSQLResult result = null;
        try
        {
            // check to make sure we have space info for each column info entry
            checkSpaceInfo();

            // if we have * for the columns, replace with all of the columns in
            // the space
            this.columnInfo = checkColumnAsterisk(metaspace);

            // now initialize our map of column aliases and FieldDefs
            columnSpec = ASSQLUtils.getColumnSpec(metaspace, this.columnInfo);

            int ssize = this.spaceNames.size();
            if (ssize == 1 && filter != null)
            {
                // if we have a single space and a filter, check to see if we can do a simple
                // get of the data in the space versus browsing the space
                SpaceResultList tuples = getTupleList(metaspace, this.spaceNames.get(0), filter, columnSpec);
                if (tuples != null && !tuples.isEmpty())
                    result = new ASSQLResult(spaceNames, tuples, columnInfo, columnSpec);
            }
            if (result == null)
            {
                // for each space, get a browser for the space which retrieves the
                // appropriate rows from the space
                List<Browser> blist = new ArrayList<Browser>();

                for (int i = 0; i < ssize; i++)
                {
                    String spaceName = this.spaceNames.get(i);
                    Space space = metaspace.getSpace(spaceName);
                    Browser browser = null;
                    if (this.filter != null && i == 0)
                    {
                        // if we have a filter, use it on the first space only
                        // we don't support filters for multiple spaces at this time
                        browser = space.browse(BrowserType.GET, BrowserDef.create(0, TimeScope.SNAPSHOT), filter);
                    }
                    else
                        browser = space.browse(BrowserType.GET, BrowserDef.create(0, TimeScope.SNAPSHOT));
                    blist.add(browser);
                }
                // now store the results
                result = new ASSQLResult(spaceNames, blist, columnInfo, columnSpec);
            }
        }
        catch (ASException ex)
        {
            throw new SQLException(ex);
        }
        return result;
    }

    protected void checkSpaceInfo () throws ASException
    {
        // start building up the information needed for each column's metadata
        // for each column we need: database name, table name, column name,
        // column alias (optional), column field def
        // if we don't have a column alias, use the column name for the column
        // alias
        if (this.columnInfo == null || this.columnInfo.isEmpty())
        {
            throw new ASException(ASStatus.NOT_FOUND, "Missing list of columns for SELECT statement.");
        }

        // ensure each column already has an associated table name
        int csize = this.columnInfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple cinfo = columnInfo.get(i);
            String cname = cinfo.getString(ASSQLUtils.COLUMN_NAME);
            String tname = cinfo.getString(ASSQLUtils.TABLE_NAME);
            if (tname == null || tname.isEmpty())
            {
                if (this.spaceNames.isEmpty())
                    throw new ASException(ASStatus.NOT_FOUND, "Cannot find space name for column: "
                            + cinfo.getString(ASSQLUtils.COLUMN_NAME));
                else
                {
                    // for each column listed without a table name, we want to
                    // give it a table name from our table name list
                    // if more than one table is in the table name list, add
                    // entries to the column info list for each table after the first table
                    // for SELECT * FROM table1, table2, ... we want to end up
                    // with entries equivalent to table1.*, table2.*, ... in our column info
                    // for SELECT user FROM table1, table2, ... we do the same
                    // as for * but the result set will not be able to retrieve anything
                    // but the first user and table (we do what the user is asking even though it
                    // is not correct)
                    int ssize = this.spaceNames.size();
                    for (int j = 0; j < ssize; j++)
                    {
                        String sname = this.spaceNames.get(j);
                        // the first time thru, replace the existing tuple
                        if (j == 0)
                        {
                            cinfo.put(ASSQLUtils.TABLE_NAME, sname);
                            columnInfo.set(i, cinfo);
                        }
                        else
                        {
                            // for any subsequent times thru, add new tuples to the existing list
                            // so if we had * for the column name with FROM table1, table2, ...
                            // we end up with additional * entries for table2, ...
                            Tuple tuple = (Tuple) cinfo.clone();
                            tuple.put(ASSQLUtils.TABLE_NAME, sname);
                            columnInfo.add(tuple);
                        }
                    }
                }
            }
            else
            {
                // ensure table name is in the space name list
                if (!this.spaceNames.contains(tname))
                {
                    throw new ASException(ASStatus.NOT_FOUND, "Cannot find matching FROM table for column: " + tname
                            + "." + cname);
                }
            }
        }
    }

    protected List<Tuple> checkColumnAsterisk (Metaspace metaspace) throws ASException
    {
        List<Tuple> result = new ArrayList<Tuple>();
        String mname = metaspace.getName();
        // finish building up our metadata; if an * has been specified for the column name
        // retrieve the column names from the space and add those columns to the list
        // for all columns, add the metaspace name
        int csize = this.columnInfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple cinfo = columnInfo.get(i);
            // add the metaspace name to the column info
            cinfo.put(ASSQLUtils.METASPACE_NAME, mname);

            // now check the columns for *
            String cname = cinfo.getString(ASSQLUtils.COLUMN_NAME);
            String calias = cinfo.getString(ASSQLUtils.COLUMN_ALIAS);
            if (cname.equals("*"))
            {
                // we need to get the names of each of the fields from the space
                String tname = cinfo.getString(ASSQLUtils.TABLE_NAME);
                Space space = metaspace.getSpace(tname);
                Iterator<FieldDef> iter = space.getSpaceDef().getFieldDefs().iterator();
                while (iter.hasNext())
                {
                    cname = iter.next().getName();
                    Tuple tuple = Tuple.create();
                    tuple.put(ASSQLUtils.COLUMN_NAME, cname);
                    tuple.put(ASSQLUtils.METASPACE_NAME, mname);
                    tuple.put(ASSQLUtils.TABLE_NAME, tname);
                    // for * we won't have any aliases, so set the alias to the column name
                    // this allows us to always use the alias for retrieving columns without
                    // first checking for it to be null and then using the column name
                    tuple.put(ASSQLUtils.COLUMN_ALIAS, cname);
                    result.add(tuple);
                }
            }
            else
            {
                // if there isn't an alias, set the alias to the column name
                // this allows us to use the alias without always checking for
                // it to be null
                if (calias == null || calias.isEmpty())
                {
                    calias = cname;
                    cinfo.put(ASSQLUtils.COLUMN_ALIAS, calias);
                }
                // add the tuple into our result list
                result.add(cinfo);
            }
        }
        return result;
    }

    protected void initColumnSpec (Metaspace metaspace) throws ASException
    {
        columnSpec = new HashMap<String, FieldDef>();
        int csize = columnInfo.size();
        for (int i = 0; i < csize; i++)
        {
            Tuple cinfo = columnInfo.get(i);
            String cname = cinfo.getString(ASSQLUtils.COLUMN_NAME);
            String calias = cinfo.getString(ASSQLUtils.COLUMN_ALIAS);
            String tname = cinfo.getString(ASSQLUtils.TABLE_NAME);
            SpaceDef spaceDef = metaspace.getSpaceDef(tname);
            // store the FieldDef under the alias since columns from two
            // different tables could have the same names, but the alias
            // should uniquely identify them
            columnSpec.put(calias, spaceDef.getFieldDef(cname));
        }
    }

    protected SpaceResultList getTupleList (Metaspace metaspace, String spaceName, String filter,
            HashMap<String, FieldDef> columnSpec)
    {
        // we have a single space and a filter, check to see if we can do a simple
        // get of the data in the space versus browsing the space
        // if anything goes wrong, just return null so that the caller
        // will end up browsing the space instead
        SpaceResultList tuples = null;
        try
        {
            Space space = metaspace.getSpace(spaceName);
            Collection<String> keyfields = space.getSpaceDef().getKeyDef().getFieldNames();
            HashMap<String, String> keyMap = ASSQLUtils.getKeyValues(keyfields, filter);
            if (keyMap != null && !keyMap.isEmpty())
            {
                // set up to do a batch get
                ArrayList<Tuple> keytuples = new ArrayList<Tuple>();
                Iterator<Entry<String, String>> iter = keyMap.entrySet().iterator();
                while (iter.hasNext())
                {
                    Entry<String, String> entry = iter.next();
                    String fieldName = entry.getKey();
                    String fieldValue = entry.getValue();
                    FieldDef fieldDef = columnSpec.get(fieldName);
                    // check string fields to make sure they are enclosed in quotes
                    // if not, the filter wasn't a clean assignment of a field to a string
                    if (fieldDef.getType() == FieldDef.FieldType.STRING)
                    {
                        if (!(fieldValue.startsWith("\"") && fieldValue.endsWith("\"")))
                        {
                            if (keytuples != null)
                            {
                                keytuples.clear();
                                keytuples = null;
                            }
                            break;
                        }
                        else
                        {
                            // when selecting tuples from a space we need to strip the quotes
                            // from the key tuple value even if it contains a space or single quote
                            fieldValue = removeQuotesFromString(fieldValue);
                        }
                    }
                    Tuple tuple = Tuple.create();
                    TypeUtil.setTupleField (tuple, fieldDef, fieldName, fieldValue);
                    keytuples.add(tuple);
                }
                if (keytuples != null && !keytuples.isEmpty())
                {
                    // now retrieve the tuples we were given key values for
                    // TODO is doing a getAll more expensive than doing a get when we only have
                    //      one key?
                    SpaceResultList list = space.getAll(keytuples);
                    if (!list.hasError() && list.size() > 0)
                        tuples = list;  // only return the results if there was no error
                }
            }
        }
        catch (Exception ex)
        {
            // do nothing just return null so browser will be used
        }
        return tuples;
    }

    public String removeQuotesFromString (String sval)
    {
        String result = null;
        if (sval != null && !sval.isEmpty())
        {
            if (sval.startsWith("\"") && sval.endsWith("\""))
            {
                result = sval.substring(1, sval.length() - 1);
            }
        }
        return result;
    }

}
