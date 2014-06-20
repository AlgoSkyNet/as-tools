// -------------------------------------------------------------------
//  Copyright (c) 2011-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.rest.test.base;

import com.tibco.as.space.*;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.IndexDef.IndexType;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.browser.BrowserDef;
import com.tibco.as.space.browser.BrowserDef.BrowserType;
import com.tibco.as.space.browser.BrowserDef.DistributionScope;
import com.tibco.as.space.browser.EventBrowserDef;
import com.tibco.as.space.event.PutEvent;
import com.tibco.as.space.event.SpaceEvent;
import com.tibco.as.space.listener.ListenerDef;

import java.io.File;
import java.util.Collection;

public abstract class ASExampleBase extends ASExampleProps
{
    public abstract void cleanup();

    /**
     * @param args command line arguments
     */
    public ASExampleBase (String[] args)
    {
        System.out.println("ActiveSpaces " + Metaspace.version());
        System.out.println("Example: " + getClass().getSimpleName());
        this.setCommandLineArgs(args);
    }

    public BrowserType getBrowserType ()
    {
        String property = properties.getProperty("-browser", "get");
        if (property.equals("get"))
        {
            return BrowserDef.BrowserType.GET;
        }
        else if (property.equals("take"))
        {
            return BrowserDef.BrowserType.TAKE;
        }
        else if (property.equals("lock"))
        {
            return BrowserDef.BrowserType.LOCK;
        }
        throw new RuntimeException();
    }

    public BrowserDef getBrowserDef ()
    {
        String property = properties.getProperty("-time_scope", "snapshot");
        BrowserDef browserDef = BrowserDef.create();

        if (property.equals("snapshot"))
        {
            browserDef.setTimeScope(BrowserDef.TimeScope.SNAPSHOT);
        }
        else if (property.equals("all"))
        {
            browserDef.setTimeScope(BrowserDef.TimeScope.ALL);
        }
        else if (property.equals("new"))
        {
            browserDef.setTimeScope(BrowserDef.TimeScope.NEW);
        }
        else
        {
            throw new RuntimeException("unknown BrowserDef time scope " + property);
        }

        String distributionScope = properties.getProperty("-distribution_scope", "all");

        if (distributionScope.equals("all"))
        {
            browserDef.setDistributionScope(DistributionScope.ALL);
        }
        else if (distributionScope.equals("seeded"))
        {
            browserDef.setDistributionScope(DistributionScope.SEEDED);
        }
        else
        {
            throw new RuntimeException("unknown BrowserDef distribution scope " + distributionScope);
        }

        int timeout = Integer.parseInt(properties.getProperty("-timeout", "" + BrowserDef.NO_WAIT));
        long prefetch = Long.parseLong(properties.getProperty("-prefetch", "1000"));

        browserDef.setTimeout(timeout);
        browserDef.setPrefetch(prefetch);

        return browserDef;

    }

    public EventBrowserDef getEventBrowserDef ()
    {
        String property = properties.getProperty("-time_scope", "all");
        EventBrowserDef eventBrowserDef = EventBrowserDef.create();

        if (property.equals("snapshot"))
        {
            eventBrowserDef.setTimeScope(EventBrowserDef.TimeScope.SNAPSHOT);
        }
        else if (property.equals("all"))
        {
            eventBrowserDef.setTimeScope(EventBrowserDef.TimeScope.ALL);
        }
        else if (property.equals("new"))
        {
            eventBrowserDef.setTimeScope(EventBrowserDef.TimeScope.NEW);
        }
        else if (property.equals("new_events"))
        {
            eventBrowserDef.setTimeScope(EventBrowserDef.TimeScope.NEW_EVENTS);
        }
        else
        {
            throw new RuntimeException("unknown EventBrowserDef time scope " + property);
        }

        String distributionScope = properties.getProperty("-distribution_scope", "all");

        if (distributionScope.equals("all"))
        {
            eventBrowserDef.setDistributionScope(EventBrowserDef.DistributionScope.ALL);
        }
        else if (distributionScope.equals("seeded"))
        {
            eventBrowserDef.setDistributionScope(EventBrowserDef.DistributionScope.SEEDED);
        }
        else
        {
            throw new RuntimeException("unknown EventBrowserDef distribution scope " + distributionScope);
        }

        int timeout = Integer.parseInt(properties.getProperty("-timeout", "-1"));
        eventBrowserDef.setTimeout(timeout);
        return eventBrowserDef;

    }

    public ListenerDef getListenerDef ()
    {
        String property = properties.getProperty("-time_scope", "new_events");
        ListenerDef listenerDef = ListenerDef.create();

        if (property.equals("snapshot"))
        {
            listenerDef.setTimeScope(ListenerDef.TimeScope.SNAPSHOT);
        }
        else if (property.equals("all"))
        {
            listenerDef.setTimeScope(ListenerDef.TimeScope.ALL);
        }
        else if (property.equals("new"))
        {
            listenerDef.setTimeScope(ListenerDef.TimeScope.NEW);
        }
        else if (property.equals("new_events"))
        {
            listenerDef.setTimeScope(ListenerDef.TimeScope.NEW_EVENTS);
        }
        else
        {
            throw new RuntimeException("unknown EventBrowserDef time scope " + property);
        }

        String distributionScope = properties.getProperty("-distribution_scope", "all");

        if (distributionScope.equals("all"))
        {
            listenerDef.setDistributionScope(ListenerDef.DistributionScope.ALL);
        }
        else if (distributionScope.equals("seeded"))
        {
            listenerDef.setDistributionScope(ListenerDef.DistributionScope.SEEDED);
        }
        else
        {
            throw new RuntimeException("unknown ListenerDef distribution scope " + distributionScope);
        }
        return listenerDef;

    }

    public MemberDef getMemberDef() throws ASException
    {
        MemberDef memberDef = MemberDef.create();
        memberDef.setDiscovery(properties.getProperty("-discovery", "tibpgm"));
        memberDef.setListen(properties.getProperty("-listen", "tcp"));
        memberDef.setRemoteListen(properties.getProperty("-remote_listen", ""));
        memberDef.setMemberName(properties.getProperty("-member_name", ""));

        Tuple context = Tuple.create();
        context.put("platform", "java");
        context.put("jointime", DateTime.create());
        memberDef.setContext(context);

        String rxBufferSize = properties.getProperty("-rx_buffer_size", "");
        if (!rxBufferSize.isEmpty())
        {
            memberDef.setRxBufferSize(Long.parseLong(rxBufferSize));
        }

        String transportThreadCount = properties.getProperty("-transport_thread_count", "");
        if (!transportThreadCount.isEmpty())
        {
            memberDef.setTransportThreadCount(Integer.parseInt(transportThreadCount));
        }

        String datastore = properties.getProperty("-data_store", "");
        if (!datastore.isEmpty())
        {
            if (checkDirectoryExists(datastore))
            {
                memberDef.setDataStore(datastore);
            }
            else
            {
                throw new ASException(ASStatus.INVALID_ARG, "Cannot create data store directory: " + datastore);
            }
        }

        String securityPolicy = properties.getProperty("-security_policy");
        if (checkFileExists(securityPolicy))
        {
            memberDef.setSecurityPolicyFile(securityPolicy);
        }
        else
        {
            if (securityPolicy != null)
                throw new ASException(ASStatus.INVALID_ARG, "Invalid security policy file: " + securityPolicy);
        }

        String securityToken = properties.getProperty("-security_token");
        if (checkFileExists(securityToken))
        {
            memberDef.setSecurityTokenFile(securityToken);
        }
        else
        {
            if (securityToken != null && securityToken.isEmpty())
                memberDef.setSecurityTokenFile(securityToken);
            else if (securityToken != null)
                throw new ASException(ASStatus.INVALID_ARG, "Invalid security token file: " + securityToken);
        }
        return memberDef;

    }

    public Metaspace connectMetaspace () throws ASException
    {
        MemberDef memberDef = getMemberDef();
        return connectMetaspace(memberDef);
    }

    public Metaspace connectMetaspace (MemberDef memberDef) throws ASException
    {
        String metaspaceName = properties.getProperty("-metaspace", "ms");
        Metaspace ms = Metaspace.connect(metaspaceName, memberDef);

        Collection<Member> members = ms.getMetaspaceMembers();
        System.out.println("Current metaspace members: ");
        for (Member member : members)
        {
            System.out.println("\t" + member.getName() + " as " + member.getManagementRole() + " context=" + member.getContext());
        }
        System.out.println("");

        return ms;
    }

    public void updateRole (DistributionRole role)
    {
        properties.setProperty("-role", role.name().toLowerCase());
    }

    public Space getSpace (Metaspace ms) throws ASException
    {
        Space space;
        String spaceName = properties.getProperty("-space", defaultSpaceName);
        String role = properties.getProperty("-role", "leech");
        if (role.equals("leech"))
            space = ms.getSpace(spaceName, DistributionRole.LEECH);
        else if (role.equals("seeder"))
            space = ms.getSpace(spaceName, DistributionRole.SEEDER);
        else
            throw new ASException(ASStatus.SYS_ERROR,
                    "\n\tError retrieving space: " + spaceName
                    + "\n\tunknown distribution role: " + role);

        Collection<Member> members = ms.getSpaceMembers(spaceName);

        System.out.println("Current space members for " + spaceName + " :");
        for (Member member : members)
        {
            System.out.println("\t" + member.getName() + " as " + member.getDistributionRole(spaceName));
        }
        System.out.println("");
        return space;
    }

    public void waitUntilReady (Space space, SpaceDef spaceDef) throws ASException
    {
        // Wait for the space to be ready
        if (!space.isReady())
        {
            System.out.println("waiting for the space to be ready...");
            switch (spaceDef.getPersistenceType())
            {
                case NONE:
                    System.out.println("please start " + spaceDef.getMinSeederCount() + " seeder nodes (ex. as-agent)");
                    break;
                case SHARE_ALL:
                    System.out.println("Please start an instance of ASPersistence to implement the external "
                            + "shared all persistence and a minimum " + spaceDef.getMinSeederCount() + " seeder nodes (ex. as-agent)");
                    break;
                case SHARE_NOTHING:
                    System.out.println("please start " + spaceDef.getMinSeederCount()
                            + " seeder nodes (ex. as-agent) with -name and -data_store arguments and issue a 'recover space' admin command");
                    break;
            }
            space.waitForReady();
            System.out.println("Space '" + spaceDef.getName() + "' ready now...");
        }
    }

    public SpaceDef getSpaceDef ()
    {
        String spaceName = properties.getProperty("-space", defaultSpaceName);
        // Create the space definition
        SpaceDef spaceDef = SpaceDef.create().setName(spaceName);
        // Put the field definitions into the space definition
        spaceDef.putFieldDef(FieldDef.create("key", FieldType.INTEGER));
        spaceDef.putFieldDef(FieldDef.create("value", FieldType.STRING).setNullable(true));
        spaceDef.putFieldDef(FieldDef.create("time", FieldType.DATETIME).setNullable(true));

        if(properties.getProperty("-encrypt_field") != null){
            spaceDef.putFieldDef(FieldDef.create("secure_value", FieldType.STRING).setEncrypted(true).setNullable(true));
        }

        // defines the key fields, by default the key index is of type HASH add setIndexType(IndexType.TREE) to the KeyDef below to change it to TREE type
        spaceDef.setKeyDef(KeyDef.create().setFieldNames("key").setIndexType(IndexType.HASH));
        // If you want to create indexes on fields, add them using: spaceDef.addIndexDef(IndexDef.create("index_name").setFieldNames("field_name","field_name2").setIndexType(IndexType.TREE or HASH));
        // If you want fault-tolerance through replication, add .setReplicationCount(count) to the SpaceDef

        String persistenceType = properties.getProperty("-persistence", "");
        if (!persistenceType.isEmpty())
        {
            if (persistenceType.equalsIgnoreCase("shared_nothing"))
                spaceDef.setPersistenceType(SpaceDef.PersistenceType.SHARE_NOTHING);
            else if (persistenceType.equalsIgnoreCase("shared_all"))
                spaceDef.setPersistenceType(SpaceDef.PersistenceType.SHARE_ALL);
            else if (persistenceType.equalsIgnoreCase("none"))
                spaceDef.setPersistenceType(SpaceDef.PersistenceType.NONE);
            else
                throw new RuntimeException("Unknown peristence type " + persistenceType);

            String persistencePolicy = properties.getProperty("-persistence_policy", "");
            if (!persistencePolicy.isEmpty())
            {
                if (persistencePolicy.equalsIgnoreCase("async"))
                    spaceDef.setPersistencePolicy(SpaceDef.PersistencePolicy.ASYNC);
                else if (persistencePolicy.equalsIgnoreCase("sync"))
                    spaceDef.setPersistencePolicy(SpaceDef.PersistencePolicy.SYNC);
                else if (persistencePolicy.equalsIgnoreCase("none"))
                    spaceDef.setPersistencePolicy(SpaceDef.PersistencePolicy.NONE);
                else
                    throw new RuntimeException("Unknown persistence policy " + persistencePolicy);
            }
        }

        int repcount = Integer.parseInt(properties.getProperty("-replication_count", "0"));
        if (repcount >= -1)
        {
            spaceDef.setReplicationCount(repcount);
        }
        else
        {
            System.err.println("\nWarning: Invalid replication count " + repcount + " entered on the command line.");
            System.err.println("         Default replication count of 0 used.");
        }
        String replicationPolicy = properties.getProperty("-replication_policy", "");
        if (!replicationPolicy.isEmpty())
        {
            if (replicationPolicy.equalsIgnoreCase("sync"))
                spaceDef.setReplicationPolicy(SpaceDef.ReplicationPolicy.SYNC);
            else if (replicationPolicy.equalsIgnoreCase("async"))
                spaceDef.setReplicationPolicy(SpaceDef.ReplicationPolicy.ASYNC);
            else
                throw new RuntimeException("Unknown replication policy " + replicationPolicy);
        }

        int minseeders = Integer.parseInt(properties.getProperty("-min_seeders", "1"));
        if (minseeders > 0)
        {
            spaceDef.setMinSeederCount(minseeders);
        }

        long capacity = Long.parseLong(properties.getProperty("-capacity", "-1"));
        if (capacity != -1)
        {
            // capacity has been set to other than the default
            // set the capacity to the new setting
            spaceDef.setCapacity(capacity);
            // now we need to set the eviction policy
            String evictionPolicy = properties.getProperty("-eviction_policy", "");
            if (!evictionPolicy.isEmpty())
            {
                boolean match = false;
                for (SpaceDef.EvictionPolicy policy : SpaceDef.EvictionPolicy.values())
                {
                    if (evictionPolicy.trim().toLowerCase().equals(policy.toString().toLowerCase()))
                    {
                        match = true;
                        spaceDef.setEvictionPolicy(policy);
                    }
                }

                if (!match)
                {
                    System.err.println("\nWarning: Unknown eviction policy " + evictionPolicy + " entered on the command line.");
                    System.err.println("         Using default eviction policy of NONE\n");
                    // nothing to set as the SpaceDef defaults to an eviction policy of NONE
                }
            }
        }

        String distributionPolicy = properties.getProperty("-distribution_policy", "");
        if (!distributionPolicy.isEmpty())
        {
            boolean match = false;
            for (SpaceDef.DistributionPolicy policy : SpaceDef.DistributionPolicy.values())
            {
                if (distributionPolicy.trim().toLowerCase().equals(policy.toString().toLowerCase()))
                {
                    match = true;
                    spaceDef.setDistributionPolicy(policy);
                }
            }

            if (!match)
            {
                System.err.println("\nWarning: Unknown distribution policy " + distributionPolicy + " entered on the command line.");
                System.err.println("           Using default distribution policy of 'distributed'\n");
                // nothing to set as the SpaceDef defaults to an eviction policy of NONE
            }
        }

        boolean hostAwareReplication = Boolean.parseBoolean(properties.getProperty("-host_aware_replication", "true"));
        spaceDef.setHostAwareReplication(hostAwareReplication);

        boolean routed = Boolean.parseBoolean(properties.getProperty("-routed", "false"));
        spaceDef.setRouted(routed);

        return spaceDef;
    }

    @SuppressWarnings("incomplete-switch")
	public void displayEvent (SpaceEvent event)
    {
        System.out.println(event.getClass().getName() + " on space " + event.getSpaceName());

        switch (event.getType())
        {
            case PUT:
                PutEvent pEvent = (PutEvent) event;
                System.out.println(" Tuple: " + pEvent.getTuple());
                if (pEvent.hasOldTuple())
                {
                    System.out.println(" Old Tuple: " + pEvent.getOldTuple());
                }
                break;
            case TAKE:
            case EXPIRE:
            case SEED:
            case UNSEED:
                System.out.println(" Tuple: " + event.getTuple());
                break;
        }
    }

    public void setDefaultSpaceName(String defaultName)
    {
        // calling setDefaultSpaceName() before getSpace() or getSpaceDef() is called
        // allows an application to change the default space name used by the application
        if (defaultName != null)
        {
            defaultSpaceName = defaultName;
        }
    }

    public static boolean checkDirectoryExists (String path)
    {
        boolean exists = false;
        File directory = new File(path);
        if (!directory.exists())
            exists = directory.mkdirs();
        else
            exists = true;
        return exists;
    }

    public static boolean checkFileExists(String filename) throws ASException
    {
        boolean exists = false;
        if (filename == null || filename.isEmpty())
            return exists;
        File tempfile = new File(filename);
        if (tempfile.exists())
            exists = true;
        return exists;
    }
}
