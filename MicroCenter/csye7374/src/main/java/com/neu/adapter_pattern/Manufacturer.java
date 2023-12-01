package com.neu.adapter_pattern;

import com.neu.factory_pattern.EmployeeFactory;

public class Manufacturer implements Cloneable {

    private String ManufacturerName;
    private int age;
    private int noOfProductsManufacturerd;
    private static Manufacturer instance;

    public Manufacturer() {
        super();
    }

    //Singleton, make sure only one instance of 'Manufacturer' is created.
    public static synchronized Manufacturer getInstance() {
        if (instance == null) {
            instance = new Manufacturer();
        }
        return instance;
    }

    //Private constructor with parameters. So only other class can create a new 'Manufacturer'
    private Manufacturer(String ManufacturerName, int age, int noOfProductsManufacturerd) {
        super();
        this.ManufacturerName = ManufacturerName;
        this.age = age;
        this.noOfProductsManufacturerd = noOfProductsManufacturerd;
    }

    //Getter and setter: company name
    public String getManufacturerName() {
        return ManufacturerName;
    }
    public Manufacturer setManufacturerName(String ManufacturerName) {
        this.ManufacturerName = ManufacturerName;
        return this;
    }

    //Getter and setter: age of the company
    public int getAge() {
        return age;
    }
    public Manufacturer setAge(int age) {
        this.age = age;
        return this;
    }

    //Getter and setter: number of products that the company has made.
    public int getNoOfProductsManufacturerd() {
        return noOfProductsManufacturerd;
    }
    public Manufacturer setNoOfProductsManufacturerd(int noOfProductsManufacturerd) {
        this.noOfProductsManufacturerd = noOfProductsManufacturerd;
        return this;
    }

    @Override
    public String toString() {
        return "Manufacturer [ManufacturerName=" + ManufacturerName + ", age=" + age + ", noOfProductsManufacturerd=" + noOfProductsManufacturerd + "]";
    }

    @Override
    public Manufacturer clone() {
        //Declare a clone of M to NULL
        Manufacturer clone = null;

        try {
            clone = (Manufacturer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
