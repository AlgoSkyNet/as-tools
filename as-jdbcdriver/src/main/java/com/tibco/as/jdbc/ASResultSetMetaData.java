// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Tuple;
import com.tibco.as.sql.ASSQLResult;
import com.tibco.as.sql.ASSQLUtils;
import com.tibco.as.sql.TypeUtil;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Map;

public class ASResultSetMetaData extends AbstractResultSetMetaData implements ResultSetMetaData
{

    protected Map<String, FieldDef> columnSpec;
    protected List<Tuple>           columnInfo;

    public ASResultSetMetaData (ASSQLResult inResult)
    {
        columnSpec = inResult.getQueryColumnSpec();
        columnInfo = inResult.getQueryColumnInfo();
    }

    /**
     * Get the designated column's name.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return column name
     * @exception SQLException
     *                if a database access error occurs
     */
    public String getColumnName (int column) throws SQLException
    {
        Tuple cinfo = columnInfo.get(column - 1);
        return cinfo.getString(ASSQLUtils.COLUMN_NAME);
    }

    /**
     * Gets the designated column's suggested title for use in printouts and
     * displays. The suggested title is usually specified by the SQL
     * <code>AS</code> clause. If a SQL <code>AS</code> is not specified, the
     * value returned from <code>getColumnLabel</code> will be the same as the
     * value returned by the <code>getColumnName</code> method.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return the suggested column title
     * @exception SQLException
     *                if a database access error occurs
     */
    public String getColumnLabel (int column) throws SQLException
    {
        Tuple cinfo = columnInfo.get(column - 1);
        return cinfo.getString(ASSQLUtils.COLUMN_ALIAS);
    }

    /**
     * Retrieves the designated column's SQL type.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return SQL type from java.sql.Types
     * @exception SQLException
     *                if a database access error occurs
     */
    public int getColumnType (int column) throws SQLException
    {
        checkIndex(column);
        FieldDef fdef = getColumnFieldDef(column);
        return TypeUtil.getSQLType(fdef);
    }

    /**
     * Returns the number of columns in this <code>ResultSet</code> object.
     */
    public int getColumnCount () throws SQLException
    {
        return columnInfo.size();
    }

    /**
     * Indicates the nullability of values in the designated column.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return one of <code>columnNoNulls</code>, <code>columnNullable</code> or
     *         <code>columnNullableUnknown</code>
     * @exception SQLException
     *                if a database access error occurs
     */
    public int isNullable (int column) throws SQLException
    {
        checkIndex(column);
        FieldDef fdef = getColumnFieldDef(column);
        if (fdef.isNullable())
            return columnNullable;
        else
            return columnNoNulls;
    }

    /**
     * Indicates whether the designated column can be used in a where clause.
     *
     */
    public boolean isSearchable (int column) throws SQLException
    {
        checkIndex(column);
        return false;
    }

    /**
     * Retrieves the designated column's database-specific type name.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return type name used by the database. If the column type is a
     *         user-defined type, then a fully-qualified type name is returned.
     * @exception SQLException
     *                if a database access error occurs
     */
    public String getColumnTypeName (int column) throws SQLException
    {
        checkIndex(column);
        FieldDef fdef = getColumnFieldDef(column);
        return fdef.getType().toString();
    }

    /**
     * Gets the designated column's table name.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return table name or "" if not applicable
     * @exception SQLException
     *                if a database access error occurs
     */
    public String getTableName (int column) throws SQLException
    {
        checkIndex(column);
        Tuple cinfo = columnInfo.get(column - 1);
        return cinfo.getString(ASSQLUtils.TABLE_NAME);
    }

    /**
     * Gets the designated column's table's catalog name.
     *
     * @param column
     *            the first column is 1, the second is 2, ...
     * @return the name of the catalog for the table in which the given column
     *         appears or "" if not applicable
     * @exception SQLException
     *                if a database access error occurs
     */
    public String getCatalogName (int column) throws SQLException
    {
        checkIndex(column);
        Tuple cinfo = columnInfo.get(column - 1);
        return cinfo.getString(ASSQLUtils.METASPACE_NAME);
    }

    /* -- internal support methods -- */
    private FieldDef getColumnFieldDef (int i) throws SQLException
    {
        // The map of columns and field defs uses the column alias
        // with >1 table, there could be duplicate column names and aliases are supposed to be unique
        String calias = getColumnLabel(i);
        FieldDef fdef = columnSpec.get(calias);
        return fdef;
    }

    private final void checkIndex (int index) throws SQLException
    {
        // 1 <= index <= size()
        if (index < 1 || index > columnInfo.size())
            throw new SQLSyntaxErrorException(String.format(
                    "The index %s must be a number >= 1 and less than %d the number of columns in the result.",
                    String.valueOf(index))
                    + " " + columnInfo.size());
    }
}
