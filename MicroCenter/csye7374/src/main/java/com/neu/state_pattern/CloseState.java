package com.neu.state_pattern;

import com.neu.Store;

public class CloseState implements StoreStateAPI {
	
	private static Store store;
	
	public CloseState(Store store) {
		super();
		CloseState.store = store;
	}
	
	@Override
	public void state_Open() {
		store.setState(store.getOpenState());
		System.out.println("Close to Open State transition");
		
	}

	@Override
	public void state_Close() {
		System.out.println("Oops!Looks like it's already in the Closed state.");
	}

	@Override
	public void state_Stock() {
		store.setState(store.getStockState());
		System.out.println("Close to Stock State transition");
		
	}

}
