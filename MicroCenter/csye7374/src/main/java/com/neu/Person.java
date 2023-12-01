package com.neu;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	// Constructor to initialize the attributes of the Person object
	public Person(int id, int age, String firstName, String lastName) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	// Default constructor with no parameters
	public Person() {}
	public int getId() {
		return id;
	}
	
	//getter and setter methods 
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Override the default toString() method to provide a custom string representation
	@Override
	public String toString() {
		return "[id= "+ id+", firstName= " + firstName + ", lastName= " + lastName + ", age= " + age + "]";
	}
}
