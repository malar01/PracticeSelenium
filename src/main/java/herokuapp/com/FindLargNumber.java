package herokuapp.com;

import java.util.Scanner;

public class FindLargNumber {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number");
	int a=sc.nextInt();
	int b=sc.nextInt();
	if(a>b) {
		System.out.println("The number is Greater");
	} else {
		System.out.println("The number is Smaller");
	}
sc.close();
	}

}
