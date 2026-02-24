package herokuapp.com.JAVA.PGM;

public class FindLargeArrayEle {

	public static void main(String[] args) {
		int[] arr= {10,45,23,4,89,4};
		int large=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>=large) {
				large=arr[i];
				System.out.println(large);
			}
		}
		System.out.println("Largest number is :"+large);
	}
}
