package com.tibco.as.rest.service.dto;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.tibco.as.rest.util.MapAdapter;

@XmlRootElement(name = "tuple")
public class TupleInfo extends BaseDto {

	private String spaceName;

	@XmlPath(".")
	@XmlJavaTypeAdapter(MapAdapter.class)
	private Map<String, Object> data = new HashMap<String, Object>();

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
