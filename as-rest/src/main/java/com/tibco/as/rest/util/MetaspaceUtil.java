package com.tibco.as.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.space.ASException;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;

public class MetaspaceUtil {
	private static Logger logger = LoggerFactory.getLogger(MetaspaceUtil.class);
	
	private static Map<String, Metaspace> map = new ConcurrentHashMap<String, Metaspace>();
	
	public static void put(String metaspaceName, Metaspace metaspace){
		map.put(metaspaceName, metaspace);
	}
	
	public static Metaspace get(String metaspaceName){
		Metaspace metaspace = map.get(metaspaceName);
		if(metaspace == null){
			String errorMessage = "can not found metaspace:" + metaspaceName;
			logger.error(errorMessage);
			throw new WebApplicationException(errorMessage, Status.NOT_FOUND);
		}
		return metaspace;
	}
	
	public static List<String> getMetaspaceNames(){
		return new ArrayList<String>(map.keySet());
	}
	
	public static Space getSpace(String metaspaceName, String spaceName){
		Space space;
		try {
			space = get(metaspaceName).getSpace(spaceName);
		} catch (ASException e) {
			logger.error("error occur when getSpace", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		if (space==null) {
			String errorMessage = "can not found space:" + spaceName;
			logger.error(errorMessage);
			throw new WebApplicationException(errorMessage, Status.NOT_FOUND);
		}
		return space;
	}
	
	public static SpaceDef getSpaceDef(String metaspaceName, String spaceName){
		SpaceDef spaceDef;
		try {
			spaceDef = get(metaspaceName).getSpaceDef(spaceName);
		} catch (ASException e) {
			logger.error("error occur when getSpaceDef", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		if (spaceDef==null) {
			String errorMessage = "can not found space:" + spaceName;
			logger.error(errorMessage);
			throw new WebApplicationException(errorMessage, Status.NOT_FOUND);
		}
		return spaceDef;
	}
}
