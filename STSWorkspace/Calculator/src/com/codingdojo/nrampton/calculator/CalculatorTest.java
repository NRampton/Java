package com.codingdojo.nrampton.calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println("Initial result...");
		System.out.println(calc.getResult());
		calc.setOperandOne(5.43);
		calc.setOperandTwo(3.23);
		calc.setOperation("g");
		calc.setOperation("-");
		calc.performOperation();
		System.out.println(calc.getResult());
	}
}
