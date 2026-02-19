package herokuapp.com;

import java.util.Scanner;

public class Fibinocci {

	public static void main(String[] args) {
		//Print first N Fibonacci numbers.
		//0,1,1,2,3,5,8,13
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int number=sc.nextInt();
		int a=0;
		int b=1;
		
		for(int i=1;i<=number;i++) {
			System.out.println(a);
			int c=a+b;
			a=b;
			b=c;
		}
		sc.close();
	}

}
