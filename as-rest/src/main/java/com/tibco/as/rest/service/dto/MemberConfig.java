package com.tibco.as.rest.service.dto;

public class MemberConfig extends BaseDto {
	
	private String metaspaceName;
	private String memberName;
	private String discovery;
	private String listener;
	private String remoteDiscovery;
	private String remoteListener;
	private String dataStore;
	private String type;
	
	private String securityType;
	private String domain;
	private String userName;
	private String password;
	private String tokenPath;
	private String keyFile;
	private String keyPassword;
	
	private String objKey;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getDiscovery() {
		return discovery;
	}
	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}
	public String getListener() {
		return listener;
	}
	public void setListener(String listener) {
		this.listener = listener;
	}
	public String getRemoteDiscovery() {
		return remoteDiscovery;
	}
	public void setRemoteDiscovery(String remoteDiscovery) {
		this.remoteDiscovery = remoteDiscovery;
	}
	public String getRemoteListener() {
		return remoteListener;
	}
	public void setRemoteListener(String remoteListener) {
		this.remoteListener = remoteListener;
	}
	public String getDataStore() {
		return dataStore;
	}
	public void setDataStore(String dataStore) {
		this.dataStore = dataStore;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMetaspaceName() {
		return metaspaceName;
	}
	public void setMetaspaceName(String metaspaceName) {
		this.metaspaceName = metaspaceName;
	}
	public String getObjKey() {
		return objKey;
	}
	public void setObjKey(String objKey) {
		this.objKey = objKey;
	}

	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTokenPath() {
		return tokenPath;
	}
	public void setTokenPath(String tokenPath) {
		this.tokenPath = tokenPath;
	}
	public String getKeyFile() {
		return keyFile;
	}
	public void setKeyFile(String keyFile) {
		this.keyFile = keyFile;
	}
	public String getKeyPassword() {
		return keyPassword;
	}
	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}
}
