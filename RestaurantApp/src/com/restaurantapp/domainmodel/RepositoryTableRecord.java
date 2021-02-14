package com.restaurantapp.domainmodel;

import java.util.ArrayList;
import java.util.Date;

public interface RepositoryTableRecord {
	public void addRecord(TableServiceRecord tsr);
	public ArrayList<TableServiceRecord> getRecords(Date date);
	public boolean deleteRecords(Date date);
}
