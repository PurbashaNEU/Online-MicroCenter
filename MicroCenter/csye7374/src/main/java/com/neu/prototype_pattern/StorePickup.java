package com.neu.prototype_pattern;


public class StorePickup extends DeliveryType {
	/**
	 * Constructor for creating a StorePickup instance.
	 *
	 * @param deliveryId   The unique identifier for the delivery.
	 * @param deliveryType The type of delivery.
	 * @param deliveryCost The cost associated with the delivery.
	 */

	public StorePickup(int deliveryId, String deliveryType, double deliveryCost) {
		super(deliveryId, deliveryType, deliveryCost);
	}
	
	/**
     * Provides a description of the delivery type.
     *
     * @return A description indicating store pickup for the order.
     */

	@Override
	String delivertDescription() {
		return "We have scheduled a store pickup for your order";
	}

}
