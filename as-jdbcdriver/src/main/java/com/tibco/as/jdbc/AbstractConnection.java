// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.sql.*;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * AbstractConnection contains all of the methods of the java.sql.Connection interface which are not
 * implemented by com.tibco.as.jdbc.ASConnection. As methods are added to ASConnection, they are
 * removed from this class. This makes it easier to keep track of what is not yet supported.
 */
abstract class AbstractConnection
{

    public <T> T unwrap (Class<T> iface) throws SQLException
    {
        System.out.println(" unwrap(Class<T>) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public boolean isWrapperFor (Class<?> iface) throws SQLException
    {
        System.out.println(" isWrapperFor(Class<?>) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql) throws SQLException
    {
        System.out.println(" prepareStatement(String) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public CallableStatement prepareCall (String sql) throws SQLException
    {
        System.out.println(" prepareCall(String) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void commit () throws SQLException
    {
        System.out.println(" commit() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void rollback () throws SQLException
    {
        System.out.println(" rollback() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void setCatalog (String catalog) throws SQLException
    {
        System.out.println(" setCatalog(String) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public String getCatalog () throws SQLException
    {
        System.out.println(" getCatalog() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void setTransactionIsolation (int level) throws SQLException
    {
        System.out.println(" setTransactionIsolation() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public int getTransactionIsolation () throws SQLException
    {
        System.out.println(" getTransactionIsolation() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException
    {
        System.out.println(" prepareStatement(String, int, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public CallableStatement prepareCall (String sql, int resultSetType, int resultSetConcurrency) throws SQLException
    {
        System.out.println(" prepareCall(String, int, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Map<String, Class<?>> getTypeMap () throws SQLException
    {
        System.out.println(" getTypeMap() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void setTypeMap (Map<String, Class<?>> map) throws SQLException
    {
        System.out.println(" setTypeMap(Map<String, Class<?>>) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Savepoint setSavepoint () throws SQLException
    {
        System.out.println(" setSavepoint() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Savepoint setSavepoint (String name) throws SQLException
    {
        System.out.println(" setSavepoint(String) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void rollback (Savepoint savepoint) throws SQLException
    {
        System.out.println(" rollback(Savepoint) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void releaseSavepoint (Savepoint savepoint) throws SQLException
    {
        System.out.println(" releaseSavepoint(Savepoint) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        System.out.println(" prepareStatement(String, int, int, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public CallableStatement prepareCall (String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        System.out.println(" prepareCall(String, int, int, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql, int autoGeneratedKeys) throws SQLException
    {
        System.out.println(" prepareStatement(String, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql, int[] columnIndexes) throws SQLException
    {
        System.out.println(" prepareStatement(String, int[]) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public PreparedStatement prepareStatement (String sql, String[] columnNames) throws SQLException
    {
        System.out.println(" prepareStatement(String, String[]) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Clob createClob () throws SQLException
    {
        System.out.println(" createClob() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Blob createBlob () throws SQLException
    {
        System.out.println(" createBlob() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public NClob createNClob () throws SQLException
    {
        System.out.println(" createNClob() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public SQLXML createSQLXML () throws SQLException
    {
        System.out.println(" createSQLXML() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Array createArrayOf (String typeName, Object[] elements) throws SQLException
    {
        System.out.println(" createArrayOf(String, Object[]) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public Struct createStruct (String typeName, Object[] attributes) throws SQLException
    {
        System.out.println(" createStruct(String, Object[]) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void setSchema(String schema) throws SQLException
    {
        System.out.println(" setSchema(String) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public String getSchema() throws SQLException
    {
        System.out.println(" getSchema() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void abort(Executor executor) throws SQLException
    {
        System.out.println(" abort(Executor) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException
    {
        System.out.println(" setNetworkTimeout(Executor, int) called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public int getNetworkTimeout() throws SQLException
    {
        System.out.println(" getNetworkTimeout() called");
        throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

}
