package herokuapp.com;

import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value");
		int number=sc.nextInt();
		if(number%2==0) {
			System.out.println("The Number is Even");
		} else {
			System.out.println("The number is Odd");
		}
		sc.close();

	}

}
