package com.restaurantapp.businesslogic;
import java.util.Observer;

import com.restaurantapp.domainmodel.KindOfDish;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;

import java.util.ArrayList;
import java.util.Observable;

// metodo detach al logout o alla chiusura dell'applicativo

public abstract class OrderPageController implements Observer{

	protected ArrayList<OrderRecord> orderRecords;
	
	@Override
	public void update(Observable ordermanager, Object order) {
		Order newOrder = (Order)order;
		getOrder(newOrder);
	}
	
	public abstract void getOrder(Order order);
	
	public void detach(Observable obs) {
		obs.deleteObserver(this);
	}
	
	public ArrayList<OrderRecord> getRecords() {
		return this.orderRecords;
	}
}

