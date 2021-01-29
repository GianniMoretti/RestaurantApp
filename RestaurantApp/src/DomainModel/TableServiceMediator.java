package DomainModel;

import java.util.ArrayList;

public class TableServiceMediator {
	private ArrayList<TableService> tableServices;
	private OrderManager orderManager;

	public TableServiceMediator(OrderManager orderManager) {
		this.orderManager = orderManager;
		tableServices = new ArrayList<TableService>();
	}

	public void addTableService(TableService tableService) {
		tableServices.add(tableService);
	}

}
