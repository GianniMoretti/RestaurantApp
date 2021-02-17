package com.restaurantapp.domainmodel;

import java.util.ArrayList;
import java.time.LocalDate;

public interface RepositoryTableRecord {
	public void addRecord(TableServiceRecord tsr);
	public ArrayList<TableServiceRecord> getRecords(LocalDate date);
	public boolean deleteRecords(LocalDate date);
}
