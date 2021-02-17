package com.restaurantapp.domainmodel;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakeTableRecord implements RepositoryTableRecord {

	private ArrayList<TableServiceRecord> records;

	public FakeTableRecord() {
		records = new ArrayList<TableServiceRecord>();
	}

	@Override
	public void addRecord(TableServiceRecord tsr) {
		records.add(tsr);
	}

	@Override
	public ArrayList<TableServiceRecord> getRecords(LocalDate date) {
		ArrayList<TableServiceRecord> tmp = new ArrayList<TableServiceRecord>();
		for (TableServiceRecord record : records) {
			if (record.getDate().equals(date))
				tmp.add(record);
		}
		return tmp;
	}

	@Override
	public boolean deleteRecords(LocalDate date) {
		ArrayList<TableServiceRecord> tmp = new ArrayList<TableServiceRecord>();
		for (TableServiceRecord record : records) {
			if (record.getDate().equals(date))
				tmp.add(record);
		}
		if(tmp.isEmpty())
			return false;
		else {
			for(TableServiceRecord tsr:tmp)
				records.remove(tsr);
			return true;
		}
	}

}
