package herokuapp.com.string;

import java.util.Scanner;

public class PalindromeString {

	public static void main(String[] args) {
		// Malayalam
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.nextLine();
		
		/* String reverse=new StringBuilder(str).reverse().toString();
		
		if(str.equalsIgnoreCase(reverse)) {
			System.out.println("The string is Palindrome");
		} else {
			System.out.println("The string is not a Palindrome");
		}
		sc.close();*/
		
		String reverse="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse=reverse+str.charAt(i);
		}
		if(str.equalsIgnoreCase(reverse)) {
			System.out.println("The string is Palindrome");
		} else {
			System.out.println("The string is not a Palindrome");
		}
		sc.close();
		}
	}

