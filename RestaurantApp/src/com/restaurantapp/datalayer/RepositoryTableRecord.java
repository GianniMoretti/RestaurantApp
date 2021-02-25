package com.restaurantapp.datalayer;

import java.util.ArrayList;

import com.restaurantapp.domainmodel.TableServiceRecord;

import java.time.LocalDate;

public interface RepositoryTableRecord {
	public void addRecord(TableServiceRecord tsr);
	public ArrayList<TableServiceRecord> getRecords(LocalDate date);
	public boolean deleteRecords(LocalDate date);
}
