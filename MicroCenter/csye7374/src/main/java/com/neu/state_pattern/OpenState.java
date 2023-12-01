package com.neu.state_pattern;

import com.neu.Store;

public class OpenState implements StoreStateAPI {
	
	private static Store store;
	
	public OpenState(Store store) {
		super();
		OpenState.store =store;
	}
	
	/**
     * Implementation of the state_Open() method from StoreStateAPI.
     * Displays a message indicating that the store is already in the Open state.
     */	
	@Override
	public void state_Open() {
		System.out.println("Oops!Looks like it's already in the Open state.");
		
	}
	
	/**
     * Implementation of the state_Close() method from StoreStateAPI.
     * Transitions the store's state to the Close state and displays a message.
     */

	@Override
	public void state_Close() {
		store.setState(store.getCloseState());
		System.out.println("Presently in Closed State!!");
	}
	
	/**
     * Implementation of the state_Stock() method from StoreStateAPI.
     * Transitions the store's state to the Stock state and displays a message.
     */

	@Override
	public void state_Stock() {
		store.setState(store.getStockState());
		System.out.println("Presently in Stock State !!");
		
	}

}
