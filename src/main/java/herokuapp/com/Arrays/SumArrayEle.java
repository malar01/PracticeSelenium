package herokuapp.com.Arrays;

import java.util.Scanner;

public class SumArrayEle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n=sc.nextInt();
		int[] arr=new int[n];
		int sum=0;
		//input array elements
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//Calculate sum
		for(int i=0;i<n;i++) {
		sum=sum+arr[i];
	}
		System.out.println("Sum of array of elements is : "+ sum);
		sc.close();
	}
}
