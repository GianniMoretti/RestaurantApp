package DomainModel;
import java.util.ArrayList;

public class TableContainer {
	/*
	 * Il cameriere prende un riferimento ad un composed table
	 * Il cassiere mette i tavoli in stato DA PULIRE, ma non li distrugge
	 * L'hall organizator gestisce creazione e distruzione dei tavoli
	 */

	private static TableContainer instance=null;
	private ArrayList<ComposedTable> tables;
	
	private TableContainer() {
		tables = new ArrayList<ComposedTable>();
	}
	
	// Singleton
	public static TableContainer getInstance() {
		if(instance==null)
			instance= new TableContainer();
		return instance;
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
	
	public boolean deleteTable(int id) {
		for(ComposedTable ct : tables) {
			if(ct.getTableID() == id) {
				ct.resetPhisicalTable();
				tables.remove(ct);
				return true;
			}				
		}
		return false;
	}
	
	public boolean setComposedTableAvailable(int id) {
		for(ComposedTable ct : tables) {
			if(ct.getTableID() == id) {
				ct.setTableState(TableState.AVAILABLE);
				return true;
			}				
		}
		return false;
	}
}
