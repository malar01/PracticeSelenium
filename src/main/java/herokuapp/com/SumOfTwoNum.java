package herokuapp.com;

import java.util.Scanner;

public class SumOfTwoNum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value for a and b");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int sum=a+b;
		System.out.println("Sum of two numbers :"+sum);
		sc.close();
	}

}
