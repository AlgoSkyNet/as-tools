// -------------------------------------------------------------------
//  Copyright (c) 2011-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.rest.test.remote;

import com.tibco.as.space.ASException;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.remote.Invocable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ASInvocable implements Invocable
{

	/**
	 * ASInvocable.invoke gets called on the space member seeding the tuple identified in the
	 * keyTuple parameter. It returns a result Tuple which contains the name of the member and
	 * the contents of the tuple, identified by the keyTuple parameter, which was retrieved
	 * from the space.
	 */
    public Tuple invoke (Space space, Tuple keyTuple, Tuple context)
    {
        Tuple result = Tuple.create();
        try
        {
            // get a reference to the metaspace and then get our member name
            Metaspace ms = space.getMetaspace();
            String memberName = ms.getSelfMember().getName();

            // display information about this invocation
            System.out.print("\nSpace name: " + space.getName());
            System.out.print("\nMember name: " + memberName);
            System.out.println("\nMetaspace name: " + space.getMetaspaceName());
            System.out.println("\nContext: " + (context == null ? "null" : context));

            // display the contents of keyTuple which identifies the tuple this member is seeding
            System.out.println("\nKey Tuple: " + keyTuple);

            // now retrieve the tuple with the key from the space
            Tuple tuple = space.get(keyTuple);
            System.out.println("\nRetrieved Tuple: " + (tuple == null ? "null" : tuple.toString()));

            // populate the result
            result.put("name", memberName);
            result.put("result", (tuple == null ? "null" : tuple.toString()));

            // release the space and metaspace references
            space.close();
            ms.close();
        }
        catch (ASException ase)
        {
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ase.printStackTrace(printWriter);
            result.put("error", writer.toString());
        }
        return result;
    }
}
