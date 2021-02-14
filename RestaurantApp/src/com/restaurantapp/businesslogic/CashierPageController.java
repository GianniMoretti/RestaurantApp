package com.restaurantapp.businesslogic;

import com.restaurantapp.domainmodel.RepositoryTableRecord;
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableState;

public class CashierPageController {
	private TableServiceContainer tableServiceContainer;
	private RepositoryTableRecord repository;

	public CashierPageController(RepositoryTableRecord repository) {
		this.tableServiceContainer = TableServiceContainer.getInstance();
		this.repository = repository;
	}

	public double getBill(int id) {
		// TODO: TBD fare bene unit test !!!
		try {
			TableService ts = tableServiceContainer.getTableService(id);
			tableServiceContainer.removeTableService(ts);
			repository.addRecord(ts.getTableServiceRecord());
			ts.getComposedTable().setTableState(TableState.DIRTY);
			return ts.getBill();
		} catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
}
