package herokuapp.com.JAVA.PGM;

public class PalindromeString {

	public static void main(String[] args) {
		String str="Malayalam";
		String reversed=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(reversed)){
			System.out.println("The String "+str+" is a Palindrome");
		} else {
			System.out.println("The String "+str+" is not a Palindrome");
		}

	}

}
