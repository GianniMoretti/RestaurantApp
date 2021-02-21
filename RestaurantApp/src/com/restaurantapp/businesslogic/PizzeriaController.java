package com.restaurantapp.businesslogic;
import java.util.ArrayList;
import java.util.Observable;

import com.restaurantapp.domainmodel.KindOfDish;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;

public class PizzeriaController extends OrderPageController{

	public PizzeriaController(Observable obs, String id) {
		this.id=id;
		obs.addObserver(this);
		orderRecords = new ArrayList<OrderRecord>();
	}
	
	@Override
	public void getOrder(Order order) {
		for(OrderRecord ord : order.getRecords()) {
			if(ord.getDish().getKindOfDish() == KindOfDish.PIZZA) {
				orderRecords.add(ord);
			}
		}
	}
}