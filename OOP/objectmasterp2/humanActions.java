package com.codingdojo.javaoop.objectmasterp2;

public class humanActions {
	public static void main(String[] args) {
		samurai fight = new samurai();
		ninja slash = new ninja();
		wizard spell = new wizard();
		
		fight.deathBlow(spell);
		slash.flee(fight);
		spell.healTarget(spell);
		spell.displayStats();
		slash.displayStats();
		fight.displayStats();
	}

}
