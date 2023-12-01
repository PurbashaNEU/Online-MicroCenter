package com.neu;

import com.neu.builder_pattern.EmployeeBuilder;

//Employee class extends the Person class, inheriting its attributes and methods
public class Employee extends Person {
	private double wage; // Additional attribute specific to Employee
	
	// Constructor for creating an Employee instance using an EmployeeBuilder
	public Employee(EmployeeBuilder builder) {
		// Call the superclass constructor (Person's constructor) to initialize inherited attributes
		super(builder.getId(),builder.getAge(),builder.getFirstName(), builder.getLastName());
		this.wage=builder.getWage();
	}
	
	// Getter method for getting the wage of the employee
	public double getWage() {
		return wage;
	}
	
	// Setter method for setting the wage of the employee
	public void setWage(double wage) {
		this.wage = wage;
	}
	
	// Override the toString() method to provide a customized string representation of Employee
	@Override
	public String toString() {
		// Call the parent class's toString() method using super.toString() and add wage
		return "\nEmployee ["+ super.toString() +", wage= "+ wage +"]";
	}
}
