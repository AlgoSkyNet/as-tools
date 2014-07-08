package com.tibco.as.xml;

import java.util.HashMap;
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
	private Map<String, Object> data;

	public Tuple() {
		this.data = new HashMap<String, Object>();
	}

	public Tuple(Map<String, Object> map) {
		this.data = map;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
