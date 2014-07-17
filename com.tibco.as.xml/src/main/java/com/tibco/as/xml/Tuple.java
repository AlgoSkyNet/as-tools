package com.tibco.as.xml;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "tuple")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tuple {

	@XmlPath(".")
	@XmlJavaTypeAdapter(MapAdapter.class)
	private Map<String, Object> map;

	public Tuple() {
	}
	
	public Tuple(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
