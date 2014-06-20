package com.tibco.as.rest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.rest.service.dto.ConfigInfo;
import com.tibco.as.rest.service.dto.MemberConfig;
import com.tibco.as.rest.service.dto.MetaspaceInfo;
import com.tibco.as.rest.util.ASUtil;
import com.tibco.as.rest.util.ConfigUtil;
import com.tibco.as.rest.util.JsonUtil;
import com.tibco.as.rest.util.MetaspaceUtil;
import com.tibco.as.rest.util.StringUtil;

public class RestServletContextListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(RestServletContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		try{
			String metaspacesJson = event.getServletContext().getInitParameter("metaspaces");
			if(StringUtil.isNotEmpty(metaspacesJson)){
				MemberConfig[] memArr = JsonUtil.readJson2Array(metaspacesJson, MemberConfig[].class);
				for (MemberConfig member : memArr) {
					MetaspaceUtil.put(member.getMetaspaceName(), ASUtil.connectMetaspace(member));
				}
			}
			
			String fileName = event.getServletContext().getInitParameter("fileName");
			if(StringUtil.isNotEmpty(fileName)){
				ConfigInfo configInfo = ConfigUtil.getConfigInfo(fileName);
				for(MetaspaceInfo metaspaceInfo : configInfo.getMetaspaceInfoList()) {
					MetaspaceUtil.put(metaspaceInfo.getName(), ASUtil.connectMetaspace(metaspaceInfo));
				}
			}
		}catch(Exception e){
			logger.error("error occur when contextInitialized:", e);
		}
	}

}
