package com.restaurantapp.businesslogic;

import com.restaurantapp.domainmodel.RepositoryTableRecord;
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;
import com.restaurantapp.domainmodel.TableState;

public class CashierPageController {
	private RepositoryTableRecord repository;

	public CashierPageController(RepositoryTableRecord repository) {
		this.repository = repository;
	}

	public double getBill(int id) {
		try {
			TableService ts = TableServiceContainer.getInstance().getTableService(id);
			TableServiceContainer.getInstance().removeTableService(ts);
			repository.addRecord(ts.getTableServiceRecord());
			ts.getComposedTable().setTableState(TableState.DIRTY);
			return ts.getBill();
		} catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
	
}
