package Static;

public class StaticDemo {
//Static members belong to the class, not instances.
	public static void main(String[] args) {
		Counter c1=new Counter();
		Counter c2=new Counter();
		Counter c3=new Counter();
		Counter.displayTotal();
	}

}
