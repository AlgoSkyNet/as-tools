package com.tibco.as.xml;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.eclipse.persistence.oxm.annotations.XmlVariableNode;

import com.tibco.as.space.DateTime;
import com.tibco.as.space.Tuple;
import com.tibco.as.xml.MapAdapter.AdaptedMap;

public class MapAdapter extends XmlAdapter<AdaptedMap, Tuple> {

	public static class AdaptedMap {

		@XmlVariableNode("key")
		List<AdaptedEntry> entries = new ArrayList<AdaptedEntry>();

	}

	public static class AdaptedEntry {

		@XmlTransient
		public String key;

		@XmlValue
		public Object value;

	}

	@Override
	public AdaptedMap marshal(Tuple tuple) throws Exception {
		AdaptedMap adaptedMap = new AdaptedMap();
		for (String fieldName : tuple.getFieldNames()) {
			if (tuple.isNull(fieldName)) {
				continue;
			}
			Object value = tuple.get(fieldName);
			if (value == null) {
				continue;
			}
			AdaptedEntry entry = new AdaptedEntry();
			entry.key = fieldName;
			entry.value = getValue(value);
			adaptedMap.entries.add(entry);
		}
		return adaptedMap;
	}

	private Object getValue(Object value) {
		if (value instanceof DateTime) {
			return ((DateTime) value).getTime().getTime();
		}
		return value;
	}

	@Override
	public Tuple unmarshal(AdaptedMap adaptedMap) throws Exception {
		List<AdaptedEntry> entries = adaptedMap.entries;
		Tuple tuple = Tuple.create();
		for (AdaptedEntry entry : entries) {
			if (entry.value instanceof GregorianCalendar) {
				GregorianCalendar calendar = (GregorianCalendar) entry.value;
				DateTime dateTime = DateTime.create(calendar.getTimeInMillis());
				tuple.putDateTime(entry.key, dateTime);
			} else {
				tuple.put(entry.key, entry.value);
			}
		}
		return tuple;
	}
}