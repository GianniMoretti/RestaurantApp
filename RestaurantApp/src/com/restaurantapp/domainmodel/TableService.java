package com.restaurantapp.domainmodel;

import java.util.ArrayList;

public class TableService {
	private ComposedTable composedTable;
	private TableServiceRecord tableServiceRecord;
	private Waiter waiter;
	private ArrayList<Order> orders;

	public TableService(Waiter waiter, ComposedTable composedTable,TableServiceRecord tableServiceRecord) {
		this.waiter = waiter;
		this.composedTable = composedTable;
		this.orders = new ArrayList<Order>();
		this.tableServiceRecord = tableServiceRecord;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public double getBill() {
		double total = 0;
		for (Order order : orders)
			total += order.getTotal();
		return total;
	}

	public ComposedTable getComposedTable() {
		return composedTable;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setTableServiceRecord(TableServiceRecord tableServiceRecord) {
		this.tableServiceRecord = tableServiceRecord;
	}

	public TableServiceRecord getTableServiceRecord() {
		return tableServiceRecord;
	}

}
