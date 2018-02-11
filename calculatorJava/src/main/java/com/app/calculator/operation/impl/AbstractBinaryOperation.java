package com.app.calculator.operation.impl;

import java.math.BigDecimal;

import com.app.calculator.exception.InsufficientOperandException;
import com.app.calculator.operation.BinaryOperation;

public abstract class AbstractBinaryOperation implements BinaryOperation {

	public void validateOperands(BigDecimal... operands) {
		if (operands == null || operands.length != 2) {
			throw new InsufficientOperandException(2, operands == null ? 0 : operands.length);
		}
	}

	protected void validateOperands(BigDecimal left, BigDecimal right) {

		if (left == null) {
			throw new NullPointerException("Left operand is null.");
		}
		if (right == null) {
			throw new NullPointerException("Right operand is null.");
		}
	}
}
