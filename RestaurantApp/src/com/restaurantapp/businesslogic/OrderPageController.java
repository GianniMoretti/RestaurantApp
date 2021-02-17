package com.restaurantapp.businesslogic;
import java.util.Observer;

import com.restaurantapp.domainmodel.KindOfDish;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;

import java.util.ArrayList;
import java.util.Observable;

public abstract class OrderPageController implements Observer{

	//TODO: va bene protected?
	//Perchè lo abbiamo fatto? -> più facile aggiungere altri controller
	protected ArrayList<OrderRecord> orderRecords;
	
	@Override
	public void update(Observable ordermanager, Object order) {
		Order newOrder = (Order)order;
		getOrder(newOrder);
	}
	
	public abstract void getOrder(Order order);
	
	// chiamato al logout o alla chiusura dell'applicativo
	public void detach(Observable obs) {
		obs.deleteObserver(this);
	}
	
	public ArrayList<OrderRecord> getRecords() {
		return this.orderRecords;
	}
}

