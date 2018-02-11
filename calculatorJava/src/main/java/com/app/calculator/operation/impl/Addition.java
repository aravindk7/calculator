package com.app.calculator.operation.impl;

import java.math.BigDecimal;

public class Addition extends AbstractBinaryOperation {

	@Override
	public BigDecimal compute(BigDecimal left, BigDecimal right) {

		validateOperands(left, right);

		return left.add(right);
	}

	

}
