package ZooKeeperOne;

public class Mammal {
	int energy;
	Mammal(){
		energy = 100;
	}
	public int displayEnergy() {
		System.out.println(this.energy);
		return this.energy;
	}
}
