package com.app.calculator.operation;

import java.math.BigDecimal;

public interface Operation {
	
	public void validateOperands(BigDecimal ...operands);
}
