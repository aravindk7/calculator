package com.app.calculator;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.app.calculator.exception.OperationNotFoundException;
import com.app.calculator.operation.BinaryOperation;
import com.app.calculator.operationfactory.BinaryOperationFactory;
import com.app.calculator.operationfactory.OperationFactory;

public class Calculator {

	private static Calculator calculator;

	private final BinaryOperationFactory binaryOperationFactory = new BinaryOperationFactory();

	private static final Set<OperationFactory> operationFactory = new HashSet<>();

	private Calculator() {
		init();
	}

	private void init() {
		operationFactory.add(binaryOperationFactory);
	}

	public static Calculator getInstance() {
		if (calculator == null) {
			calculator = new Calculator();
		}
		return calculator;
	}

	private OperationFactory getOperationFactory(final String operation) {
		OperationFactory factory = operationFactory.stream().filter(op -> op.getOperations().contains(operation))
				.findFirst().orElse(null);

		if (factory == null) {
			throw new OperationNotFoundException("Operation not found: " + operation);
		}

		return factory;
	}

	public BigDecimal compute(String operation, BigDecimal... operands) {

		OperationFactory factory = getOperationFactory(operation);

		if (factory instanceof BinaryOperationFactory) {
			BinaryOperationFactory binaryOperationFactory = (BinaryOperationFactory) factory;
			BinaryOperation binaryOperation = binaryOperationFactory.create(operation);
			binaryOperation.validateOperands(operands);
			return binaryOperation.compute(operands[0], operands[1]);
		}

		return null;
	}
}
