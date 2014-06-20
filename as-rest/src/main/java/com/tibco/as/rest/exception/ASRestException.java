package com.tibco.as.rest.exception;

public class ASRestException extends Exception {

	private static final long serialVersionUID = -7347217221373082482L;

	public ASRestException() {
		super();
	}

	public ASRestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ASRestException(String message) {
		super(message);
	}

	public ASRestException(Throwable cause) {
		super(cause);
	}


}
