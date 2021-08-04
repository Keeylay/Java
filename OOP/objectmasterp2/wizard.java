package com.codingdojo.javaoop.objectmasterp2;

public class wizard extends human {
	public int intelligence = 8;
	public int health = 50;
	
	public void healTarget(human human) {
		human.health += this.intelligence;
	}
	
	public void fireball(human human) {
		human.health -= this.intelligence*3;
	}
}
