package com.tibco.as.rest.service.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigInfo extends BaseDto {
	private ServerInfo serverInfo;
	private List <MetaspaceInfo> metaspaceInfoList;
	
	public ServerInfo getServerInfo() {
		return serverInfo;
	}
	public void setServerInfo(ServerInfo serverInfo) {
		this.serverInfo = serverInfo;
	}
	public List<MetaspaceInfo> getMetaspaceInfoList() {
		return metaspaceInfoList;
	}
	public void setMetaspaceInfoList(List<MetaspaceInfo> metaspaceInfoList) {
		this.metaspaceInfoList = metaspaceInfoList;
	}
}
