package com.tibco.as.rest.service.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metaspace")
public class MetaspaceInfo extends BaseDto{	
	private String  name = "ms";
	private String  discovery = "tibpgm";
	private String  listen = "tcp";
	private String  memberName;
	/*
	private String  remoteListen;
	private String  remoteDiscovery;
	private Long    rxBufferSize;
	private Integer transportThreadCount;
	private Integer workerThreadCount;
	private String  dataStore;
	private String  securityPolicy;
	private String  securityToken;
	private String  authenticationCallback;
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscovery() {
		return discovery;
	}
	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}
	public String getListen() {
		return listen;
	}
	public void setListen(String listen) {
		this.listen = listen;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}	
	/*
	public String getRemoteListen() {
		return remoteListen;
	}
	public void setRemoteListen(String remoteListen) {
		this.remoteListen = remoteListen;
	}
	public String getRemoteDiscovery() {
		return remoteDiscovery;
	}
	public void setRemoteDiscovery(String remoteDiscovery) {
		this.remoteDiscovery = remoteDiscovery;
	}
	public Long getRxBufferSize() {
		return rxBufferSize;
	}
	public void setRxBufferSize(Long rxBufferSize) {
		this.rxBufferSize = rxBufferSize;
	}
	public Integer getTransportThreadCount() {
		return transportThreadCount;
	}
	public void setTransportThreadCount(Integer transportThreadCount) {
		this.transportThreadCount = transportThreadCount;
	}
	public Integer getWorkerThreadCount() {
		return workerThreadCount;
	}
	public void setWorkerThreadCount(Integer workerThreadCount) {
		this.workerThreadCount = workerThreadCount;
	}
	public String getDataStore() {
		return dataStore;
	}
	public void setDataStore(String dataStore) {
		this.dataStore = dataStore;
	}
	public String getSecurityPolicy() {
		return securityPolicy;
	}
	public void setSecurityPolicy(String securityPolicy) {
		this.securityPolicy = securityPolicy;
	}
	public String getSecurityToken() {
		return securityToken;
	}
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
	public String getAuthenticationCallback() {
		return authenticationCallback;
	}
	public void setAuthenticationCallback(String authenticationCallback) {
		this.authenticationCallback = authenticationCallback;
	}
	*/
}
