package herokuapp.com;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number : ");
		int num=sc.nextInt();
		
		for(int i=1;i<=10;i++) {
			int mul_val=num*i;
			System.out.println(i+"*"+num+"="+mul_val);
		}
		sc.close();
	}

}
