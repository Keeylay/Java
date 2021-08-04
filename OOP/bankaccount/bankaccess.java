package com.codingdojo.javaoop.bankaccount;

public class bankaccess {
	public static void main(String[] args) {
		bankaccount bank = new bankaccount();
		System.out.println(bankaccount.totalAccMade);
		bank.deposit(0, 2000.00);
		bank.deposit(1, 20000.00);
		bank.withdraw(0, 1000.00);
		System.out.println(bank.accountBal());
	}
}

