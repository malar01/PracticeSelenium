package herokuapp.com;

public class Day1Basics {

	public static void main(String[] args) {
		//declare variables
		String username="user1";
		String password="pass1234";
		int loginAttempt=3;
		//print values
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		System.out.println("login Attempts Allowed:  "+loginAttempt);
		
		//Basic Validation
		if(username.length()<5) {
			System.out.println("Invalid username: must be at least 5 characters.");
		}
		else {
			System.out.println("Username length is valid");
			}
		if(password.length()<8) {
			System.out.println("Invalid password: must be at least 8 characters.");
			}
		else {
			System.out.println("Password length is valid");
			}
		}
	}
