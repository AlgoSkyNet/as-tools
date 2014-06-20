package com.tibco.as.rest.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "remoteInvoke")
public class RemoteInvokeResult extends BaseDto{

	private boolean hasError;
	private int resultSize;

	@XmlElementWrapper(name="results")
    @XmlElement(name="result")	
	private List<Result> results = new ArrayList<Result>();

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public int getResultSize() {
		return resultSize;
	}

	public void setResultSize(int resultSize) {
		this.resultSize = resultSize;
	}
	
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public static class Result{
		private boolean hasError;
		private String errorMessage="";
		private MembersInfo.Member member = new MembersInfo.Member();
		private Map<String, Object> resultData;
		
		public boolean isHasError() {
			return hasError;
		}
		public void setHasError(boolean hasError) {
			this.hasError = hasError;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}				
		public MembersInfo.Member getMember() {
			return member;
		}
		public void setMember(MembersInfo.Member member) {
			this.member = member;
		}
		public Map<String, Object> getResultData() {
			return resultData;
		}
		public void setResult(Map<String, Object> resultData) {
			this.resultData = resultData;
		}
	}
}
