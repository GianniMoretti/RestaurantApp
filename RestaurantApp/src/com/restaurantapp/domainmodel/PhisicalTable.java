package com.restaurantapp.domainmodel;

public class PhisicalTable {
	private int tableID;
	private boolean available = true;

	public PhisicalTable(int tableID) {
		this.tableID = tableID;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public boolean isAvailable() {
		return available;
	}

}
