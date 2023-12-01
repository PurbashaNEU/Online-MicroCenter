package com.neu.prototype_pattern;

public abstract class DeliveryType implements Cloneable {
	// Attributes to store delivery information.
	private int deliveryId;
	private String deliveryType;
	private double deliveryCost;
	
	// Constructor to initialize delivery attributes.
	public DeliveryType(int deliveryId, String deliveryType, double deliveryCost) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryType = deliveryType;
		this.deliveryCost = deliveryCost;
	}
	
	// Abstract method to provide a description of the delivery type.
	abstract String delivertDescription();
	
	// Getter and setter 
	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object clone = null;
		try {
			clone = super.clone();   // Call the clone method of the superclass.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
}
