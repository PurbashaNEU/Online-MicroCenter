package com.neu.builder_pattern;

import com.neu.Product;
import com.neu.ProductCategory;
import com.neu.ConvertUtility;
import com.neu.factory_pattern.ProductFactory;

public class ProductBuilder implements BuilderAPI<Product>{
	
	private String productName;
	private int productId;
	private ProductCategory productCategory;
	private double productPrice;	
	private String productManufacturer;
	
	 // Getter and setter
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}	
	
	public String getProductManufacturer() {
		return productManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
		
	// Constructor for initializing
	public ProductBuilder(int productId, String productName, double productPrice, ProductCategory productCategory,String productManufacturer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productManufacturer=productManufacturer;
	}
	
	public ProductBuilder(String s) {
		String[] tokens=s.split(",");
		this.productId=ConvertUtility.StringToInt(tokens[0]);
		this.productName=tokens[1];
		this.productPrice=ConvertUtility.StringToDouble(tokens[2]);	
		this.productCategory=ProductCategory.getProductCategory(tokens[3]);
		this.productManufacturer=tokens[4];
	}


	@Override
	public Product build() {
		// Delegate the creation of a Product object to the ProductFactory
		return ProductFactory.getInstance().getObject(this);
	}
}
