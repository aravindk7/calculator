package calculatorJava;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.calculator.Calculator;
import com.app.calculator.exception.InsufficientOperandException;
import com.app.calculator.exception.OperationNotFoundException;
import com.app.calculator.operation.BinaryOperation;

class CalculatorTest {

	private Calculator calculator = Calculator.getInstance();
	private BigDecimal[] operands;

	@BeforeEach
	void init() {
		operands = new BigDecimal[] { new BigDecimal(10), new BigDecimal(5) };
	}

	@Test
	void additionTest() {
		assertEquals(calculator.compute("+", operands).intValue(), 15);
	}

	@Test
	void subtractionTest() {
		assertEquals(calculator.compute("-", operands).intValue(), 5);
	}

	@Test
	void multiplicationTest() {
		assertEquals(calculator.compute("*", operands).intValue(), 50);
	}

	@Test
	void divisionTest() {
		assertEquals(calculator.compute("/", operands).intValue(), 2);
	}

	@Test
	void divisionByZeroTest() {
		operands = new BigDecimal[] { new BigDecimal(10), new BigDecimal(0) };
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.compute("/", operands);
		});
	}

	@Test
	void insufficientOperandsTest() {
		operands = new BigDecimal[] { new BigDecimal(10) };
		assertThrows(InsufficientOperandException.class, () -> {
			calculator.compute("+", operands);
		});
	}

	@Test
	void inValidOperationFactoryTest() {
		assertThrows(OperationNotFoundException.class, () -> {
			calculator.compute("&^", operands);
		});
	}

}
