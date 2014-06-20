package com.tibco.as.rest.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassPathUtil {
	private static Logger logger = LoggerFactory.getLogger(ClassPathUtil.class);
    @SuppressWarnings("rawtypes")
	private static final Class[] parameters = new Class[] { URL.class };   
    
    public static void addFile(String aFileName) throws IOException{   
        File f = new File(aFileName);   
        addFile(f);   
    }   
    
    @SuppressWarnings("deprecation")
	public static void addFile(File aFile) throws IOException{   
        addURL(aFile.toURL());   
    }   
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addURL(URL aURL) throws IOException{   
        URLClassLoader sysLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();   
        URL urls[] = sysLoader.getURLs();
        for (int i = 0; i < urls.length; i++) {
            if (urls[i].toString().equalsIgnoreCase(aURL.toString())) {
                return;
            }
        }

        Class sysclass = URLClassLoader.class;   
        try{   
            Method method = sysclass.getDeclaredMethod("addURL", parameters);   
            method.setAccessible(true);   
            method.invoke(sysLoader, new Object[] { aURL });   
        }catch (Throwable t){   
        	logger.error("error occur when load jar:", t);
            throw new IOException("Error adding " + aURL + " to system classloader");   
        }   
    } 
}
