package com.app.calculator.operation;

import java.math.BigDecimal;

/*
 * Represents an operation involving two operands.
 */
public interface BinaryOperation extends Operation {
	
	 public BigDecimal compute(BigDecimal left, BigDecimal right);
	 
	 //public BigDecimal compute(BigDecimal ...operands);
}
