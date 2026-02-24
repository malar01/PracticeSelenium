package herokuapp.com.JAVA.PGM;

public class ReverseSetence {

	public static void main(String[] args) {
		String str="Java Selenium Test";
		StringBuilder sb=new StringBuilder(str);
		String reverse=sb.reverse().toString();
		System.out.println(reverse);

	}

}
