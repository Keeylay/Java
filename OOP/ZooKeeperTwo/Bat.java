package ZooKeeperTwo;

public class Bat extends RareSpecimen {
	public void fly() {
		System.out.println("*insert wing sound*");
		this.energy -= 50;
	}
	public void eatHuman() {
		System.out.println("CRUNCH");
		this.energy += 25;
	}
	public void attackTown() {
		System.out.println("the town burns");
		this.energy -= 100;
	}
}
