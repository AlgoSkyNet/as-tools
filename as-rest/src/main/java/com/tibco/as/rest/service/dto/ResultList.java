package com.tibco.as.rest.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resultList")
public class ResultList extends BaseDto{
	private boolean hasError;
	private List<Result> resultList = new ArrayList<Result>();
	
	public static class Result{
		private boolean hasError;
		private String errorMessage="";
		private Map<String, Object> data;
		public boolean isHasError() {
			return hasError;
		}
		public void setHasError(boolean hasError) {
			this.hasError = hasError;
		}
		public Map<String, Object> getData() {
			return data;
		}
		public void setData(Map<String, Object> data) {
			this.data = data;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}		
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
}
