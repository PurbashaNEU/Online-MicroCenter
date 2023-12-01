package com.neu.prototype_pattern;

public class HomeDelivery extends DeliveryType {

	public HomeDelivery(int deliveryId, String deliveryType, double deliveryCost) {
		super(deliveryId,deliveryType,deliveryCost);
	}

	@Override
	String delivertDescription() {
		return "Your order will be dispatched to your provided residential address.";
	}

}
