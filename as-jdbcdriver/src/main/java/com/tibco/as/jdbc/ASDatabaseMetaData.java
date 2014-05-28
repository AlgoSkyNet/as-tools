// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.tibco.as.space.Metaspace;

public class ASDatabaseMetaData extends AbstractDatabaseMetaData implements DatabaseMetaData
{
    private static final String PRODUCT_NAME        = "TIBCO ActiveSpaces(R)";
    private String              productVersion;
    private int                 productMajorVersion = -1;
    private int                 productMinorVersion = -1;
    private ASConnection        connection;

    public ASDatabaseMetaData (ASConnection connection)
    {
        this.connection = connection;
        productVersion = Metaspace.version();
        parseVersionInfo(productVersion);
    }

    public Connection getConnection () throws SQLException
    {
        return connection;
    }

    public String getURL () throws SQLException
    {
        return Utils.getURL(connection.getMetaspace());
    }

    public String getDatabaseProductName () throws SQLException
    {
        return PRODUCT_NAME;
    }

    public String getDatabaseProductVersion () throws SQLException
    {
        return productVersion;
    }

    public int getDatabaseMajorVersion () throws SQLException
    {
        return productMajorVersion;
    }

    public int getDatabaseMinorVersion () throws SQLException
    {
        return productMinorVersion;
    }

    public String getDriverName () throws SQLException
    {
        return ASDriver.JDBC_DRIVER_NAME;
    }

    public String getDriverVersion () throws SQLException
    {
        return String.format("%d.%d.%d", ASDriver.JDBC_DRIVER_MAJOR_VERSION, ASDriver.JDBC_DRIVER_MINOR_VERSION,
                ASDriver.JDBC_DRIVER_POINT_VERSION);
    }

    public int getDriverMajorVersion ()
    {
        return ASDriver.JDBC_DRIVER_MAJOR_VERSION;
    }

    public int getDriverMinorVersion ()
    {
        return ASDriver.JDBC_DRIVER_MINOR_VERSION;
    }

    public int getJDBCMajorVersion () throws SQLException
    {
        return 4;
    }

    public int getJDBCMinorVersion () throws SQLException
    {
        return 0;
    }

    public int getSQLStateType () throws SQLException
    {
        return sqlStateSQL;
    }

    public boolean allProceduresAreCallable () throws SQLException
    {
        return false;
    }

    public boolean allTablesAreSelectable () throws SQLException
    {
        return true;
    }

    public boolean usesLocalFiles () throws SQLException
    {
        return false;
    }

    public boolean usesLocalFilePerTable () throws SQLException
    {
        return false;
    }

    public boolean isReadOnly () throws SQLException
    {
        return false;
    }

    public String getSQLKeywords () throws SQLException
    {
        return "";
    }

    public String getNumericFunctions () throws SQLException
    {
        return "";
    }

    public String getStringFunctions () throws SQLException
    {
        return "";
    }

    public String getSystemFunctions () throws SQLException
    {
        return "";
    }

    public String getTimeDateFunctions () throws SQLException
    {
        return "";
    }

    // ---------- internal helper methods ---------- //
    private void parseVersionInfo (String versionInfo)
    {
        String delims = "[.]";
        String[] tokens = versionInfo.split(delims);
        String mjversion = tokens[0];
        String mnversion = tokens[1];
        if (mjversion != null)
            productMajorVersion = Integer.parseInt(mjversion);
        if (mnversion != null)
            productMinorVersion = Integer.parseInt(mnversion);
    }

}
