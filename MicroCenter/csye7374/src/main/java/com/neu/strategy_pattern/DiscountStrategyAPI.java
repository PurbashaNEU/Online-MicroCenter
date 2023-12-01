package com.neu.strategy_pattern;

import com.neu.Product;

public interface DiscountStrategyAPI {
	double discountPrice(Product product);
	String discountDescription();
}
