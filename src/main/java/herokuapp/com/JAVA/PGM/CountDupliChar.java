package herokuapp.com.JAVA.PGM;

public class CountDupliChar {

	public static void main(String[] args) {
		String str="Programming";
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='m') {
				count++;
			}
		}
		System.out.println("Count of m :"+ count);
	}
}
