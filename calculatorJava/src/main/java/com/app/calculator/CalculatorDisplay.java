package com.app.calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorDisplay {

	private final Scanner scanner = new Scanner(System.in);

	private final Calculator calculator;

	public CalculatorDisplay(Calculator calculator) {
		this.calculator = calculator;
	}

	public void displayMenu() {
		System.out.println("Calculator Demo...");
		System.out.println("Please q to Quit or Input <Operand Opeator Operand> E.g 4 + 2 ");
		System.out.println("Valid Operators are +,-,*,/. Valid Operands are any number including decimals.");
	}

	public void displayExitMenu() {
		System.out.println("Program Exited...");
	}

	public void displaywarning() {
		System.out.println("Please input 3 arguments separated by spaces. <Operand Opeator Operand> E.g 4 / 2");
	}

	private String[] scanInput() {

		String argument = scanner.nextLine();
		if (argument.equalsIgnoreCase("q")) {
			System.exit(0);
		}

		String args[] = argument.split(" ");
		return args;

	}

	public boolean processInputAndContinue() {
		String[] argument = null;

		try {
			do {
				argument = scanInput();
				if (argument.length != 3) {
					displaywarning();
				}
			} while (argument != null && argument.length < 3);

			BigDecimal result = calculator.compute(argument[1], new BigDecimal(argument[0]),
					new BigDecimal(argument[2]));
			String output = String.format("%s %s %s = %s", argument[0], argument[1], argument[2], result.toString());
			System.out.println(output);
			System.out.println();
		} catch (RuntimeException e) {
			e.printStackTrace();
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			displaywarning();
		}

		return true;
	}

}
