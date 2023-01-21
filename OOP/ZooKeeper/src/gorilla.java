
public class gorilla extends mammal{

	
	public String throwSomething() {
		int energy = super.displayEnergy();
		energy -= 5;
		super.setEnergy(energy);
		return "Jim bob the gorilla threw something at a kid today his energy is " + energy;
	}
	
	public String eatBanana() {
		int energy = super.displayEnergy();
		energy += 10;
		super.setEnergy(energy);
		return "Jim bob ate a banana his energy is " + energy;
	}
	
	public String climb() {
		int energy = super.displayEnergy();
		energy -= 10;
		super.setEnergy(energy);
		return "Jim bob climbed the enclosure fence today and escaped his energy is " + energy;
	}
}
		
