package Static;

public class Counter {
	//Static members belong to the class, not instances.
	public static int count=0;
	
	public Counter() {
		count++;
	}
	public static void displayTotal() {
		System.out.println("Total object created is : "+count);
	}
}
