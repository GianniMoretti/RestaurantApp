package com.restaurantapp.businesslogic;

import java.util.ArrayList;

import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableState;

/*
 * Login attraverso interfaccia che chiama il costruttore.
 * Metodo per settare i tavoli non usabili a inizio serata, 
 * per distruggere un composed table o per renderlo disponibile senza distruggerlo.
 * (Non ci sono controlli sullo stato del composed table prima di distruggerlo).
 */
public class HallOrganizatorPageController {

	private ArrayList<PhisicalTable> tables;

	public HallOrganizatorPageController(ArrayList<PhisicalTable> tables) {
		this.tables = tables;
	}

	public boolean createComposedTable(int id, int[] IDs){
		for(ComposedTable ct: TableContainer.getInstance().getTables()) {
			if(ct.getTableID()==id)
				return false;
		}
		ComposedTable c = new ComposedTable(id);
		ArrayList<PhisicalTable> tmp = new ArrayList<PhisicalTable>();

		for (int i = 0; i < IDs.length; i++) {
			for (PhisicalTable t : tables) {
				if (t.getTableID() == IDs[i] && t.isAvailable())
					tmp.add(t);
				else if (t.getTableID() == IDs[i] && !t.isAvailable())
					return false;
			}
		}
		for (PhisicalTable t : tmp) {
			c.addTable(t);
		}
		TableContainer.getInstance().addTable(c);
		return true;
	}

	public boolean setTablesUnusable(int[] IDs) {
		ArrayList<PhisicalTable> tmp = new ArrayList<PhisicalTable>();

		for (int i = 0; i < IDs.length; i++) {
			for (PhisicalTable t : tables) {
				if (t.getTableID() == IDs[i] && t.isAvailable()) 
					tmp.add(t);
			}
		}
		if (tmp.size() != IDs.length)
			return false;
		
		for (PhisicalTable t : tmp) {
			ComposedTable c = new ComposedTable(TableState.UNUSABLE, t.getTableID());
			c.addTable(t);
			TableContainer.getInstance().addTable(c);
		}
		return true;
	}

	public boolean deleteComposedTable(int id) {
		return TableContainer.getInstance().deleteTable(id);
	}

	public boolean setComposedTableAvailable(int id) {
		return TableContainer.getInstance().setComposedTableAvailable(id);
	}
}
