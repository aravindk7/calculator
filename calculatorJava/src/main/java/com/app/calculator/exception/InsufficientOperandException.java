package com.app.calculator.exception;

public class InsufficientOperandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientOperandException(String message ) {
		super(message);
	}
	
	public InsufficientOperandException(int expected, int found) {
		super("Expected "+ expected + " operands...Found " + found + " arguments..." );
	}
}
