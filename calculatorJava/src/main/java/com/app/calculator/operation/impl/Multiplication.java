package com.app.calculator.operation.impl;

import java.math.BigDecimal;

public class Multiplication extends AbstractBinaryOperation {

	@Override
	public BigDecimal compute(BigDecimal left, BigDecimal right) {

		validateOperands(left, right);

		return left.multiply(right);

	}

}
