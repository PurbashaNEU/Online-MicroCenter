package com.neu.factory_pattern;

import com.neu.Employee;
import com.neu.builder_pattern.*;

//Concrete implementation of 'AbstractFactory', creating 'Employee'.
public class EmployeeFactory extends AbstractFactory<Employee> {

    private static EmployeeFactory instance;  // Lazy Singleton Factory Class, make sure only one instance of 'EmployeeFactory'.

    private  EmployeeFactory() {
        super();
        instance=null;
    }

    public static synchronized EmployeeFactory getInstance() {
        if (instance == null) {
            instance = new EmployeeFactory();
        }
        return instance;
    }

    //Create a new 'Employee' using the given builder.
    @Override
    public Employee getObject(BuilderAPI<Employee> builder) {
        EmployeeBuilder employeeBuilder=(EmployeeBuilder)builder;
        return new Employee(employeeBuilder);
    }
}
