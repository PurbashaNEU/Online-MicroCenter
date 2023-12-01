package com.neu.strategy_pattern;

import com.neu.Product;

public class EmployeeDiscount implements DiscountStrategyAPI{

	@Override
	public double discountPrice(Product product) {
		return product.getProductPrice() * 0.80; // 20% Discount
	}

	@Override
	public String discountDescription() {
		return "Employee Discount Applied : 20% OFF";
	}

}
