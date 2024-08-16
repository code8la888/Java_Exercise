package tw.brad.apis;

public class Scooter extends Bike {
	private int gear;
	private String color;
	
	public Scooter() {
		System.out.println("Scooter()");
		color = "Yellow";
	}
	
	public Scooter(String color) {
		// super();
		System.out.println("Scooter(String)");
		this.color = color;
	}
	
	public void changeGear(int gear) {
		if (gear >=0 && gear <=4) {
			this.gear = gear;
		}
	}
	
	public void upSpeed() {
		super.upSpeed();
		if (gear > 0) {
			speed = speed < 1? 1 :speed * 1.8 * gear;
		}
	}
	
	public String getColor() {
		return color;
	}
	

}
