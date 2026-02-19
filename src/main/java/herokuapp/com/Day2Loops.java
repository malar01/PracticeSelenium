package herokuapp.com;

public class Day2Loops {

	public static void main(String[] args) {
		String[] usernames={"user1","user2456","user6783"};
		for(String username:usernames) {
			if(username.length()<8) {
				System.out.println("Invalid Username");	
			} else {
				System.out.println("Valid Username");
			}
		}
		
//using switch for validation/status
		int loginStatus=0;
		switch(loginStatus) {
		case 0:System.out.println("Login Successfull");
		break;
		case 1:System.out.println("Login Failed");
		break;
		case 2:System.out.println("Account Locked");
		break;
		default:System.out.println("Unknown Status");
		}
	}

}
