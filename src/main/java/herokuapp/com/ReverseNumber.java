package herokuapp.com;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int number=sc.nextInt();
		int reverse=0;
		/*	number = 123
			digit = 3
			reverse = 0*10 + 3 = 3
			number = 123 / 10 = 12 */
		while(number!=0) {
			int digit=number%10;
			reverse=reverse*10+digit;
			number=number/10;
			//System.out.println("Reversed Number is "+reverse);
			}
		System.out.println("Reversed Number is "+reverse);
sc.close();
	}

}
