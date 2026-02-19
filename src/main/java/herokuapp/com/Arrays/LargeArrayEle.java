package herokuapp.com.Arrays;

import java.util.Scanner;

public class LargeArrayEle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int num=sc.nextInt();
		int arr[]=new int[num];
		System.out.println("Enter the elements");
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		int largest=arr[0]; //assume first element is largest
		for(int i=1;i<num;i++) {
			if(arr[i]>largest) {
				largest=arr[i];
				System.out.println(largest);
			}
		}
		System.out.println("The largest element is : "+ largest);
		sc.close();
	}

}
