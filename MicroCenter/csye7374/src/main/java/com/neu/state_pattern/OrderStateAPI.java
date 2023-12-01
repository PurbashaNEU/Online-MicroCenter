package com.neu.state_pattern;

public interface OrderStateAPI {
	void state_Awaiting_OrderConfirmation();
	void state_OrderConfirmed();
	void state_OrderDispatched();
	void state_OrderDelivered();
}
