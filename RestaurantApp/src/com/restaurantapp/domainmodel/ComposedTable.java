package com.restaurantapp.domainmodel;

import java.util.ArrayList;

public class ComposedTable {
	private int tableID;
	private ArrayList<PhisicalTable> tables = new ArrayList<>();
	private TableState tableState;

	public ComposedTable(TableState tableState, int tableID) {
		this.tableState = tableState;
		this.tableID = tableID;
	}

	public ComposedTable(int tableID) {
		this.tableState = TableState.AVAILABLE;
		this.tableID = tableID;
	}

	public void addTable(PhisicalTable pt) {
		pt.setAvailable(false);
		tables.add(pt);
	}

	public int getTableID() {
		return tableID;
	}

	public TableState getTableState() {
		return tableState;
	}

	public void setTableState(TableState tableState) {
		this.tableState = tableState;
	}

	public void resetPhisicalTable() {
		for(PhisicalTable t : tables) {
			t.setAvailable(true);
		}
	}
}
