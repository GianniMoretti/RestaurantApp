package BusinessLogic;

import DomainModel.RepositoryTableRecord;
import DomainModel.TableService;
import DomainModel.TableServiceMediator;
import DomainModel.TableState;

public class CashierPageController {
	private TableServiceMediator tableServiceMediator;
	private RepositoryTableRecord repository;
	
	public CashierPageController(TableServiceMediator tableServiceMediator, RepositoryTableRecord repository) {
		this.tableServiceMediator = tableServiceMediator;
		this.repository = repository;
	}
	
	public double getBill(int id) {
		// TODO: TBD fare bene unit test !!!
		TableService ts = tableServiceMediator.getTableService(id);
		if(ts==null)
			return -1;
		tableServiceMediator.removeTableService(ts);
		repository.addRecord(ts.getTableServiceRecord());
		ts.getComposedTable().setTableState(TableState.DIRTY);
		return ts.getBill();
	}
}
