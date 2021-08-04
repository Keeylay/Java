package com.codingdojo.javaoop.objectmasterp1;

public class humans {
	public int strength = 3;
	public int intelligence = 3;
	public int stealth = 3;
	public int health = 100;
	
	public void attack(humans person) {
		person.health -= this.strength;
	}
}
