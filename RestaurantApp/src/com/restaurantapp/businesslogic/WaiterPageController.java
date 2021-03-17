package com.restaurantapp.businesslogic;

import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;
import com.restaurantapp.domainmodel.TableState;
import com.restaurantapp.domainmodel.Waiter;

/**
 * Il login attraverso l'interfaccia prende l'ID e chiama il costruttore del WaiterPageController.
 */

public class WaiterPageController {
	private Waiter waiter;

	public WaiterPageController(String ID) {
		this.waiter = new Waiter(ID);
	}

	public boolean openTableService(int idTable, TableServiceRecord tsr) {
		try {
			ComposedTable ct = TableContainer.getInstance().getTable(idTable);
			if (ct.getTableState() == TableState.AVAILABLE) {
				ct.setTableState(TableState.UNAVAILABLE);
				TableService tableService = new TableService(this.waiter, ct, tsr);
				TableServiceContainer.getInstance().addTableService(tableService);
				return true;
			}
			return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean placeOrderToTableService(Order order, int id) {
		return TableServiceContainer.getInstance().placeOrderToTableService(order, id);
	}
	
	public String getWaiterID() {
		return this.waiter.getWaiterID();
	}

}
