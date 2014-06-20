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
import com.tibco.as.space.remote.MemberInvocable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ASInvocableMember implements MemberInvocable
{
	/**
	 * ASInvocableMember.invoke gets called when members of a space are invoked. It returns a
	 * result tuple which contains the member name, the contents of the context tuple, and
	 * a string message indicating that the invocation reply is coming from a Java program.
	 */
    public Tuple invoke (Space space, Tuple context)
    {
        Tuple result = Tuple.create();
        try
        {
            Thread.sleep(300);
            // get a reference to the metaspace and then get our member name
            Metaspace ms = space.getMetaspace();
            String memberName = ms.getSelfMember().getName();

            // display information about this invocation
            System.out.print("\nSpace name: " + space.getName());
            System.out.print("\nMember name: " + memberName);
            System.out.println("\nMetaspace name: " + space.getMetaspaceName());
            System.out.println("\nContext: " + (context == null ? "null" : context));

            // populate the result
            if (context != null)
                result.putAll(context);
            result.put("name", memberName);
            result.put("message", "Invocable member reply from Java API");

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
        catch (InterruptedException e)
        {
            result.put("error", "sleep interrupted");
        }
        return result;
    }
}
