// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.sql.*;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import com.tibco.as.space.ASException;
import com.tibco.as.space.ASStatus;
import com.tibco.as.space.DateTime;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Tuple;

public class ASConnection extends AbstractConnection implements Connection
{

    protected Metaspace    metaspace;
    private Set<Statement> statements  = new ConcurrentSkipListSet<Statement>();

    // can read from or write to spaces
    private boolean        read_only   = false;
    // statements are executed one-by-one
    private boolean        auto_commit = true;

    // we currently don't support transactions
    // private boolean in_transaction = false;

    // we currently don't support client info
    private Properties     clientInfo  = new Properties();

    public ASConnection () throws ASException
    {
        this.metaspace = Metaspace.connect();
    }

    public ASConnection (Metaspace metaspace)
    {
        this.metaspace = metaspace;
    }

    public ASConnection (java.util.Properties info) throws ASException
    {
        if (info != null && !info.isEmpty())
        {
            // create a metaspace connection based upon the given properties
            MemberDef memberDef = MemberDef.create();
            memberDef.setDiscovery(info.getProperty("discovery", "tibpgm"));
            memberDef.setListen(info.getProperty("listen", "tcp"));
            memberDef.setRemoteListen(info.getProperty("remote_listen", ""));
            memberDef.setRemoteDiscovery(info.getProperty("remote_discovery", ""));
            memberDef.setMemberName(info.getProperty("member_name", ""));
            String metaspaceName = info.getProperty("metaspace", "ms");
            String rx_buffer_sizeStr = info.getProperty("rx_buffer_size", "");
            if (rx_buffer_sizeStr != null && !rx_buffer_sizeStr.isEmpty())
            {
                try
                {
                    long rxsize = Long.parseLong(rx_buffer_sizeStr);
                    memberDef.setRxBufferSize(rxsize);
                }
                catch (NumberFormatException ex)
                {
                    throw new ASException(ASStatus.INVALID_ARG, "Invalid rx_buffer_size specified.");
                }
            }
            String worker_thread_countStr = info.getProperty("worker_thread_count", "");
            if (worker_thread_countStr != null && !worker_thread_countStr.isEmpty())
            {
                try
                {
                    int threadCount = Integer.parseInt(worker_thread_countStr);
                    memberDef.setWorkerThreadCount(threadCount);
                }
                catch (NumberFormatException ex)
                {
                    throw new ASException(ASStatus.INVALID_ARG, "Invalid worker_thread_count specified.");
                }
            }

            Tuple context = Tuple.create();
            context.put("platform", "java");
            context.put("jointime", DateTime.create());
            memberDef.setContext(context);

            this.metaspace = Metaspace.connect(metaspaceName, memberDef);
        }
        else
            this.metaspace = Metaspace.connect();
    }

    public Metaspace getMetaspace ()
    {
        return metaspace;
    }

    public void close () throws SQLException
    {
        // close all statements associated with this connection upon close
        for (Statement statement : statements)
            statement.close();
        statements.clear();

        try
        {
            if (metaspace != null)
            {
                metaspace.closeAll();
            }
            metaspace = null;
        }
        catch (ASException e)
        {
            throw new SQLException(e);
        }
    }

    public boolean isClosed () throws SQLException
    {
        return metaspace == null ? true : false;
    }

    public boolean isValid (int timeout) throws SQLException
    {
        checkForMetaspace();
        if (timeout < 0)
            throw new SQLTimeoutException("Timeout cannot be less than zero.");
        boolean result = true;
        try
        {
            // try to do something simple that will access the metaspace to see
            // if the metaspace is still active
            Collection<String> userSpaces = metaspace.getUserSpaceNames();
            userSpaces.clear();
        }
        catch (ASException ex)
        {
            // there was some problem accessing the metaspace
            result = false;
        }
        return result;
    }

    public Statement createStatement () throws SQLException
    {
        checkForMetaspace();
        Statement statement = new ASStatement(this);
        statements.add(statement);
        return statement;
    }

    public Statement createStatement (int resultSetType, int resultSetConcurrency) throws SQLException
    {
        checkForMetaspace();
        Statement statement = new ASStatement(this, resultSetType, resultSetConcurrency);
        statements.add(statement);
        return statement;
    }

    public Statement createStatement (int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException
    {
        checkForMetaspace();
        Statement statement = new ASStatement(this, resultSetType, resultSetConcurrency, resultSetHoldability);
        statements.add(statement);
        return statement;
    }

    public DatabaseMetaData getMetaData () throws SQLException
    {
        checkForMetaspace();
        return new ASDatabaseMetaData(this);
    }

    public void setReadOnly (boolean readOnly) throws SQLException
    {
        checkForMetaspace();
        // ignore any setting as we only support read/write mode
    }

    public boolean isReadOnly () throws SQLException
    {
        checkForMetaspace();
        return read_only;
    }

    public void setHoldability (int holdability) throws SQLException
    {
        checkForMetaspace();
        // ignore any setting as we only support HOLD_CURSORS_OVER_COMMIT
    }

    public int getHoldability () throws SQLException
    {
        checkForMetaspace();
        return ResultSet.HOLD_CURSORS_OVER_COMMIT;
    }

    public String nativeSQL (String sql) throws SQLException
    {
        checkForMetaspace();
        return sql;
    }

    public SQLWarning getWarnings () throws SQLException
    {
        checkForMetaspace();
        // we do not keep track of warnings
        return null;
    }

    public void clearWarnings () throws SQLException
    {
        checkForMetaspace();
        // we do not keep track of warnings
    }

    /* -- transaction related methods -- */
    public void setAutoCommit (boolean autoCommit) throws SQLException
    {
        checkForMetaspace();
        if (!autoCommit)
            throw new SQLFeatureNotSupportedException(Utils.AS_FEATURE_NOT_SUPPORTED);
    }

    public boolean getAutoCommit () throws SQLException
    {
        checkForMetaspace();
        return auto_commit;
    }

    // Client info properties are not used, so none of these methods relating to
    // client info actually do anything useful
    public void setClientInfo (Properties properties) throws SQLClientInfoException
    {
        if (properties != null)
            clientInfo = properties;
    }

    public Properties getClientInfo () throws SQLException
    {
        checkForMetaspace();
        return clientInfo;
    }

    public void setClientInfo (String name, String value) throws SQLClientInfoException
    {
        clientInfo.setProperty(name, value);
    }

    public String getClientInfo (String name) throws SQLException
    {
        checkForMetaspace();
        return clientInfo.getProperty(name);
    }

    /* -- internal support methods -- */

    protected final void checkForMetaspace () throws SQLException
    {
        if (metaspace == null)
            throw new SQLNonTransientConnectionException("Cannot invoke method when metaspace connection is closed.");
    }

    protected boolean removeStatement (Statement statement)
    {
        return statements.remove(statement);
    }

    public String toString ()
    {
        return getClass().getName() + " [" + metaspace.toString() + "]";
    }
}
