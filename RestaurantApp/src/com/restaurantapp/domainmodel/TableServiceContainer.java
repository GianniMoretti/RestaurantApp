package com.restaurantapp.domainmodel;

import java.util.ArrayList;

public class TableServiceContainer {
	private ArrayList<TableService> tableServices;
	private static TableServiceContainer instance= null;

	private TableServiceContainer() {
		tableServices = new ArrayList<TableService>();
	}
	
	public static TableServiceContainer getInstance(){
		if(instance==null) {
			instance= new TableServiceContainer();
		}
		return instance;
	}

	public void addTableService(TableService tableService){
		tableServices.add(tableService);
	}

	public TableService getTableService(int idTable) throws IndexOutOfBoundsException {
		for (TableService t : tableServices) {
			if (t.getComposedTable().getTableID() == idTable)
				return t;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean placeOrderToTableService(Order order, int id) {
		try {
			TableService ts = getTableService(id);
			ts.addOrder(order);
			if(!order.isWriteOff())
				OrderManager.getInstance().addOrder(ts.getOrders().get(ts.getOrders().size()-1));
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}

	public boolean removeTableService(TableService ts) {
		return tableServices.remove(ts);
	}
}
