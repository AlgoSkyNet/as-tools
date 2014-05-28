// -------------------------------------------------------------------
//  Copyright (c) 2014 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import java.util.Date;

/**
 * SimpleLogger provides very basic tracing for helping to see which
 * JDBC driver methods are getting invoked. Tracing is output to
 * System.err. Turn tracing on by specifying debug=true in the JDBC
 * URL parameters. For example,
 * jdbc:tibco:as:examplems;member_name=jdbcmem;discovery=tibpgm://6660;debug=true
 *
 * If you want slf4j supported, please contact TIBCO and ask for it!
 *
 */
public class SimpleLogger
{
    boolean m_okToLog;

    public SimpleLogger(boolean allowLogging)
    {
        m_okToLog = allowLogging;
    }

    public void logTrace(Object message)
    {
        if (!m_okToLog)
            return;

        StringBuffer logMsg = new StringBuffer();
        logMsg.append(new Date().toString());
        logMsg.append(" TRACE: ");
        logMsg.append(String.valueOf(message));
        System.err.println(logMsg.toString());
    }
}
