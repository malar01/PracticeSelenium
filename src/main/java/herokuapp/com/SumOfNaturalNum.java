package herokuapp.com;

import java.util.Scanner;

public class SumOfNaturalNum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to print the sum of N natural numbers");
		int n=sc.nextInt();
		int sum=0;
		//loop from 1 to N
		for(int i=1;i<=n;i++) {
			sum=sum+i;
		}
		System.out.println("Sum of N Natural numbers is \n"+sum);
		sc.close();
	}
}
