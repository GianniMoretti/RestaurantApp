package com.restaurantapp.domainmodel;

import java.util.ArrayList;

public class Order {
	/*
	 * WriteOff viene messo a false se
	 * ordine mandato in cucina e contato positivamente nel conto, messo a true se
	 * non viene mandato in cucina (comunicazione orale) e contato negativamente nel
	 * conto
	 */
	private static int count = 0;
	private int orderID;
	private boolean writeOff = false;
	private ArrayList<OrderRecord> records;

	public Order() {
		this.orderID = count;
		count++;
		this.records = new ArrayList<OrderRecord>();
	}

	public Order(boolean writeOff) {
		this();
		this.writeOff = writeOff;
	}

	public void addOrderRecord(OrderRecord orderRecord) {
		orderRecord.setId(orderID);
		records.add(orderRecord);
	}

	public double getTotal() {
		double total = 0;
		for (OrderRecord record : records) {
			total += record.getPrice();
		}
		if (writeOff)
			return -total;
		return total;
	}

	public int getOrderID() {
		return orderID;
	}

	public ArrayList<OrderRecord> getRecords() {
		return records;
	}

	public boolean isWriteOff() {
		return writeOff;
	}

}
