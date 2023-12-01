package com.neu.decorator_pattern;

import com.neu.*;

public abstract class ProductDecorator implements ProductAPI {
	
	// The decoratedProduct holds the reference to the product being decorated
	protected ProductAPI decoratedProduct;
	
	// Constructor to create a ProductDecorator with a decoratedProduct
	public ProductDecorator(ProductAPI decoratedProduct){
	      this.decoratedProduct = decoratedProduct;
	}
	 
	// Overrides the method to get the product description from the decorated product
	@Override
	public String productDescription() {
		// TODO Auto-generated method stub
		return decoratedProduct.productDescription();
	}
	
	// Overrides the method to get the number of products manufactured from the decorated product
	@Override
	public int noOfProductsManufactured() {
		// TODO Auto-generated method stub
		return decoratedProduct.noOfProductsManufactured();
	}
	
	public ProductAPI getDecoratedProduct() {
		return this.decoratedProduct;
	}

	@Override
	public String toString() {
		return "ProductDecorator [productDescription()=" + productDescription() + ", noOfProductsManufactured()="
				+ noOfProductsManufactured() + ", getDecoratedProduct()=" + getDecoratedProduct() + "]";
	}
}
