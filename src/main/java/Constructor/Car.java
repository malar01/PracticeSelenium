package Constructor;

public class Car {

	private String model;
	private int year;
	private String type;
	
	public Car(String model,int year) {
		this.model=model;
		this.year=year;
	}
	public Car(String model,int year,String type) {
		this.model=model;
		this.year=year;
		this.type=type;
	}
	public void displayInfo() {
        System.out.print("Model: " + model + " | Year: " + year);
        if (type != null) {  // only print type if it’s not null
            System.out.print(" | Type: " + type);
        }
        System.out.println(); // move to next line
    }
}