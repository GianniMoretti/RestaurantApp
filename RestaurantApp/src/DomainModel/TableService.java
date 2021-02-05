package DomainModel;

import java.util.ArrayList;

public class TableService {
	/*
	 * TODO: prezzo del coperto: prendere da men�, fare una costante, creare una
	 * classe...
	 */
	private static final double SERVICE_PRICE = 1.5;
	private int service;
	private ComposedTable composedTable;
	private TableServiceRecord tableServiceRecord;
	private Waiter waiter;
	private ArrayList<Order> orders;

	public TableService(Waiter waiter, ComposedTable composedTable, int service) {
		this.waiter = waiter;
		this.composedTable = composedTable;
		this.service = service;//n° coperti
		this.orders = new ArrayList<Order>();
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public double getBill() {
		double total = 0;
		for (Order order : orders)
			total += order.getTotal();
		total += service * SERVICE_PRICE;
		return total;
	}
	

	public int getService() {
		return service;
	}
	
	public void setService(int service) {
		this.service = service;
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
