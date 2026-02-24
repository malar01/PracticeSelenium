package herokuapp.com.JAVA.PGM;

public class ReverseEachWord {

	public static void main(String[] args) {
		String str="Hello Java Print";
		String[] words=str.split(" ");
		for(String word:words) {
			StringBuilder sb=new StringBuilder(word);
			String reverse=sb.reverse().toString();
			System.out.print(reverse+" ");
		}
		
	}

}

