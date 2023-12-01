package com.neu.factory_pattern;

import com.neu.Product;
import com.neu.builder_pattern.ProductBuilder;
import com.neu.builder_pattern.BuilderAPI;

//Concrete implementation of 'AbstractFactory', creating 'Product'.
public class ProductFactory extends AbstractFactory<Product> {

    private static ProductFactory instance = new ProductFactory(); // Eager Singleton Factory Class

    private ProductFactory() {
        super();
    }

    public synchronized static ProductFactory getInstance() {
        return instance;
    }

    //Create a new 'Product' using the given builder.
    @Override
    public Product getObject(BuilderAPI<Product> builder) {
        // TODO Auto-generated method stub
        ProductBuilder productBuilder = (ProductBuilder) builder;
        return new Product(productBuilder);
    }
}
