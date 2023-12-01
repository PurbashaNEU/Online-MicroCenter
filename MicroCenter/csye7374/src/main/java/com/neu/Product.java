package com.neu;

import com.neu.builder_pattern.ProductBuilder;
import com.neu.strategy_pattern.DiscountStrategy;

public class Product implements ProductAPI{
	
	// Attributes of the Product class
	public int productId;
	public String productName;
	public double productPrice;
	public ProductCategory productCategory;
	public Object productManufacturer;
	
	// Constructor that uses a builder to create a Product instance
	public Product(ProductBuilder builder) {
		super();
		this.productId = builder.getProductId();
		this.productName = builder.getProductName();
		this.productPrice = builder.getProductPrice();
		this.productCategory = builder.getProductCategory();
		this.productManufacturer=builder.getProductManufacturer();
	}
	
	 // Getter and Setter methods for attributes
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategory() {
		return String.class.cast(productCategory);
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Object getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(Object productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	 // Method to get the number of products manufactured
	@Override
	public int noOfProductsManufactured() {
		// Generates a random number between 0 and 100
		return (int) (Math.random() * 100);
	}
	
	// Method to generate a product description
	@Override
	public String productDescription() {
		return this.productName + ", of category "+this.productCategory;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productCategory="
				+ productCategory + ", productManufacturer=" + (String) productManufacturer + "]";
	}
	
	// Method to indicate that a product has been bought
	public String buyProduct() {
		return this.productName+ " has been bought";
	}
	
	// Method to indicate that a product has been rented
	public String rentProduct() {
		// Reduce the product price by 50% for renting
		this.productPrice = this.productPrice * 0.5;
		return this.productName + " has been rented";
	}
	
	 // Method to run a discount strategy
	public double runStrategy() {
        double value = 0;
        switch(Store.usingStrategy){
            case EmployeeDiscount:
                value = Store.getAlgorithmMap().get(DiscountStrategy.EmployeeDiscount).discountPrice(this);
                break;
            case StudentDiscount:
                value = Store.getAlgorithmMap().get(DiscountStrategy.StudentDiscount).discountPrice(this);
                break;
            default:
                value = productPrice;
                break;
        }
        return value;
    }

}
