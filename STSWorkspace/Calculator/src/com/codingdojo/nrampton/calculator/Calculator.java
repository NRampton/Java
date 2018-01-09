package com.codingdojo.nrampton.calculator;

public class Calculator implements java.io.Serializable {

	//For the Serializable interface, to avoid a warning
	private static final long serialVersionUID = 1L;
	
	//variables
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	
	public Calculator() {
		this.operandOne = 0.0;
		this.operandTwo = 0.0;
		this.operation = "+";
		this.result = 0.0;
	}
	
	//getters and setters
	public void setOperandOne(double operand) {
		this.operandOne = operand;
	}
	public double getOperandOne() {
		return this.operandOne;
	}
	public void setOperandTwo(double operand) {
		this.operandTwo = operand;
	}	
	public double getOperandTwo() {
		return this.operandTwo;
	}
	public void setOperation (String operation) {
		if (operation != "+" && operation != "-") {
			System.out.println("Not a valid operation");
			return;
		}
		this.operation = operation;
	}
	public String getOperation() {
		return this.operation;
	}
	
	//running the calculation
	public void performOperation() {
		if (this.operation == "+") {
			this.result = this.operandOne + this.operandTwo;
		} else {
			this.result = this.operandOne - this.operandTwo;
		}
	}
	public double getResult() {
		return this.result;
	}
}
