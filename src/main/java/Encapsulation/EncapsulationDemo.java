package Encapsulation;

import java.util.ArrayList;
import java.util.Scanner;

public class EncapsulationDemo {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<Student> students=new ArrayList<>(); //We can dynamically store multiple Student objects.
		System.out.print("Enter how many students wants to enter");
		int stud=sc.nextInt();
		sc.nextLine();//consume new line
		
		for(int i=0;i<stud;i++) {
			System.out.println("\nEnter details of Student"+(i+1));
			Student student=new Student();
			
			System.out.println("\nEnter Name");
			student.setName(sc.nextLine());
			
			System.out.println("\nEnter Age");
			student.setAge(sc.nextInt());
			
			System.out.println("\nEnter Grade (A-F)");
			student.setGrade(sc.next().charAt(0));
			sc.nextLine(); // consume newline
			
			students.add(student);//Each created and populated Student object is stored in the list.
		}
		//display all students
		System.out.println("\n All students entered");
		for(Student s:students) { //Iterates through the list and prints info for each student.
			s.displayInfo();
		}
		sc.close();
		
		/*
		student.setName("Roshan");
		student.set
		
		Age(20);
		System.out.println("Name is : " + student.getName());
		System.out.println("Name is : " + student.getAge());
	}*/
	}
}
