package BusinessLogic;

import DomainModel.RepositoryTableRecord;
import DomainModel.TableService;
import DomainModel.TableServiceContainer;
import DomainModel.TableState;

public class CashierPageController {
	private TableServiceContainer tableServiceContainer;
	private RepositoryTableRecord repository;
	
	public CashierPageController(RepositoryTableRecord repository) {
		this.tableServiceContainer = TableServiceContainer.getInstance();
		this.repository = repository;
	}
	
	public double getBill(int id) {
		// TODO: TBD fare bene unit test !!!
		TableService ts = tableServiceContainer.getTableService(id);
		if(ts==null)
			return -1;
		tableServiceContainer.removeTableService(ts);
		repository.addRecord(ts.getTableServiceRecord());
		ts.getComposedTable().setTableState(TableState.DIRTY);
		return ts.getBill();
	}
}
