package DomainModel;

import java.util.ArrayList;

public class Order {
	/*
	 * TODO: riguardare metodi REMOVE e MODIFY...
	 */
	private static int count=0;
	private int orderID;
	private ArrayList<OrderRecord> records;
	
	public Order() {
		this.orderID = count;
		count++;
		this.records = new ArrayList<OrderRecord>();
	}
	
	public void addOrderRecord(OrderRecord orderRecord) {
		orderRecord.setId(orderID);
		records.add(orderRecord);
	}
	
	public void removeOrderRecord(OrderRecord orderRecord) {
		records.remove(orderRecord);
	}
	
	public void modifyOrderRecord(OrderRecord oldOR, OrderRecord newOR) {
		removeOrderRecord(oldOR);
		addOrderRecord(newOR);
	}
	
	public double getTotal() {
		double total=0;
		for(OrderRecord record:records) {
			total+=record.getPrice();
		}
		return total;
	}

	public int getOrderID() {
		return orderID;
	}

	public ArrayList<OrderRecord> getRecords() {
		return records;
	}
	
}

// ciao
