package com.neu.state_pattern;

import com.neu.observer_pattern.Order;

public class OrderConfirmed implements OrderStateAPI{

	private Order order;
	
	public OrderConfirmed(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Oops! Looks like the order has already been confirmed.");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Oops! Looks like the order is already in confirmed State");
	}

	@Override
	public void state_OrderDispatched() {
		order.setState(order.getOrderDispatched());
		System.out.println("SUCCESS!! The Order has been successfully dispatched");
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("Oops! Looks like the order isn't dispatched yet");
	}

}
