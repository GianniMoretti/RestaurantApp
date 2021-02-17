package com.restaurantapp.domainmodel;

import java.time.LocalDate;

public class TableServiceRecord {
	/*
	 * TODO: serve? Creato al momento della distruzione... TODO: ragionare su metodo
	 * save
	 */
	private String nominative;
	private String phoneNumber;
	private LocalDate date;

	public TableServiceRecord(String nominative, String phoneNumber) {
		this.nominative = nominative;
		this.phoneNumber = phoneNumber;
		this.date = LocalDate.now();
	}
	
	//TODO: forse si può rimuovere
	public TableServiceRecord(String nominative, String phoneNumber, LocalDate date) {
		this.nominative = nominative;
		this.phoneNumber = phoneNumber;
		this.date = date;
	}

	public String getNominative() {
		return nominative;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getDate() {
		return date;
	}

}
