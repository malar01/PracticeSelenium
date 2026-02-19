package herokuapp.com;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		try (//PrimeNumber has two divisor ->number divisible by itself and 1
			//zero and 1 are not a prime number
	Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter a Number to check if it is a prime number");
		int number=sc.nextInt();
		if(number<2) {
			System.out.println("The number "+number+" is not a prime number");
			return;
		}
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				System.out.println("The number "+number+" is not a prime number");
				return;
			}
		}
		System.out.println("The number "+number+" is a prime number");
		sc.close();
	}
	}	
}
