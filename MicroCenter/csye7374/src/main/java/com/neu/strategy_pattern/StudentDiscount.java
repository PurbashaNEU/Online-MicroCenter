package com.neu.strategy_pattern;

import com.neu.Product;

public class StudentDiscount implements DiscountStrategyAPI {

	@Override
	public double discountPrice(Product product) {
		return product.getProductPrice() * 0.70;
	}

	@Override
	public String discountDescription() {
		return "Student's Discount of 30% used";
	}

}
