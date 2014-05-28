// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.sql;

import java.nio.ByteBuffer;
import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.tibco.as.space.DateTime;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Tuple;

/**
 * The ASSQLTuple class constructs a tuple which contains only those fields which were specified to
 * be in the SQL result. The columnInfo list contains this list of fields in the order they should
 * appear.
 *
 */
public class ASSQLTuple
{
    private Tuple   tuple;
    // holds whether the last value retrieved from the Tuple was null
    private boolean wasNull = true;

    public ASSQLTuple (List<String> spaceList, List<Tuple> tupleList, List<Tuple> columnInfo,
            Map<String, FieldDef> columnSpec) throws IllegalArgumentException
    {
        tuple = getTuple(spaceList, tupleList, columnInfo, columnSpec);
    }

    public boolean wasLastValueNull ()
    {
        return wasNull;
    }

    /**
     * Retrieves the values of the designated column from the Tuple as an <code>Object</code> in the
     * Java programming language.
     * <P>
     * If the column value is null, null is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as an Object
     * @throws SQLException
     *             if the fieldName is not valid
     */
    public Object getObject (String fieldName) throws SQLException
    {
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        return value;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>String</code> in the
     * Java programming language.
     * <P>
     * If the column value is null, null is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a String
     * @exception SQLException
     *                if the fieldName is not valid
     */
    public String getString (String fieldName) throws SQLException
    {
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        return (wasNull) ? null : value.toString();
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>boolean</code> in the
     * Java programming language.
     * <P>
     * If the field value is null, <code>false</code> is returned. If the field value is a string of
     * "0" or "false", <code>false</code> is returned. If the field value is a number with the value
     * 0, <code>false</code> is returned. If the field value is a string of "1" or "true",
     * <code>true</code> is returned. If the field value is a number with the value 1,
     * <code>true</code> is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a boolean
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a boolean.
     *
     */
    public boolean getBoolean (String fieldName) throws SQLException
    {
        boolean result = false;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = false;
        else if (value instanceof Boolean)
            result = (Boolean) value;
        else if (value instanceof Character && ((Character) value).equals('0'))
            result = false;
        else if (value instanceof Character && ((Character) value).equals('1'))
            result = true;
        else if (value instanceof String && ((String) value).equals("0"))
            result = false;
        else if (value instanceof String && ((String) value).equals("1"))
            result = true;
        else if (value instanceof String && ((String) value).equalsIgnoreCase("false"))
            result = false;
        else if (value instanceof String && ((String) value).equalsIgnoreCase("true"))
            result = true;
        else if (value instanceof Short && ((Short) value) == 0)
            result = false;
        else if (value instanceof Short && ((Short) value) == 1)
            result = true;
        else if (value instanceof Integer && ((Integer) value) == 0)
            result = false;
        else if (value instanceof Integer && ((Integer) value) == 1)
            result = true;
        else if (value instanceof Long && ((Long) value) == 0)
            result = false;
        else if (value instanceof Long && ((Long) value) == 1)
            result = true;
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a boolean.");

        return result;
    }

    /**
     * Retrieves the value of the specified field as a <code>byte</code> in the Java programming
     * language.
     * <P>
     * If the field value is null, <code>0</code> is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a byte
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a byte.
     */
    public byte getByte (String fieldName) throws SQLException
    {
        byte result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).byteValue();
        else if (value instanceof Integer)
            result = ((Integer) value).byteValue();
        else if (value instanceof Long)
            result = ((Long) value).byteValue();
        else if (value instanceof Float)
            result = ((Float) value).byteValue();
        else if (value instanceof Double)
            result = ((Double) value).byteValue();
        else if (value instanceof Character)
        {
            try
            {
                result = Byte.parseByte(((Character) value).toString());
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else if (value instanceof String)
        {
            try
            {
                result = Byte.parseByte((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a byte.");
        return result;
    }

    /**
     * Retrieves the value of the specified field as a <code>short</code> in the Java programming
     * language.
     * <P>
     * If the field value is null, <code>0</code> is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a short
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a short.
     */
    public short getShort (String fieldName) throws SQLException
    {
        short result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).shortValue();
        else if (value instanceof Integer)
            result = ((Integer) value).shortValue();
        else if (value instanceof Long)
            result = ((Long) value).shortValue();
        else if (value instanceof Float)
            result = ((Float) value).shortValue();
        else if (value instanceof Double)
            result = ((Double) value).shortValue();
        else if (value instanceof Character)
        {
            try
            {
                result = Short.parseShort(((Character) value).toString());
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else if (value instanceof String)
        {
            try
            {
                result = Short.parseShort((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a short.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as an <code>int</code> in the
     * Java programming language.
     *
     * If the field value is null, <code>0</code> is returned.
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as an int
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as an int.
     */
    public int getInt (String fieldName) throws SQLException
    {
        int result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).intValue();
        else if (value instanceof Integer)
            result = ((Integer) value).intValue();
        else if (value instanceof Long)
            result = ((Long) value).intValue();
        else if (value instanceof Float)
            result = ((Float) value).intValue();
        else if (value instanceof Double)
            result = ((Double) value).intValue();
        else if (value instanceof Character)
        {
            try
            {
                result = Integer.parseInt(((Character) value).toString());
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else if (value instanceof String)
        {
            try
            {
                result = Integer.parseInt((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }

        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as an int.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>long</code> in the
     * Java programming language.
     *
     * If the field value is null, <code>0</code> is returned.
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a long
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a long.
     */
    public long getLong (String fieldName) throws SQLException
    {
        long result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).longValue();
        else if (value instanceof Integer)
            result = ((Integer) value).longValue();
        else if (value instanceof Long)
            result = ((Long) value).longValue();
        else if (value instanceof Float)
            result = ((Float) value).longValue();
        else if (value instanceof Double)
            result = ((Double) value).longValue();
        else if (value instanceof Character)
        {
            try
            {
                result = Long.parseLong(((Character) value).toString());
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }
        }
        else if (value instanceof String)
        {
            try
            {
                result = Long.parseLong((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }
        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a long.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>float</code> in the
     * Java programming language.
     *
     * If the field value is null, <code>0</code> is returned.
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a float
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a float.
     */
    public float getFloat (String fieldName) throws SQLException
    {
        float result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).floatValue();
        else if (value instanceof Integer)
            result = ((Integer) value).floatValue();
        else if (value instanceof Long)
            result = ((Long) value).floatValue();
        else if (value instanceof Float)
            result = ((Float) value).floatValue();
        else if (value instanceof Double)
            result = ((Double) value).floatValue();
        else if (value instanceof String)
        {
            try
            {
                result = Float.parseFloat((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }
        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a float.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>double</code> in the
     * Java programming language.
     *
     * If the field value is null, <code>0</code> is returned.
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a double
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a double.
     */
    public double getDouble (String fieldName) throws SQLException
    {
        double result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = 0;
        else if (value instanceof Short)
            result = ((Short) value).doubleValue();
        else if (value instanceof Integer)
            result = ((Integer) value).doubleValue();
        else if (value instanceof Long)
            result = ((Long) value).doubleValue();
        else if (value instanceof Float)
            result = ((Float) value).doubleValue();
        else if (value instanceof Double)
            result = ((Double) value).doubleValue();
        else if (value instanceof String)
        {
            try
            {
                result = Double.parseDouble((String) value);
            }
            catch (NumberFormatException ex)
            {
                throw new SQLDataException(ex);
            }
        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a double.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as a <code>byte</code> array in
     * the Java programming language.
     *
     * If the field value is null, <code>null</code> is returned.
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a byte array
     * @exception SQLException
     *                if the fieldName is not valid or the field cannot be returned as a byte array.
     */
    public byte[] getBytes (String fieldName) throws SQLException
    {
        byte[] result;
        Object value = tuple.get(fieldName);
        wasNull = value == null;
        if (wasNull)
            result = null;
        else if (value instanceof Short)
        {
            ByteBuffer buffer = ByteBuffer.allocate(2);
            buffer.putShort((Short) value);
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof Integer)
        {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt((Integer) value);
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof Long)
        {
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putLong((Long) value);
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof Float)
        {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putFloat((Float) value);
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof Double)
        {
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putDouble((Double) value);
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof Character)
        {
            ByteBuffer buffer = ByteBuffer.allocate(2);
            buffer.putChar(((Character) value).charValue());
            buffer.flip();
            result = buffer.array();
        }
        else if (value instanceof String)
        {
            result = ((String) value).getBytes();
        }
        else
            throw new SQLDataException("The " + value.getClass().getSimpleName() + " value in field " + fieldName
                    + " cannot be returned as a byte array.");
        return result;
    }

    /**
     * Retrieves the value of the designated column from the Tuple as an SQL <code>Date</code>
     * object.
     * <P>
     * If the column value is null, null is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a String
     * @exception SQLException
     *                if the fieldName is not valid
     */
    public Date getDate (String fieldName) throws SQLException
    {
        DateTime dt = tuple.getDateTime(fieldName);
        wasNull = dt == null;
        return (wasNull) ? null : new Date(dt.getTime().getTimeInMillis());
    }

    /**
     * Retrieves the value of the designated column from the Tuple as an SQL <code>Time</code>
     * object.
     * <P>
     * If the column value is null, null is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a String
     * @exception SQLException
     *                if the fieldName is not valid
     */
    public Time getTime (String fieldName) throws SQLException
    {
        DateTime dt = tuple.getDateTime(fieldName);
        wasNull = dt == null;
        // milliseconds should be since January 1, 1970, 00:00:00 GMT
        // this is the same for SQL Time object or AS DateTime object
        return (wasNull) ? null : new Time(dt.getTime().getTimeInMillis());
    }

    /**
     * Retrieves the value of the designated column from the Tuple as an SQL <code>Timestamp</code>
     * object.
     * <P>
     * If the column value is null, null is returned.
     * <P>
     *
     * @param fieldName
     *            the name of the tuple field to return
     * @return the field value as a String
     * @exception SQLException
     *                if the fieldName is not valid
     */
    public Timestamp getTimestamp (String fieldName) throws SQLException
    {
        DateTime dt = tuple.getDateTime(fieldName);
        wasNull = dt == null;
        // milliseconds should be since January 1, 1970, 00:00:00 GMT
        // this is the same for SQL Timestamp object or AS DateTime object
        return (wasNull) ? null : new Timestamp(dt.getTime().getTimeInMillis());
    }

    // ---- internal helper methods ----
    private Tuple getTuple (List<String> spaceList, List<Tuple> tupleList, List<Tuple> columnInfo,
            Map<String, FieldDef> columnSpec) throws IllegalArgumentException
    {
        // we need to create a tuple which holds only those fields from each
        // space that is designated in the columnInfo object
        tuple = Tuple.create();
        int numColumns = columnInfo.size();
        for (int i = 0; i < numColumns; i++)
        {
            String columnName = columnInfo.get(i).getString(ASSQLUtils.COLUMN_NAME);
            String columnAlias = columnInfo.get(i).getString(ASSQLUtils.COLUMN_ALIAS);
            String spaceName = columnInfo.get(i).getString(ASSQLUtils.TABLE_NAME);
            FieldDef fieldDef = columnSpec.get(columnAlias);
            // get the tuple for the space
            int spaceIndex = spaceList.indexOf(spaceName);
            Tuple stuple = tupleList.get(spaceIndex);
            // retrieve the value for the column, null if no value is available
            Object columnValue = null;
            if (stuple.size() != 0)
            {
                // get the value for the column
                // we use the column name here vs the column alias as the tuple is
                // from a space browser which will not know the column alias but
                // only the column name and the column name is unique to the space
                columnValue = stuple.get(columnName);
            }
            // else if we had an empty tuple, we fill the column with null, if the column
            // is nullable. If the column is not nullable, an exception is thrown since
            // the SQL query is invalid.

            // add a column entry to our main tuple
            // we always use the column alias when creating our result tuple
            // if the SQL statement didn't specify an alias for a column, the
            // column name was filled in as the alias
            TypeUtil.setTupleField(tuple, fieldDef, columnAlias, columnValue);
        }
        return tuple;
    }
}
