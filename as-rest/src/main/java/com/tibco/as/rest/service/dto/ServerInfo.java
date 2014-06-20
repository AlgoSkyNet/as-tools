package com.tibco.as.rest.service.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServerInfo extends BaseDto {
	private Integer port = 8080;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}	
}
