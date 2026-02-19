package Inheritance;

public class Dog extends Animal {
	void bark() {
		System.out.println("Dog barks");
	}
	@Override
	void eat() {
		System.out.println("Dog eats dog food");
	}
}
