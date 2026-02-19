package Encapsulation;

public class Student {
//Encapsulation is about hiding data using private fields and exposing access via getters and setters.
	private String name;
	private int age;
	private char grade;
	
	//getter
	public String getName() {
		return name;
	}
	//setter
	public void setName(String name) {
		if(name!=null && !name.isEmpty()) {
		this.name=name;
		} else {
			System.out.println("Invalid name!");
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age>0 && age<150) {
			this.age=age;
		} else {
			System.out.println("Invalid age!");
		}
		
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		grade=Character.toUpperCase(grade);
		if("ABCD".indexOf(grade)!=-1)
			this.grade=grade;
		else {
			System.out.println("Invalid grade");
		}
	}
	public void displayInfo() {
		System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
	}
}
