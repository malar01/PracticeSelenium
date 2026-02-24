package herokuapp.com.JAVA.PGM;

public class ReverseArrayString {

	public static void main(String[] args) {
		String[] str= {"Java","Selenium","Test"};//str[0]=Java, str[1]=Selenium, str[2]=Test
		for(int i=0;i<=str.length-1;i++) {
			String words=str[i];
			StringBuilder sb=new StringBuilder(words);
			String reverse=sb.reverse().toString();
			System.out.print(reverse+" ");
		}

	}

}
