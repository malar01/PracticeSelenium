package herokuapp.com;

import java.util.Scanner;

public class Swap2Num {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value for a");
		int a=sc.nextInt();
		System.out.println("Enter the value for b");
		int b=sc.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("The value of a is :"+a+" and value of b is :" + b);
		sc.close();

	}

}
