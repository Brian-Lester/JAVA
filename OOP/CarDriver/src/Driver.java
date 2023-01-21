
public class Driver extends Car{
	
	Car car = new Car();
	
	public String driveCar() {
		int gas = car.getGas();
		gas -= 1;
		car.setGas(gas);
		return "You went for a drive your gas is now at " + car.getGas();
	}
	
	public String boostCar() {
		int gas = car.getGas();
		gas -= 3;
		if (gas <= 3) {
		car.setGas(gas);
		return "You just used boost your gas is now at " + car.getGas();
		}
		else {
			return "Not enough fuel to boost";
		}
	}
	
	public String refuelCar() {
		int gas = car.getGas();
		if(gas <= 8) {
		gas += 2;
		car.setGas(gas);
		return "You just refueled your gas is now at " + car.getGas();
		}
		else {
			return "You cant refuel max gas is 10"; 
		}
	}
}
