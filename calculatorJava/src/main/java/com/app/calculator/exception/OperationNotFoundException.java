package com.app.calculator.exception;

public class OperationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OperationNotFoundException(String message) {
		super(message);
	}

}
