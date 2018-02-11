package com.app.calculator;

public class CalculatorApp {

	public static void main(String[] args) {
		Calculator calculator = Calculator.getInstance();
		CalculatorDisplay calculatorDisplay = new CalculatorDisplay(calculator);

		do {
			calculatorDisplay.displayMenu();
		} while (calculatorDisplay.processInputAndContinue());
	}

}
