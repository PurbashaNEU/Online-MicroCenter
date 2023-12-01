package com.neu.builder_pattern;

import com.neu.ConvertUtility;
import com.neu.Employee;
import com.neu.factory_pattern.EmployeeFactory;

public class EmployeeBuilder implements BuilderAPI<Employee>{

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double wage;
    
 // Getter and setter methods
    public int getId() {
        return id;
    }

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

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public EmployeeBuilder(int id,int age,String firstName, String lastName, double wage) {
        super();
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wage=wage;
    }

    public EmployeeBuilder(String s) {
        String[] tokens=s.split(",");
     // Parsing input string to initialize fields
        this.id=ConvertUtility.StringToInt(tokens[0]);
        this.firstName=tokens[1];
        this.lastName=tokens[2];
        this.age=ConvertUtility.StringToInt(tokens[3]);
        this.wage=ConvertUtility.StringToDouble(tokens[4]);
    }

    @Override
    public Employee build() {
    	 // Building an Employee object using a factory
        return EmployeeFactory.getInstance().getObject(this);
    }
}

