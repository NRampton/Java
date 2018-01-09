package com.codingdojo.nrampton.bankaccount;

import java.lang.StringBuilder;
import java.util.Random;

public class BankAccount {
	
	//class members
	private static int accountsCount = 0;
	static double accountsTotal = 0;
	private static void displayTotal() {
		System.out.println("Grand total is " + accountsTotal);
	}
	
	private String acctNumber;
	private double checkingBalance = 0;
	private double savingsBalance = 0;
		
	//constructor
	public BankAccount() {
		this.acctNumber = generateAcctNumber();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		accountsCount++;
	}
	
	//generate a bank account number
	private String generateAcctNumber() {
		StringBuilder strBuilder = new StringBuilder();
	    Random rand = new Random();
	    for (int i = 0; i < 10; i += 1) {
	      int newDigit =  rand.nextInt(10);
	      strBuilder.append(newDigit);
	    }
	    return strBuilder.toString();
	}
	
	//getters
	private double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingsBalance() {
		return this.savingsBalance;
	}

	//money in and out
	public void checkingDeposit(double amt) {
		if (amt < 0) {
			System.out.println("A negative deposit is a withdrawal. Please select the appropriate transaction");
			return;
		}
		this.checkingBalance += amt;
		accountsTotal += amt;
	}
	public void savingsDeposit(double amt) {
		if (amt < 0) {
			System.out.println("A negative deposit is a withdrawal. Please select the appropriate transaction");
			return;
		}
		this.savingsBalance += amt;
		accountsTotal += amt;
	}
	public void checkingWithdrawal(double amt) {
		if (amt > this.checkingBalance) {
			System.out.println("No can do. You ain't got that much.");
			return;
		}
		this.checkingBalance -= amt;
		accountsTotal -= amt;
	}
	public void savingsWithdrawal(double amt) {
		if (amt > this.savingsBalance) {
			System.out.println("No can do. You ain't got that much.");
			return;
		}
		this.savingsBalance -= amt;
		accountsTotal -= amt;
	}
	
	//seeing balances
	public void displayBalances() {
		System.out.println("Checking balance: " + this.checkingBalance);
		System.out.println("Savings balance: " + this.savingsBalance);
	}
	
	
}