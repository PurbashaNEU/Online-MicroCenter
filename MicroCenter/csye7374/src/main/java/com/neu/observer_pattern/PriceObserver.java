package com.neu.observer_pattern;

public class PriceObserver implements OrderObserver {
	// This method is called when an order is updated
	@Override
	public void updated(Order order) {
		double total = order.getOrderCost(); // Get the total cost of the order
		
		 // Check if the total cost is greater than or equal to 500.
		if(total>=500) {
			// Apply a 20% discount to the order
			order.setDiscount(20);
		}else if(total>=200) {
			 // If the total cost is not greater than 500 but is greater than or equal to 200,
            // apply a 10% discount to the order
			order.setDiscount(10);
		}
		 // If the total cost is less than 200, no discount is applied
	}
}
