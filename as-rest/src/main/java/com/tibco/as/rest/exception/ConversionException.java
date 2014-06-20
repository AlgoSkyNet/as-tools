package com.tibco.as.rest.exception;

public class ConversionException extends ASRestException {

	private static final long serialVersionUID = -7347217221373082482L;

	public ConversionException() {
		super();
	}

	public ConversionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConversionException(String message) {
		super(message);
	}

	public ConversionException(Throwable cause) {
		super(cause);
	}
}
