package com.neu.adapter_pattern;

import com.neu.ProductAPI;

public class ManufacturerObjectAdapter implements ProductAPI {

    private Manufacturer Manufacturer;
    private ProductAPI product;
    //Constructor
    public ManufacturerObjectAdapter(ProductAPI product, Manufacturer adaptee) {
        this.product = product;
        this.Manufacturer = adaptee;
    }
    //Return product description
    @Override
    public String productDescription() {return product.productDescription();}

    //Return the amount of products that are made by the company
    @Override
    public int noOfProductsManufactured() {
        return Manufacturer.getNoOfProductsManufacturerd();
    }

    //Return the company object
    @Override
    public Object getProductManufacturer() {
        return Manufacturer.class.cast(Manufacturer);
    }

    //To show string in terminal
    @Override
    public String toString() {
        return "[" + Manufacturer + "], [product=" + product + "]";
    }

    //Get product price
    @Override
    public double getProductPrice() {
        return product.getProductPrice();
    }
}
