package com.neu.decorator_pattern;

import com.neu.Product;
import com.neu.ProductAPI;

public class GiftDecorator extends ProductDecorator {

    public GiftDecorator(ProductAPI decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String productDescription() {
    	// Adding gift wrapping description to the existing product description
        return decoratedProduct.productDescription()+ "Gift wrapped with a Thank You note";
    }

    @Override
    public Object getProductManufacturer() {
    	// Delegating manufacturer retrieval
        return decoratedProduct.getProductManufacturer();
    }

    public double getProductPrice() {
        Product b = Product.class.cast(decoratedProduct);// Casting the decoratedProduct to Product type
        return b.getProductPrice()+10; // Added gift wrapping cost
    }

}
