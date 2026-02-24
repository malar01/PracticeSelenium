package herokuapp.com.Pattern;

public class Pyramid {

	public static void main(String[] args) {
		//     *
		 //   * *
		 //  * * *
		 // * * * *
		 //* * * * *

		int n=5;
		for(int i=1;i<=n;i++) {
			//spaces
			for(int j=1;j<=n-i;j++) { //n-i=4
				System.out.print(" ");//---
			}
			//stars
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
 

  

}
