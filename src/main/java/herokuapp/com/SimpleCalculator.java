package herokuapp.com;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first value : ");
		double num1=sc.nextDouble();
		System.out.println("Enter the second value : ");
		double num2=sc.nextDouble();
		System.out.println("Enter the opertors (+,-,*,/) : ");
		char operator=sc.next().charAt(0);
		double result;
		
		switch(operator) {
		case '+':
			result=num1+num2;
			System.out.println("Result : "+result);
			break;
		case '-':
			result=num1-num2;
			System.out.println("Result : "+result);
			break;
		case '*':
			result=num1*num2;
			System.out.println("Result : "+result);
			break;
		case '/':
			if(num2!=0) {
				result=num1/num2;
			System.out.println("Result : "+result);
			} else {
				System.out.println("Error: Division by zero is not allowed!");
			}
			break;
			default:
				System.out.println("Invalid Operator");
			
		}
		sc.close();
	}

}
