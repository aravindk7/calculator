package calculatorJava;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.app.calculator.exception.OperationNotFoundException;
import com.app.calculator.operation.BinaryOperation;
import com.app.calculator.operationfactory.BinaryOperationFactory;

public class BinaryOperationFactoryTest {
	private BinaryOperationFactory binaryOperationFactory = new BinaryOperationFactory();;

	@Test
	void getOperationsTest() {
		assertNotEquals(binaryOperationFactory.getOperations().size(), 0, "Operations size should be grater than zero");
	}

	@Test
	void invalidOperationTest() {
		assertThrows(OperationNotFoundException.class, () -> {
			binaryOperationFactory.create("$$");
		});
	}

	@Test
	void validOperationTest() {
		assertTrue(binaryOperationFactory.create("+") instanceof BinaryOperation);
	}

}
