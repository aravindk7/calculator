package com.app.calculator.operation.impl;

import java.math.BigDecimal;

public class Division extends AbstractBinaryOperation {

	@Override
	public BigDecimal compute(BigDecimal left, BigDecimal right) {

		validateOperands(left, right);

		if (BigDecimal.ZERO.equals(right)) {
			throw new IllegalArgumentException("Divide by zero");
		}

		return left.divide(right);
	}

}
