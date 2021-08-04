package com.codingdojo.javaoop.bankaccount;

import java.util.Random;

public class bankaccount {
	public static int totalAccMade;
	public static double totalAccSum;
	
	private String accNum = "";
	private double balSav = 0;
	private double balCheck = 0;
	
	bankaccount() {
		this.accNum = randAcc();
		totalAccMade += 1;
	}
	
	private String randAcc() {
		int[] arr = new int[10];
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10);
		}
		return arr.toString();
	}
	
	public double getBalCheck() {
		return this.balCheck;
	}
	
	public double getBalSav() {
		return this.balSav;
	}
	
	public void deposit(int account, double amount) {
		if(account == 0) {
			this.balSav += amount;
		} else if (account == 1) {
			this.balCheck += amount;
		} else {
			System.out.println("input is either 0 or 1");
		}
	}
	
	public void withdraw(int account, double amount) {
		if (account == 0 && (this.balSav - amount) >= 0) {
			this.balSav -= amount;
		} else if (account == 1 && (this.balSav - amount) >= 0) {
			this.balCheck -= amount;
		} else {
			System.out.println("Error");
		}
	}
	
	public double accountBal() {
		return this.balCheck + this.balSav;
	}
}
