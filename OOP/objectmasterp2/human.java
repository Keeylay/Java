package com.codingdojo.javaoop.objectmasterp2;

public class human {
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;
	
	public human() {
		this.strength = 3;
		this.intelligence = 3;
		this.stealth = 3;
		this.health = 100;
	}
	
	public void attack(human person) {
		person.health -= this.strength;
	}
	
	public void displayStats() {
		System.out.println(this.strength + this.stealth + this.intelligence + this.health);
	}
}
