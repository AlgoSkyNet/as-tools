// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.IndexDef;
import com.tibco.as.space.IndexDef.IndexType;
import com.tibco.as.space.KeyDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;

public class CreateStatement implements ASSQLUpdateStatement
{
    // ActiveSpaces specific table settings
    public static final String DISTRIBUTION_POLICY = "distribution_policy";
    // Note: grammar maps persistence and persistence_type to persistence_type
    public static final String PERSISTENCE_TYPE    = "persistence_type";
    public static final String PERSISTENCE_POLICY  = "persistence_policy";
    public static final String UPDATE_TRANSPORT    = "update_transport";
    public static final String REPLICATION_POLICY  = "replication_policy";
    public static final String REPLICATION_COUNT   = "replication_count";
    public static final String MIN_SEEDERS         = "min_seeders";
    public static final String CAPACITY            = "capacity";
    public static final String EVICTION_POLICY     = "eviction_policy";
    public static final String TTL                 = "ttl";
    public static final String LOCK_TTL            = "lock_ttl";
    public static final String LOCK_WAIT           = "lock_wait";
    public static final String LOCK_SCOPE          = "lock_scope";
    public static final String SPACE_WAIT          = "space_wait";
    public static final String WRITE_TIMEOUT       = "write_timeout";
    public static final String READ_TIMEOUT        = "read_timeout";
    public static final String PHASE_COUNT         = "phase_count";
    public static final String PHASE_INTERVAL      = "phase_interval";

    String                     spaceName;
    String                     pkeyType;
    ArrayList<String>          pkeyList;
    ArrayList<Tuple>           columnDefs;
    Properties                 spaceDefProperties;
    ArrayList<ASSQLIndex>      indexList;

    public CreateStatement (String spaceName, ArrayList<Tuple> columnDefs, String pkeyType, ArrayList<String> pkeyList,
            Properties sdefProps, ArrayList<ASSQLIndex> indexList)
    {
        this.spaceName = spaceName;
        this.columnDefs = columnDefs;
        this.pkeyType = pkeyType;
        this.pkeyList = pkeyList;
        this.spaceDefProperties = sdefProps;
        this.indexList = indexList;
    }

    public int processUpdate (Metaspace metaspace) throws SQLException
    {
        int result = 1;
        // check for the basic information for creating a table
        if (spaceName == null)
            throw new SQLException("Cannot create table. Missing table name.");
        if (columnDefs.isEmpty())
            throw new SQLException("Cannot create table '" + spaceName + "'. Missing column information for table.");
        // check to make sure the space does not already exist
        try
        {
            Space space = metaspace.getSpace(spaceName);
            if (space != null)
            {
                space.close();
                return 0;
            }
        }
        catch (ASException ex)
        {
            // do nothing, we now know the space does not already exist
        }

        // as we process the fields of the space, we could find primary keys
        // so set up to save those keys
        ArrayList<String> keyList = new ArrayList<String>();
        // set the default key type in lowercase as IndexType.getIndexType compares in lowercase
        String keyType = IndexType.HASH.toString().toLowerCase();  // default for primary keys

        // populate the space field information
        SpaceDef spaceDef = SpaceDef.create().setName(spaceName);
        int numColumns = columnDefs.size();
        for (int i = 0; i < numColumns; i++)
        {
            Tuple tuple = columnDefs.get(i);
            String columnName = tuple.getString(ASSQLUtils.COLUMN_NAME);
            String columnType = tuple.getString(ASSQLUtils.COLUMN_TYPE);
            String notNull = tuple.getString(ASSQLUtils.NULL_CONSTRAINT);
            String isPrimaryKey = tuple.getString(ASSQLUtils.PKEY_CONSTRAINT);
            String primaryKeyType = tuple.getString(ASSQLUtils.PKEY_TYPE);

            try
            {
                FieldType fieldType = FieldType.getFieldType(columnType);
                FieldDef fieldDef = FieldDef.create(columnName, fieldType);
                boolean isNullable = true;
                if (notNull != null && Boolean.parseBoolean(notNull))
                    isNullable = false;
                fieldDef.setNullable(isNullable);
                spaceDef.putFieldDef(fieldDef);
            }
            catch (Exception ex)
            {
                throw new SQLException("Cannot create table '" + spaceName + "'. Error creating field '" + columnName + "'. Exception message: " + ex.getMessage());
            }

            // see if primary keys were specified with the columns
            if (isPrimaryKey != null && Boolean.parseBoolean(isPrimaryKey))
            {
                keyList.add(columnName);
                if (primaryKeyType != null)
                {
                    // if different key types were specified for multiple primary keys,
                    // we end up taking the setting from the last primary key specified
                    keyType = primaryKeyType;
                }
            }
        }

        // check to make sure we don't have two sets of primary keys specified
        if (!keyList.isEmpty() && (pkeyList != null && !pkeyList.isEmpty()))
            throw new SQLException("Cannot create table '" + spaceName + "'. Multiple sets of primary keys specified.");
        if (keyList.isEmpty() && (pkeyList == null || pkeyList.isEmpty()))
            throw new SQLException("Cannot create table '" + spaceName + "'. No primary key specified.");
        try
        {
            if (!keyList.isEmpty())
                setPrimaryKeys(spaceDef, keyList, keyType);
            else if (pkeyList != null && !pkeyList.isEmpty())
                setPrimaryKeys(spaceDef, pkeyList, pkeyType);
        }
        catch (SQLException ex)
        {
            throw new SQLException("Cannot create table '" + spaceName + "'. " + ex.getMessage());
        }

        // set up any indexes
        setIndexes(spaceDef, indexList);

        // set any ActiveSpaces specific settings
        try
        {
            setSpaceDefProperties(spaceDef, spaceDefProperties);
        }
        catch (SQLException ex)
        {
            throw new SQLException("Cannot create table '" + spaceName + "'. Invalid SpaceDef setting. "
                    + ex.getMessage());
        }

        // lastly define the space in the metaspace, but do not join it
        try
        {
            metaspace.defineSpace(spaceDef);
        }
        catch (ASException ex)
        {
            throw new SQLException("Cannot create table '" + spaceName + "'. " + ex.getMessage());
        }
        return result;
    }

    protected void setPrimaryKeys (SpaceDef spaceDef, ArrayList<String> keyList, String keyType) throws SQLException
    {
        if (spaceDef == null || keyList == null || keyList.isEmpty())
            return;

        String primaryKeyType = IndexType.HASH.toString().toLowerCase();
        if (keyType != null)
            primaryKeyType = keyType;
        IndexType indexType = IndexType.getIndexType(primaryKeyType);

        int numKeys = keyList.size();
        String[] keyFields = new String[numKeys];
        int nullableKeys = 0;
        for (int i = 0; i < numKeys; i++)
        {
            String columnName = keyList.get(i);
            if (spaceDef.getFieldDef(columnName).isNullable())
            {
                // ActiveSpaces allows a key to be nullable. However, only one key
                // field can be nullable as key fields need to have unique values.
                nullableKeys++;
                if (nullableKeys > 1)
                    throw new SQLException(
                            "More than one primary key is nullable. Only one primary key can be nullable.");
            }
            keyFields[i] = columnName;
        }
        spaceDef.setKeyDef(KeyDef.create().setFieldNames(keyFields).setIndexType(indexType));
        return;
    }

    protected void setIndexes (SpaceDef spaceDef, ArrayList<ASSQLIndex> indexList)
    {
        if (spaceDef == null || indexList == null || indexList.isEmpty())
            return;

        int numIndexes = indexList.size();
        for (int i = 0; i < numIndexes; i++)
        {
            ASSQLIndex indexInfo = indexList.get(i);
            String indexName = indexInfo.getIndexName();
            IndexDef indexDef = IndexDef.create(indexName);

            String indexTypeStr = indexInfo.getIndexType();
            if (indexTypeStr == null)
                indexTypeStr = IndexType.TREE.toString().toLowerCase();  // default for indexes
            IndexType indexType = IndexType.getIndexType(indexTypeStr);
            indexDef.setIndexType(indexType);

            ArrayList<String> indexColumns = indexInfo.getIndexColumns();
            int numIndexColumns = indexColumns.size();
            String[] indexFields = new String[numIndexColumns];
            for (int j = 0; j < numIndexColumns; j++)
            {
                String indexColumnName = indexColumns.get(j);
                indexFields[j] = indexColumnName;
            }
            indexDef.setFieldNames(indexFields);
            spaceDef.addIndexDef(indexDef);
        }
        return;
    }

    protected void setSpaceDefProperties (SpaceDef spaceDef, Properties spaceDefProps) throws SQLException
    {
        if (spaceDef == null || spaceDefProps == null || spaceDefProps.isEmpty())
            return;

        String[] propNameList = { DISTRIBUTION_POLICY, PERSISTENCE_TYPE, PERSISTENCE_POLICY, UPDATE_TRANSPORT,
                REPLICATION_POLICY, REPLICATION_COUNT, MIN_SEEDERS, CAPACITY, EVICTION_POLICY, TTL, LOCK_TTL,
                LOCK_WAIT, LOCK_SCOPE, SPACE_WAIT, WRITE_TIMEOUT, READ_TIMEOUT, PHASE_COUNT, PHASE_INTERVAL };

        for (int i = 0; i < propNameList.length; i++)
        {
            String key = propNameList[i];
            String sval = spaceDefProps.getProperty(key);
            if (sval != null)
            {
                if (key.equals(DISTRIBUTION_POLICY))
                {
                    for (SpaceDef.DistributionPolicy p : SpaceDef.DistributionPolicy.values())
                    {
                        if (p.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setDistributionPolicy(p);
                            break;
                        }
                    }
                }
                else if (key.equals(PERSISTENCE_POLICY))
                {
                    for (SpaceDef.PersistencePolicy p : SpaceDef.PersistencePolicy.values())
                    {
                        if (p.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setPersistencePolicy(p);
                            break;
                        }
                    }
                }
                else if (key.equals(PERSISTENCE_TYPE))
                {
                    for (SpaceDef.PersistenceType t : SpaceDef.PersistenceType.values())
                    {
                        if (t.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setPersistenceType(t);
                            break;
                        }
                    }
                }
                else if (key.equals(UPDATE_TRANSPORT))
                {
                    for (SpaceDef.UpdateTransport t : SpaceDef.UpdateTransport.values())
                    {
                        if (t.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setUpdateTransport(t);
                            break;
                        }
                    }
                }
                else if (key.equals(REPLICATION_POLICY))
                {
                    for (SpaceDef.ReplicationPolicy p : SpaceDef.ReplicationPolicy.values())
                    {
                        if (p.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setReplicationPolicy(p);
                            break;
                        }
                    }
                }
                else if (key.equals(REPLICATION_COUNT))
                {
                    try
                    {
                        int ival = Integer.parseInt(sval);
                        if (ival >= 0)
                            spaceDef.setReplicationCount(ival);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(MIN_SEEDERS))
                {
                    try
                    {
                        int ival = Integer.parseInt(sval);
                        if (ival > 0)
                            spaceDef.setMinSeederCount(ival);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(CAPACITY))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setCapacity(lval);
                        else
                            throw new SQLException("Invalid capacity value: " + lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(EVICTION_POLICY))
                {
                    for (SpaceDef.EvictionPolicy p : SpaceDef.EvictionPolicy.values())
                    {
                        if (p.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setEvictionPolicy(p);
                            break;
                        }
                    }
                }
                else if (key.equals(TTL))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setTTL(lval);
                        else
                            throw new SQLException("Invalid TTL value: " + lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(LOCK_TTL))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setLockTTL(lval);
                        else
                            throw new SQLException("Invalid lock TTL value: " + lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(LOCK_WAIT))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setLockWait(lval);
                        else
                            throw new SQLException("Invalid lock wait value: " + lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(LOCK_SCOPE))
                {
                    for (SpaceDef.LockScope s : SpaceDef.LockScope.values())
                    {
                        if (s.toString().equalsIgnoreCase(sval))
                        {
                            spaceDef.setLockScope(s);
                            break;
                        }
                    }
                }
                else if (key.equals(SPACE_WAIT))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setSpaceWait(lval);
                        else
                            throw new SQLException("Invalid space wait value: " + lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(WRITE_TIMEOUT))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setWriteTimeout(lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(READ_TIMEOUT))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setReadTimeout(lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(PHASE_COUNT))
                {
                    try
                    {
                        int ival = Integer.parseInt(sval);
                        if (ival == -1 || ival > 0)
                            spaceDef.setPhaseCount(ival);
                        else
                            throw new SQLException("Invalid phase count value: " + ival);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
                else if (key.equals(PHASE_INTERVAL))
                {
                    try
                    {
                        long lval = Long.parseLong(sval);
                        if (lval == -1 || lval >= 0)
                            spaceDef.setPhaseInterval(lval);
                    }
                    catch (NumberFormatException ex)
                    {
                        // quietly ignore
                    }
                }
            }
        }  // end for loop
        return;
    }

}
