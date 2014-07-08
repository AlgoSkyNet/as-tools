package com.tibco.as.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.tibco.as.space.ASCommon;
import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Member.DistributionRole;

public class Utils {

	public static List<FieldDef> getFieldDefs(SpaceDef spaceDef,
			String... fieldNames) {
		List<FieldDef> result = new ArrayList<FieldDef>();
		for (String fieldName : getFieldNames(spaceDef.getFieldDefs(),
				fieldNames)) {
			result.add(spaceDef.getFieldDef(fieldName));
		}
		return result;
	}

	public static List<String> getFieldNames(FieldDef... fieldDefs) {
		return getFieldNames(Arrays.asList(fieldDefs));
	}

	public static List<String> getFieldNames(Collection<FieldDef> fieldDefs,
			String... fieldNames) {
		List<String> result = new ArrayList<String>();
		if (fieldNames == null || fieldNames.length == 0) {
			for (FieldDef fieldDef : fieldDefs) {
				result.add(fieldDef.getName());
			}
		} else {
			result.addAll(Arrays.asList(fieldNames));
		}
		return result;

	}

	public static List<String> getFieldNames(SpaceDef spaceDef,
			String... fieldNames) {
		return getFieldNames(spaceDef.getFieldDefs(), fieldNames);
	}

	public static List<FieldDef> getKeyFieldDefs(SpaceDef spaceDef) {
		List<FieldDef> fieldDefs = new ArrayList<FieldDef>();
		for (String key : spaceDef.getKeyDef().getFieldNames()) {
			fieldDefs.add(spaceDef.getFieldDef(key));
		}
		return fieldDefs;
	}

	public static List<String> getNonKeyFieldNames(SpaceDef spaceDef) {
		Collection<FieldDef> fieldDefs = spaceDef.getFieldDefs();
		Collection<String> keys = spaceDef.getKeyDef().getFieldNames();
		List<String> fieldNames = new ArrayList<String>();
		for (FieldDef fieldDef : fieldDefs) {
			String fieldName = fieldDef.getName();
			if (!keys.contains(fieldName)) {
				fieldNames.add(fieldName);
			}
		}
		return fieldNames;
	}

	public static boolean hasMethod(Class<?> clazz, String name) {
		for (Method method : clazz.getMethods()) {
			if (method.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static String getMetaspaceName(String metaspaceName) {
		return metaspaceName == null ? "ms" : metaspaceName;
	}

	public static Metaspace getMetaspace(String name) {
		return ASCommon.getMetaspace(getMetaspaceName(name));
	}

	public static String getSpaceURI(String metaspaceName, String spaceName) {
		return getMetaspaceName(metaspaceName) + "." + spaceName;
	}

	public static String getSpaceURI(Metaspace metaspace, String spaceName) {
		return getSpaceURI(metaspace.getName(), spaceName);
	}

	public static Space getSpace(String metaspaceName, String spaceName,
			DistributionRole distributionRole) throws ASException {
		Metaspace metaspace = getMetaspace(metaspaceName);
		if (distributionRole == null) {
			return metaspace.getSpace(spaceName);
		}
		return metaspace.getSpace(spaceName, distributionRole);
	}

}
