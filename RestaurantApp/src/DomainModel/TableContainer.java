package DomainModel;
import java.util.ArrayList;

public class TableContainer {
	/*
	 * Il cameriere prende un riferimento ad un composed table
	 * Il cassiere mette i tavoli in stato DA PULIRE, ma non li distrugge
	 * L'hall organizator gestisce creazione e distruzione dei tavoli
	 */

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
	
	public void deleteTable(int id) {
		for(ComposedTable ct : tables) {
			if(ct.getTableID() == id)
				tables.remove(ct);
		}
	}
}
