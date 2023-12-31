package com.neu.observer_pattern;

import com.neu.ProductAPI;
import com.neu.facade_pattern.DeliveryType;
import com.neu.state_pattern.*;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderStateAPI{
	 
	private int id;
	private double orderCost=0;
	private int count=0;
	private double discount=0;
	private double shippingCost;
	private List<ProductAPI> productList = new ArrayList<>();
	private DeliveryType deliveryType;
	private static int counter=0;
	private List<OrderObserver> observers = new ArrayList<>();
	{
		observers.add(new PriceObserver());
		observers.add(new QuantityObserver());
	}
	
	// States
	private OrderStateAPI awaitingConfirmationState = new AwaitingConfirmationState(this);
	private OrderStateAPI orderConfirmed = new OrderConfirmed(this);
	private OrderStateAPI orderDispatched = new OrderDispatched(this);
	private OrderStateAPI orderDelivered = new OrderDelivered(this);
	private OrderStateAPI state;
	
	
	// Default constructor sets initial values
	public Order() {
		super();
		this.id = ++counter;
		this.deliveryType = DeliveryType.IN_STORE_PICKUP;
		this.state = getAwaitingConfirmationState();
	}

	 // Constructor with specified values
	public Order(double orderCost, int count, double shippingCost, DeliveryType deliveryType) {
		super();
		this.id = ++counter;
		this.orderCost = orderCost;
		this.count = count;		
		this.deliveryType = deliveryType;
		
		if(deliveryType==DeliveryType.IN_STORE_PICKUP) {
			this.shippingCost = 0;
		}else {
			this.shippingCost = shippingCost;
		}
		this.state = getAwaitingConfirmationState();
	}
	
	// Method to add a product to the order
	public void addProduct(ProductAPI product) {
		productList.add(product);
		orderCost+=product.getProductPrice();
		count++;
		observers.forEach(o->o.updated(this));
	}
	
	 // Method to remove a product from the order
	public boolean removeProduct(ProductAPI product) {
		if(productList.remove(product)) {
			return true;
		}
		return false;
	}

	public OrderStateAPI getAwaitingConfirmationState() {
		return awaitingConfirmationState;
	}


	public void setAwaitingConfirmationState(OrderStateAPI awaitingConfirmationState) {
		awaitingConfirmationState = awaitingConfirmationState;
	}


	public OrderStateAPI getOrderConfirmed() {
		return orderConfirmed;
	}


	public void setOrderConfirmed(OrderStateAPI orderConfirmed) {
		orderConfirmed = orderConfirmed;
	}


	public OrderStateAPI getOrderDelivered() {
		return orderDelivered;
	}


	public void setOrderDelivered(OrderStateAPI orderDelivered) {
		orderDelivered = orderDelivered;
	}


	public OrderStateAPI getOrderDispatched() {
		return orderDispatched;
	}


	public void setOrderDispatched(OrderStateAPI orderDispatched) {
		orderDispatched = orderDispatched;
	}


	public OrderStateAPI getState() {
		return state;
	}


	public void setState(OrderStateAPI state) {
		this.state = state;
	}


	public List<ProductAPI> getProductList() {
		return productList;
	}


	public void setProductList(List<ProductAPI> productList) {
		this.productList = productList;
	}
	
	 // Method to get a string representation of the product list
	public String getProductListString() {
		StringBuilder sb = new StringBuilder();
		for(ProductAPI b : productList) {
			sb.append(b);
			sb.append("; ");
		}
		return sb.toString();
	}


	public DeliveryType getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}


	public static int getCounter() {
		return counter;
	}


	public static void setCounter(int counter) {
		Order.counter = counter;
	}


	public List<OrderObserver> getObservers() {
		return observers;
	}


	public void setObservers(List<OrderObserver> observers) {
		this.observers = observers;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public double getOrderCost() {
		return orderCost;
	}
	
	// Attach an observer to the order
	public void attach(OrderObserver observer) {
		observers.add(observer);
	}
	
	// Detach an observer from the order
	public void detach(OrderObserver observer) {
		observers.remove(observer);
	}
	
	public Order(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	// Method to calculate the total cost of the order
	public double getTotal() {
		return orderCost - discount + shippingCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	
	public int getCount() {
		return productList.size();
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", itemCost=" + orderCost + ", count=" + count + ", discount=" + discount
				+ ", shippingCost=" + shippingCost+ "]";
	}

	@Override
	public void state_Awaiting_OrderConfirmation() {
		this.state.state_Awaiting_OrderConfirmation();		
	}

	@Override
	public void state_OrderConfirmed() {
		this.state.state_OrderConfirmed();		
	}

	@Override
	public void state_OrderDispatched() {
		this.state.state_OrderDispatched();
	}

	@Override
	public void state_OrderDelivered() {
		this.state.state_OrderDelivered();
	}	
}
