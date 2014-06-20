package com.tibco.as.rest.server;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ASApplication extends ResourceConfig {

	public ASApplication() {
		super(MoxyXmlFeature.class, JacksonFeature.class);
		packages("com.tibco.as.rest.service");
	}

}