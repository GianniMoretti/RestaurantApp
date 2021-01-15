package DomainModel;
import java.util.ArrayList;

public class GeneralAppController {
	private ArrayList<TableService> tableServices;
	private ArrayList<ComposedTable> tables;
	private OrderManager orderManager;
	
	public GeneralAppController(OrderManager orderManager) {
		this.orderManager = orderManager;
		tableServices = new ArrayList<TableService>();
	}
	
	public void addTable(ComposedTable table) {
		tables.add(table);
	}
	
	public void addTableService(TableService tableService) {
		tableServices.add(tableService);
	}
	
	public ComposedTable getTable(int id) {
		for(ComposedTable ct : tables) {
			if(ct.getTableID() == id)
				return ct;
		}
		return null; // TODO: da rivdere
	}
}
