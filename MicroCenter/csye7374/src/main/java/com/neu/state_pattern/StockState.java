package com.neu.state_pattern;

import com.neu.Store;

public class StockState implements StoreStateAPI  {
	
	private static Store store;
	
	public StockState(Store store) {
		super();
		StockState.store =store;
	}
	
	@Override
	public void state_Open() {
		store.setState(store.getOpenState());
		System.out.println(" Stock to Open State transition!");
	}

	@Override
	public void state_Close() {
		store.setState(store.getCloseState());
		System.out.println("Stock to Close State transition!");
	}

	@Override
	public void state_Stock() {
		System.out.println("Oops! Looks like it's already in Stock State");
	}
}
