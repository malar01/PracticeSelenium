package herokuapp.com.Arrays;

import java.util.Scanner;

public class ArrayReverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Elements");
		int num=sc.nextInt();
		int arr[]=new int[num];
		System.out.println("Enter the Elements");
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Print array in reverse order");
		for(int i=num-1;i>=0;i--) {   //60,45,12,30,13
			System.out.println(arr[i]);
		}
		sc.close();
		
	}

}
