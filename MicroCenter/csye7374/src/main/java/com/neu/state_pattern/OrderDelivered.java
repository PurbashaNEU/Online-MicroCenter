package com.neu.state_pattern;

import com.neu.observer_pattern.Order;
public class OrderDelivered implements OrderStateAPI {

	private Order order;
	
	  // Constructor to associate the order with this state	
	public OrderDelivered(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Oops! Looks like the order has already been delivered");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Oops! Looks like the order has already been delivered");
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("Oops! Looks like the order has already been delivered");
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("Oops! Looks like the order has already been delivered");
	}
}
