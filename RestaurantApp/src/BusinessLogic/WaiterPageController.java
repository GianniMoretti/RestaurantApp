package BusinessLogic;

import DomainModel.ComposedTable;
import DomainModel.Order;
import DomainModel.TableContainer;
import DomainModel.TableService;
import DomainModel.TableServiceMediator;
import DomainModel.Waiter;

/*
 * login attraverso l'interfaccia prende l'ID e chiama il costruttore del WaiterPageController
 * possiede un TableService locale su cui lavora e lo cambia attraverso una richiesta al mediator
 * ogni volta che conferma l'ordine il mediator fa il collegamento con l'order manager
 */
public class WaiterPageController {
	private TableContainer tableContainer;
	private TableServiceMediator tableServiceMediator;
	private Waiter waiter;
	private TableService tableService;

	public WaiterPageController(TableContainer tc, TableServiceMediator tsm, int ID) {
		this.tableContainer = tc;
		this.tableServiceMediator = tsm;
		this.waiter = new Waiter(ID);
	}

	public void openTableService(int idTable, int service) {
		ComposedTable ct = tableContainer.getTable(idTable);
		this.tableService = new TableService(this.waiter, ct, service);
	}
	
	public void addOrder(Order o) {
		
	}

	public boolean modifyTableService(int idTable) {
		// se ritorna false allora stampa un messaggio di errore sull'interfaccia
		var tmp = tableServiceMediator.getTableService(idTable);
		if (tmp == null)
			return false;
		this.tableService = tmp;
		return true;
	}
	
	public void confirmOrder() {
		tableServiceMediator.addTableService(tableService);
	}
}
