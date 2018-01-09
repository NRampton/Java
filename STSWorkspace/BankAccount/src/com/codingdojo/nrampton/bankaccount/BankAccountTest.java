package com.codingdojo.nrampton.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount first = new BankAccount();
		BankAccount second = new BankAccount();
		second.savingsDeposit(30);
		System.out.println(BankAccount.accountsTotal);
	}

}
