package com.neu.strategy_pattern;

import com.neu.Product;

public class FacultyDiscount implements DiscountStrategyAPI {
	
	@Override
	public double discountPrice(Product product) {
		return product.getProductPrice() * 0.85; // 15% discount
	}

	@Override
	public String discountDescription() {
		return "Faculty's Discount of 15% used";
	}

}
