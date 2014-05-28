// -------------------------------------------------------------------
//  Copyright (c) 2012-2013 TIBCO Software, Inc.
//  All rights reserved.
//  For more information, please contact:
//  TIBCO Software Inc., Palo Alto, California, USA
// -------------------------------------------------------------------
package com.tibco.as.jdbc;

import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;

public class Utils
{
    public static final String URL                      = "jdbc:tibco:as";
    public static final String AS_FEATURE_NOT_SUPPORTED = "The ActiveSpaces JDBC Driver does not support this feature.";
    public static final String AS_STATEMENT_CLOSED      = "ActiveSpaces JDBC Driver method invoked on a closed statement.";

    /**
     * parseURL - parses JDBC URLs of the form
     * jdbc:tibco:as[:<data-source-name>][;<propertyName>=<propertyValue>]* For AS, we can have
     * property values which contain semi-colons(;) and question marks(?). For example, we could
     * have several well-known members to use for discovery as in:
     * discovery=tcp://ip1:port1;ip2:port2 Or we could have a remote client discovery URL like:
     * discovery=tcp://ip:port?remote=true So we need to make sure we handle these special cases.
     * Other than that, the format is typical of what other JDBC drivers use for their URLs.
     */
    public static java.util.Properties parseURL (String url)
    {
        java.util.Properties settings = new java.util.Properties();
        if (url != null)
        {
            // first check for a metaspace name to be specified as the data-source-name
            String prefix = URL + ":";
            if (url.startsWith(prefix) && url.length() > prefix.length() && url.charAt(prefix.length()) != ';')
            {
                // we could have a data-source-name
                String name = url.substring(prefix.length());
                int semi = name.indexOf(';');
                if (semi != -1)
                {
                    name = name.substring(0, semi);
                }
                settings.put("metaspace", name);

            }
            // now check for properties to be specified
            if (url.indexOf(';') != -1)
            {
                boolean bEndOfParams = false;
                int paramNameStartIndex = 0;
                int paramNameEndIndex = 0;
                int paramValueStartIndex = 0;
                int paramValueEndIndex = 0;
                String paramName = null;
                String paramValue = null;

                int currentPosition = url.indexOf(";", 0);
                while (url.charAt(currentPosition + 1) == ';')
                    currentPosition++;

                while (!bEndOfParams)
                {
                    // find the parameter name
                    paramNameStartIndex = currentPosition;
                    if (paramNameStartIndex == -1)
                    {
                        bEndOfParams = true;
                        continue;
                    }
                    paramNameStartIndex++;
                    paramNameEndIndex = url.indexOf("=", paramNameStartIndex);
                    if (paramNameEndIndex == -1)
                    {
                        bEndOfParams = true;
                        continue;
                    }
                    paramName = url.substring(paramNameStartIndex, paramNameEndIndex);

                    // find the parameter value
                    boolean found = false;
                    paramValueStartIndex = paramNameEndIndex + 1;
                    if (paramName.equalsIgnoreCase("discovery"))
                    {
                        // check for ?remote=true to end the setting
                        int idx = -1;
                        if ((idx = url.toLowerCase().indexOf("?remote=true")) != -1)
                        {
                            found = true;
                            paramValueEndIndex = idx + 12;
                        }
                        else if ((idx = url.toLowerCase().indexOf("?remote=false")) != -1)
                        {
                            found = true;
                            paramValueEndIndex = idx + 13;
                        }
                        if (found)
                        {
                            paramValue = url.substring(paramValueStartIndex, paramValueEndIndex);
                            currentPosition = paramValueStartIndex + paramValue.length();
                            while (url.charAt(currentPosition + 1) == ';')
                                currentPosition++;
                        }

                    }
                    if (!found)
                    {
                        paramValueEndIndex = url.indexOf("=", paramValueStartIndex);
                        if (paramValueEndIndex == -1)
                        {
                            // there is no next name/value parameter pair
                            // so we have the last parameter
                            paramValue = url.substring(paramValueStartIndex);
                            bEndOfParams = true;
                        }
                        else
                        {
                            // back up to the previous semi-colon
                            String tempVal = url.substring(paramValueStartIndex, paramValueEndIndex);
                            paramValueEndIndex = tempVal.lastIndexOf(";");
                            paramValue = tempVal.substring(0, paramValueEndIndex);
                            // now set the current position according to the original URL string
                            currentPosition = paramValueStartIndex + paramValue.length();
                            while (url.charAt(currentPosition + 1) == ';')
                                currentPosition++;
                        }
                    }
                    // store the parameter setting
                    settings.put(paramName.toLowerCase(), paramValue);
                }
            }
        }
        return settings;
    }

    /**
     * genURL - creates a JDBC URL from the given parameters of the form
     * jdbc:tibco:as[:<data-source-name>][;<propertyName>=<propertyValue>]*
     */
    public static String genURL (String name, String member_name, String discovery, String listen,
            String remote_discovery, String remote_listen, String rx_buffer_size, String worker_thread_count)
    {
        String url = URL;
        if (name != null && !name.isEmpty())
            url += ":" + name;
        if (member_name != null && !member_name.isEmpty())
            url += ";member_name=" + member_name;
        if (discovery != null && !discovery.isEmpty())
            url += ";discovery=" + discovery;
        if (listen != null && !listen.isEmpty())
            url += ";listen=" + listen;
        if (remote_discovery != null && !remote_discovery.isEmpty())
            url += ";remote_discovery=" + remote_discovery;
        if (remote_listen != null && !remote_listen.isEmpty())
            url += ";remote_listen=" + remote_listen;
        if (rx_buffer_size != null && !rx_buffer_size.isEmpty())
            url += ";rx_buffer_size=" + rx_buffer_size;
        if (worker_thread_count != null && !worker_thread_count.isEmpty())
            url += ";worker_thread_count=" + worker_thread_count;
        return url;
    }

    /**
     * getURL - returns the JDBC URL for the given metaspace
     */
    public static String getURL (Metaspace metaspace)
    {
        String url = URL;
        String name = null;
        String discovery = null;
        String listen = null;
        String member_name = null;
        String remote_discovery = null;
        String remote_listen = null;
        long rx_buffer_size = 0;
        int worker_thread_count = 0;

        if (metaspace != null)
        {
            name = metaspace.getName();
            MemberDef mdef = metaspace.getMemberDef();
            if (mdef != null)
            {
                member_name = mdef.getMemberName();
                discovery = mdef.getDiscovery();
                listen = mdef.getListen();
                remote_discovery = mdef.getRemoteDiscovery();
                remote_listen = mdef.getRemoteListen();
                rx_buffer_size = mdef.getRxBufferSize();
                worker_thread_count = mdef.getWorkerThreadCount();
            }
            url = genURL(name, member_name, discovery, listen, remote_discovery, remote_listen,
                    Long.toString(rx_buffer_size), Integer.toString(worker_thread_count));
        }
        return url;
    }

    /**
     * createURL - creates a JDBC URL from the given properties of the form
     * jdbc:tibco:as[:<data-source-name>][;<propertyName>=<propertyValue>]*
     */
    public static String createURL (java.util.Properties settings)
    {
        String url = URL;
        String name = null;
        String discovery = null;
        String listen = null;
        String member_name = null;
        String remote_discovery = null;
        String remote_listen = null;
        String rx_buffer_size = null;
        String worker_thread_count = null;

        if (settings != null && !settings.isEmpty())
        {
            Metaspace metaspace = (Metaspace) settings.get(Metaspace.class.getName());
            if (metaspace != null)
            {
                url = getURL(metaspace);
            }
            else
            {
                // check for metaspace name and properties to be specified
                name = settings.getProperty("metaspace", null);
                member_name = settings.getProperty("member_name", null);
                discovery = settings.getProperty("discovery", null);
                listen = settings.getProperty("listen", null);
                remote_discovery = settings.getProperty("remote_discovery", null);
                remote_listen = settings.getProperty("remote_listen", null);
                rx_buffer_size = settings.getProperty("rx_buffer_size", null);
                worker_thread_count = settings.getProperty("worker_thread_count", null);
                url = genURL(name, member_name, discovery, listen, remote_discovery, remote_listen, rx_buffer_size,
                        worker_thread_count);
            }
        }
        return url;
    }
}
