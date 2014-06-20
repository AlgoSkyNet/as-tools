package com.tibco.as.rest.exception;


public class KeyFieldsCountException extends ASRestException {

	private static final long serialVersionUID = -1236207290661707354L;

	public KeyFieldsCountException() {
		super(String.format("Invalid key field number"));
	}

}
