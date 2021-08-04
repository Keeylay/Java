package com.codingdojo.javaoop.objectmasterp2;

public class ninja extends human {
	public int stealth = 10;
	
	public void steal(human human) {
		human.health -= this.stealth;
		this.health += this.stealth; 
	}
	
	public void flee(human human) {
		human.health -= 10;
	}
}
