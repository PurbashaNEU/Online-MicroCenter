package com.neu;

public interface ProductAPI {
	String productDescription(); //Returns a description of the product
	Object getProductManufacturer(); //Returns the manufacturer of the product
	int noOfProductsManufactured(); //Returns the total number of products manufactured
	double getProductPrice(); //Returns the price of the product
}
