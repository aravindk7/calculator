package com.app.calculator.operationfactory;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import com.app.calculator.exception.OperationNotFoundException;
import com.app.calculator.operation.BinaryOperation;
import com.app.calculator.operation.impl.Addition;
import com.app.calculator.operation.impl.Division;
import com.app.calculator.operation.impl.Multiplication;
import com.app.calculator.operation.impl.Subtraction;

/*
 * Factory to instantiate an operation involving two operands.
 */
public class BinaryOperationFactory implements OperationFactory {

	private static final Map<String, BinaryOperation> operations = new HashMap<>();

	public BinaryOperationFactory() {
		init();
	}

	private void init() {
		operations.put("+", new Addition());
		operations.put("-", new Subtraction());
		operations.put("*", new Multiplication());
		operations.put("/", new Division());
	}

	public BinaryOperation create(String operation) {
		final BinaryOperation binaryOperator = operations.get(operation);
		if (binaryOperator == null) {
			throw new OperationNotFoundException("Operation not found: " + operation);
		}
		return binaryOperator;
	}

	public Set<String> getOperations() {
		return operations.keySet();
	}
}
