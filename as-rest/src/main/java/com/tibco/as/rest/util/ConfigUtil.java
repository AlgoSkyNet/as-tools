package com.tibco.as.rest.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tibco.as.rest.service.dto.ConfigInfo;
import com.tibco.as.rest.service.dto.MetaspaceInfo;
import com.tibco.as.rest.service.dto.ServerInfo;

public class ConfigUtil {
	private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	
	public static ConfigInfo getConfigInfo(String fileName) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(fileName);
		
		ConfigInfo configInfo = new ConfigInfo();
		
		NodeList server = document.getElementsByTagName("server");		
		Node serverNode = server.item(0);
		ServerInfo serverInfo = new ServerInfo();
		
		if(serverNode != null){
			NodeList serverNodeList = serverNode.getChildNodes();
			for (int i = 0; i < serverNodeList.getLength(); i++) {
				Node node = serverNodeList.item(i);
				if(node != null){
					String nodeValue = node.getTextContent().trim();
					if(!nodeValue.equals("")){
						if(node.getNodeName().equals("port")){
							serverInfo.setPort(Integer.parseInt(nodeValue));
						}
					}
				}
			}
			configInfo.setServerInfo(serverInfo);
		}
		
		NodeList metaspaces = document.getElementsByTagName("metaspace");
		List <MetaspaceInfo> metaspaceInfoList = new ArrayList<MetaspaceInfo>();
		
		for (int i = 0; i < metaspaces.getLength(); i++) {
			MetaspaceInfo metaspaceInfo = new MetaspaceInfo();
			
			Node metaspace = metaspaces.item(i);
			NodeList metaspaceInfoNodeList = metaspace.getChildNodes();
			
			for (int j = 0; j < metaspaceInfoNodeList.getLength(); j++) {
				Node node = metaspaceInfoNodeList.item(j);
				if(node != null) {
					String nodeValue = node.getTextContent().trim();
					
					if(!nodeValue.equals("")){
						if(node.getNodeName().equals("name")){
							metaspaceInfo.setName(nodeValue);
						}else if(node.getNodeName().equals("discovery")){
							metaspaceInfo.setDiscovery(nodeValue);
						}else if(node.getNodeName().equals("listen")){
							metaspaceInfo.setListen(nodeValue);
						}else if(node.getNodeName().equals("remote_listen")){
							//metaspaceInfo.setRemoteListen(nodeValue);
						}else if(node.getNodeName().equals("remote_discovery")){
							//metaspaceInfo.setRemoteDiscovery(nodeValue);
						}else if(node.getNodeName().equals("member_name")){
							metaspaceInfo.setMemberName(nodeValue);
						}else if(node.getNodeName().equals("rx_buffer_size")){
							//metaspaceInfo.setRxBufferSize(Long.parseLong(nodeValue));
						}else if(node.getNodeName().equals("transport_thread_count")){
							//metaspaceInfo.setTransportThreadCount(Integer.parseInt(nodeValue));
						}else if(node.getNodeName().equals("worker_thread_count")){
							//metaspaceInfo.setWorkerThreadCount(Integer.parseInt(nodeValue));
						}else if(node.getNodeName().equals("data_store")){
							//metaspaceInfo.setDataStore(nodeValue);
						}else if(node.getNodeName().equals("security_policy")){
							//metaspaceInfo.setSecurityPolicy(nodeValue);
						}else if(node.getNodeName().equals("security_token")){
							//metaspaceInfo.setSecurityToken(nodeValue);
						}else if(node.getNodeName().equals("authentication_callback")){
							//metaspaceInfo.setAuthenticationCallback(nodeValue);
						}
					}
				}
			}
	
			metaspaceInfoList.add(metaspaceInfo);
		}
		configInfo.setMetaspaceInfoList(metaspaceInfoList);
		logger.debug(configInfo.toString());
		return configInfo;
	}
}
