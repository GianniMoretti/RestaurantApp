package BusinessLogic;

import DomainModel.ComposedTable;
import DomainModel.Order;
import DomainModel.TableContainer;
import DomainModel.TableService;
import DomainModel.TableServiceMediator;
import DomainModel.Waiter;

/*
 * login attraverso l'interfaccia prende l'ID e chiama il costruttore del WaiterPageController
 * Interagisce direttamente con il mediator per agire sui TableService
 */
public class WaiterPageController {
	private TableContainer tableContainer;
	private TableServiceMediator tableServiceMediator;
	private Waiter waiter;

	public WaiterPageController(TableContainer tc, TableServiceMediator tsm, int ID) {
		this.tableContainer = tc;
		this.tableServiceMediator = tsm;
		this.waiter = new Waiter(ID);
	}

	public void openTableService(int idTable, int service) {
		ComposedTable ct = tableContainer.getTable(idTable);
		TableService tableService = new TableService(this.waiter, ct, service);
		tableServiceMediator.addTableService(tableService);
	}
	
	public void placeOrderToTableService(Order order, int id) {
		tableServiceMediator.placeOrderToTableService(order, id);
	}

}
