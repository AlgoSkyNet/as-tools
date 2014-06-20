// -------------------------------------------------------------------
//  Copyright (c) 2011-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.rest.test.remote;

import com.tibco.as.rest.test.base.ASExampleBase;
import com.tibco.as.space.*;
import com.tibco.as.space.remote.InvokeResult;
import com.tibco.as.space.remote.InvokeResultList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class InvokeClient extends ASExampleBase
{

    public static void main (String[] args)
    {
        InvokeClient example = null;
        try
        {
            example = new InvokeClient(args);
            example.init();
            example.run();
        }
        catch (ASException as)
        {
            as.printStackTrace();
        }
        finally
        {
            if (example != null)
                example.cleanup();
        }
    }

    Metaspace metaspace;
    Space space;

    public InvokeClient (String[] args)
    {
        super(args);
        ASCommon.setLogLevel(LogLevel.INFO);
    }

    public void init() throws ASException
    {
        // parse command line arguments
        this.parseArgs();
        // connect to metaspace
        metaspace = connectMetaspace();
        // get space definition
        SpaceDef spaceDef = getSpaceDef();
        // define space
        metaspace.defineSpace(spaceDef);
        // get space
        space = getSpace(metaspace);
    }

    public void run ()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";

            System.out.println("\nInvokeClient options: key | self | seeders| leeches | members | remote | quit");
            System.out.println("Where:\n"
                    + "\tkey : invoke on a key\n"
                    + "\tself : invoke on self member\n"
                    + "\tseeders : invoke on seeders\n"
                    + "\tleeches : invoke on leeches\n"
                    + "\tmembers : invoke on all members\n"
                    + "\tremote : invoke on remote members\n"
                    + "\tquit : exit program\n");

            while (!line.equals("quit"))
            {
                System.out.print("\nInvoke on [key|self|seeders|leeches|members|remote|quit]: ");
                try
                {
                    line = reader.readLine();
                }
                catch (IOException io)
                {
                    System.out.println("enter quit to exit");
                    continue;
                }

                if (line.equals("key"))
                {
                    Tuple tuple = Tuple.create();
                    tuple.put("key", 1);

                    Tuple context = Tuple.create();
                    {
                        context.putString("value", "my id");
                        context.putDateTime("time", DateTime.create());
                    }
                    InvokeResult result = space.invoke(tuple, ASInvocable.class.getName(), InvokeOptions.create().setContext(context));
                    displayResult(result);
                }
                else if (line.equals("self"))
                {
                    Tuple context = Tuple.create();
                    {
                        context.putString("name", "my id");
                        context.putInt("value", 100);
                    }

                    InvokeResult result = space.invokeMember(metaspace.getSelfMember(), ASInvocableMember.class.getName(), InvokeOptions.create().setContext(context));
                    displayResult(result);
                }
                else if (line.equals("seeders"))
                {
                    Tuple context = Tuple.create();
                    {
                        context.put("metaspace_name", metaspace.getName());
                        context.putString("name", "my id");
                        context.putInt("value", 100);
                    }

                    Collection<Member> seeders = space.getSeeders();
                    InvokeResultList results = space.invokeMembers(seeders, ASInvocableMember.class.getName(), InvokeOptions.create().setContext(context));
                    displayResultList(results);
                }
                else if (line.equals("members"))
                {
                    Tuple context = Tuple.create();
                    {
                        context.put("metaspace_name", metaspace.getName());
                        context.putString("name", "my id");
                        context.putInt("value", 100);
                    }

                    Collection<Member> members = space.getMembers();
                    InvokeResultList results = space.invokeMembers(members, ASInvocableMember.class.getName(), InvokeOptions.create().setContext(context));
                    displayResultList(results);
                }
                else if (line.equals("leeches"))
                {
                    Tuple context = Tuple.create();
                    {
                        context.put("metaspace_name", metaspace.getName());
                        context.putString("name", "my id");
                        context.putInt("value", 100);
                    }

                    Collection<Member> leeches = space.getLeeches();
                    InvokeResultList results = space.invokeMembers(leeches, ASInvocableMember.class.getName(), InvokeOptions.create().setContext(context));
                    displayResultList(results);
                }                
                else if (line.equals("remote"))
                {
                    Tuple context = Tuple.create();
                    {
                        context.put("metaspace_name", metaspace.getName());
                        context.putString("name", "my id");
                        context.putInt("value", 100);
                    }

                    Collection<Member> remoteMembers = space.getRemoteMembers();
                    InvokeResultList results = space.invokeMembers(remoteMembers, ASInvocableMember.class.getName(), InvokeOptions.create().setContext(context));
                    displayResultList(results);
                }
                else
                {
                    System.out.println("Unrecognized option");
                }
            }
            System.out.println("Leaving metaspace...");
        }
        catch (ASException as)
        {
            as.printStackTrace();
        }
    }

    public void cleanup()
    {
        try
        {
            if (space != null) space.close();
            if (metaspace != null) metaspace.closeAll();
        }
        catch (ASException ex)
        {
            ex.printStackTrace();
        }
    }

    public void displayResultList(InvokeResultList results)
    {
        System.out.println("\nResult list size: " + results.size());
        if (results.hasError())
        {
            System.out.println("Result list contains error(s)");
        }
        for (InvokeResult result : results)
        {
            displayResult(result);
        }
    }

    public void displayResult(InvokeResult result)
    {
        String memberName = result.getMember().getName();
        if (result.hasError())
        {
            String errorMessage = result.getError().getMessage();
            System.out.println("\nError from member " + memberName + ", " + errorMessage);
            result.getError().printStackTrace();
        }
        else
        {
            System.out.println("\nResponse from member: " + memberName + ", result=" + result.getReturn());
        }
    }
}
