package herokuapp.com;

import java.util.Scanner;

public class CountNDigits {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	String str=Integer.toString(num) ;
	System.out.println("Number of Digits in a number "+num+" is "+str.length());
	sc.close();
	}

}
