package com.neu.state_pattern;

import com.neu.observer_pattern.Order;

public class AwaitingConfirmationState implements OrderStateAPI{
	
	private Order order;
	
	public AwaitingConfirmationState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("ERROR!! Order already in awaiting!");
	}

	@Override
	public void state_OrderConfirmed() {
		order.setState(order.getOrderConfirmed());
		System.out.println("SUCCESS!! Order is now confirmed! ");
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("ERROR!! Order remains unconfirmed!");
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("ERROR!!Order remains unconfirmed/undelivered!");
	}

}
