package com.restaurantapp.domainmodel;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Observer push mode
 */

public class OrderManager extends Observable {
	
	private ArrayList<Order> orders; 
	private static OrderManager instance=null;
	
	private OrderManager() {
		orders = new ArrayList<Order> ();
	}
	
	public static OrderManager getInstance() {
		if(instance==null) {
			instance= new OrderManager();
		}
		return instance;
	}
	
    public void addOrder(Order order) {
    	orders.add(order);
    	setChanged();
    	notifyObservers(order);
    }
   
}
