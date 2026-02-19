package Constructor;

public class ConstructorDemo {

	public static void main(String[] args) {
		Car c1=new Car("Maruti 800",1950);
		Car c2=new Car("Tesla Model 3",2023,"Automatic");
		c1.displayInfo();
		c2.displayInfo();
	}

}
