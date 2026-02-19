package herokuapp.com;

import java.util.Scanner;

public class FactorialNumber {

	public static void main(String[] args) {
		//5!=1*2*3*4*5=120
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to find the factorial");
		int number=sc.nextInt();
		int factorial=1; //starts with 1
		
		for(int i=1;i<=number;i++) {
			factorial=factorial*i;
		}
		System.out.println("The factorial of the number "+number+" is "+ factorial);
		sc.close();
	}

}
