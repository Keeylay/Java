package com.codingdojo.javaoop.objectmasterp2;

public class samurai extends human {
	protected static int totalSamurai = 0;
	
	public samurai() {
		this.health = 200;
		totalSamurai += 1;
	}
	
	public void deathBlow(human human) {
		human.health = 0;
		this.health = this.health/2;
	}
	
	public void meditate(human human) {
		this.health = 200;
	}
	
	public void howMany() {
		totalSamurai += 1;
	}
}
