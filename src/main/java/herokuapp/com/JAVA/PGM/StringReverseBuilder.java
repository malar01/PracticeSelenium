package herokuapp.com.JAVA.PGM;

public class StringReverseBuilder {
	public static void main(String[] arg) {
	String str="Selenium";
	StringBuilder sb=new StringBuilder(str);
	String reverse=sb.reverse().toString();
	System.out.println(reverse);
	}
}
