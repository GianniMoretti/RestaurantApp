package DomainModel;

import java.util.ArrayList;

/*
 * lavorare in locale attraverso il waiterpage,
 * oppure spostare i metodi all'interno del mediator??
 * In caso, rimuovere il modifyTableService?
 * NB: controlla il send in addTableService
 */

public class TableServiceMediator {
	private ArrayList<TableService> tableServices;
	private OrderManager orderManager;

	public TableServiceMediator(OrderManager orderManager) {
		this.orderManager = orderManager;
		tableServices = new ArrayList<TableService>();
	}

	public void addTableService(TableService tableService, boolean send) {
		boolean add=true;
		for(TableService t:tableServices) {
			if(t==tableService)
				add=false;
		}
		if(add)
			tableServices.add(tableService);
		if(send)
			orderManager.addOrder(tableService.getOrders().get(tableService.getOrders().size()-1));
			// FIXME: verificare che venga inviato l'ultimo ordine aggiunto al tableService
	}

	public TableService getTableService(int idTable) {
		for (TableService t : tableServices) {
			if (t.getComposedTable().getTableID() == idTable)
				return t;
		}
		return null;
	}
}
