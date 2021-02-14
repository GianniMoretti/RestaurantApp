package com.restaurantapp.domainmodel;

import java.util.ArrayList;

/*
 * lavorare in locale attraverso il waiterpage,
 * oppure spostare i metodi all'interno del mediator??
 * In caso, rimuovere il modifyTableService?
 * NB: controlla il send in addTableService
 */

public class TableServiceContainer {
	private ArrayList<TableService> tableServices;
	private OrderManager orderManager;
	private static TableServiceContainer instance= null;

	private TableServiceContainer() {
		this.orderManager = OrderManager.getInstance();
		tableServices = new ArrayList<TableService>();
	}
	
	// Singleton
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
				orderManager.addOrder(ts.getOrders().get(ts.getOrders().size()-1));
			return true;
				// FIXME: verificare che venga inviato l'ultimo ordine aggiunto al tableService
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}

	public boolean removeTableService(TableService ts) {
		return tableServices.remove(ts);
	}
}
