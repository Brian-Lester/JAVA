
public class Bat extends mammal {
	private int energy = 300;

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public String fly() {
		if(energy < 50) {
			return "The bat cant fly it doesnt have enough energy";
		}
		else {
		energy -= 50;
		return "shooooosh, the Super bats energy is " + energy;
		}
	}
	
	public String eatHuman() {
		energy += 25;
		return "ohhhh nooo not a human, the Super bats energy is " + energy;
	}
	
	public String attackTown() {
		if(energy < 100) {
			return "the town is saved the bat doesnt have enough energy to attack";
		}
		else {
		energy -= 100;
		return " we really should do something about that bat, thats the third time this month hes destroyed or town! " + energy;
		}
	}
}
