package com.neu.state_pattern;

import com.neu.observer_pattern.Order;

public class OrderDispatched implements OrderStateAPI {

	private Order order;
	
	public OrderDispatched(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Oops!Looks like your order has already been confirmed");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Oops!Looks like your order has already been confirmed");
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("Oops!Looks like your order has already been confirmed");
	}

	@Override
	public void state_OrderDelivered() {
		order.setState(order.getOrderDelivered());
		System.out.println("Oops!Looks like your order has already been confirmed");
	}

}
