package herokuapp.com.JAVA.PGM;

public class ReverseSentChangeWordOrder {

	public static void main(String[] args) {
		String str="Java Test Selenium";
		String[] words=str.split(" ");
		for(int i=words.length-1;i>=0;i--) {
			String reverse=words[i];
			System.out.print(reverse+" ");
		}
		
	}

}
