package BusinessLogic;

import DomainModel.ComposedTable;
import DomainModel.Order;
import DomainModel.TableContainer;
import DomainModel.TableService;
import DomainModel.TableServiceContainer;
import DomainModel.TableState;
import DomainModel.Waiter;

/*
 * login attraverso l'interfaccia prende l'ID e chiama il costruttore del WaiterPageController
 * Interagisce direttamente con il mediator per agire sui TableService
 */
public class WaiterPageController {
	private TableContainer tableContainer;
	private TableServiceContainer tableServiceContainer;
	private Waiter waiter;

	public WaiterPageController(int ID) {
		this.tableContainer = TableContainer.getInstance();
		this.tableServiceContainer = TableServiceContainer.getInstance();
		this.waiter = new Waiter(ID);
	}

	public boolean openTableService(int idTable, int service) {
		try {
			ComposedTable ct = tableContainer.getTable(idTable);
			if (ct.getTableState() == TableState.AVAILABLE) {
				ct.setTableState(TableState.UNAVAILABLE);
				TableService tableService = new TableService(this.waiter, ct, service);
				tableServiceContainer.addTableService(tableService);
				return true;
			}
			return false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public void placeOrderToTableService(Order order, int id) {
		tableServiceContainer.placeOrderToTableService(order, id);
	}

}
