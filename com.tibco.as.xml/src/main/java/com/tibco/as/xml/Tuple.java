package com.tibco.as.xml;

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
	private com.tibco.as.space.Tuple tuple;

	public Tuple() {
		this(com.tibco.as.space.Tuple.create());
	}

	public Tuple(com.tibco.as.space.Tuple tuple) {
		this.tuple = tuple;
	}

	public com.tibco.as.space.Tuple getTuple() {
		return tuple;
	}

	public void setTuple(com.tibco.as.space.Tuple tuple) {
		this.tuple = tuple;
	}

}
