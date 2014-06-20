package com.tibco.as.rest.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {

	public static String getJsonString(Object javaObj) {
		String ret = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			ret = mapper.writeValueAsString(javaObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static <T> T readJson2Obj(String json, Class<T> classObj) {
		T ret = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			ret = mapper.readValue(json, classObj);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public static <T> T[] readJson2Array(String json, Class<T[]> classObj) {
		T[] ret = null;
		ObjectMapper mapper = new ObjectMapper();
			try {
				ret = mapper.readValue(json, classObj);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		return ret;
	}
	
}