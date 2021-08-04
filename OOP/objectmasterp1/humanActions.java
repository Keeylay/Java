package com.codingdojo.javaoop.objectmasterp1;

public class humanActions {
	public static void main (String[] args) {
		humans one = new humans();
		humans two = new humans();
	
		one.attack(two);
		System.out.println(two.health);
	}
}
