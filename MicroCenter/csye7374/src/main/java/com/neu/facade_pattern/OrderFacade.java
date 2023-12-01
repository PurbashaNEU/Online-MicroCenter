package com.neu.facade_pattern;

import com.neu.ProductAPI;
import com.neu.decorator_pattern.ProductDecorator;
import com.neu.decorator_pattern.GiftDecorator;
import com.neu.facade_pattern.OrderFacade;
import com.neu.observer_pattern.Order;

public class OrderFacade {
	private ProductAPI product;

	public OrderFacade() {
		super();
	}
	
	public OrderFacade(ProductAPI product) {
		super();
		this.product = product;
	}
	
	
	// Method to create an order with a decorated product
	public Order order() {
		Order order = new Order();
		ProductDecorator giftdecorProduct = new GiftDecorator(product);// Decorate the product
		System.out.println(giftdecorProduct);
		order.addProduct(giftdecorProduct);// Add the decorated product to the order
		return order;
	}
	
	/**
     * Sets the product for the order facade.
     *
     * @param product The product to be used in the order.
     * @return The updated OrderFacade instance.
     */	
	public OrderFacade setProduct(ProductAPI product) {
		this.product = product;
		return this;
	}	
}