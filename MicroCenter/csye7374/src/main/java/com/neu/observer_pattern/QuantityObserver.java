package com.neu.observer_pattern;

import com.neu.facade_pattern.DeliveryType;
/**
 * This class implements the OrderObserver interface and calculates the shipping cost for an order based on the quantity of items
 * and the delivery type chosen.
 */
public class QuantityObserver implements OrderObserver {
	/**
     * This method is called when an order is updated. It calculates and sets the shipping cost for the order based on the delivery type and quantity.
     *
     * @param order The order that has been updated.
     */

	public void updated(Order order) {
		 // Check if the delivery type is HOME_DELIVERY
		if(order.getDeliveryType()==DeliveryType.HOME_DELIVERY) {
			int count=order.getCount(); // Get the quantity of items in the order
			
			// Calculate shipping cost based on quantity
			if(count<=5) {
				order.setShippingCost(25);// Shipping cost is $25 for orders with 5 or fewer items
			}else  {
				order.setShippingCost(25 + (count-5)*1.5);// Initial cost + additional charge
			}
		}
	}
}
