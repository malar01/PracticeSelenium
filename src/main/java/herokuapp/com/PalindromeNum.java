package herokuapp.com;

import java.util.Scanner;

public class PalindromeNum {

	public static void main(String[] args) {
		//121
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int num=sc.nextInt();
		int original=num;
		int reverse=0;
		while(num>0) {
			int digit=num%10;
			reverse=reverse*10+digit;
			num=num/10;
		}
		if(original==reverse) {
		System.out.println("The number "+original+" is palindrome");
		} else { 
			System.out.println("The number "+original+" is not Palindrome");
		}
		sc.close();
	}

}
