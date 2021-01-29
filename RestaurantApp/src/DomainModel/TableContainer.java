package DomainModel;
import java.util.ArrayList;

public class TableContainer {

	private ArrayList<ComposedTable> tables;
	
	public TableContainer() {
		tables = new ArrayList<ComposedTable>();
	}
	
	public void addTable(ComposedTable table) {
		tables.add(table);
    }
	
	public ComposedTable getTable(int id) {
		for(ComposedTable ct : tables) {
			if(ct.getTableID() == id)
				return ct;
		}
		return null; // TODO: da rivdere
	}
}
