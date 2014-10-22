
public class Airplane {

	private int fuel  = 25;
	private int count = 0;
	boolean isCrashed = false;
	public int getFuel() {
		
		return fuel;
	}
	public void setFuel(int fuel) {
		if (fuel < 0){
			fuel = 0;
		}
		this.fuel = fuel;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isCrashed() {
		if (fuel == 0){
			isCrashed = true;
		}
		else {
			isCrashed = false;
			
		}
		return isCrashed;
	}
	public void setCrashed(boolean isCrashed) {
		this.isCrashed = isCrashed;
	}
	
	
	
	
}