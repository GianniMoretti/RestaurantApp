package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restaurantapp.domainmodel.FakeMenuData;
import com.restaurantapp.domainmodel.FakeTableRecord;
import com.restaurantapp.domainmodel.RepositoryTableRecord;
import com.restaurantapp.domainmodel.TableServiceRecord;

class RestaurantManagerPageControllerTest {
	
	private static RestaurantManagerPageController RMPC;
	private static ArrayList<TableServiceRecord> records;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		RepositoryTableRecord repository = new FakeTableRecord();
		RMPC = new RestaurantManagerPageController("7015028", new FakeMenuData(), repository);
		repository.addRecord(new TableServiceRecord("Francesco", "123456789", new Date()));
		repository.addRecord(new TableServiceRecord("Gianni", "987654321", new Date()));
		
		records=repository.getRecords(new Date());
	}
	
	@Test
	@DisplayName("Get Table Service should work")
	void testGetTableServiceRecords() {
		
		assertTrue(records.equals(RMPC.getTableServiceRecords(new Date())), "get table service record");
	}
	
	@Test
	@DisplayName("Delete Table Service should work")
	void testDeleteTableServiceRecords() {
		ArrayList<TableServiceRecord> tmp = new ArrayList<>();
		assertTrue(RMPC.deleteTableServiceRecords(new Date()), "delete records");
		assertTrue(tmp.equals(RMPC.getTableServiceRecords(new Date())), "check if the record list is empty");
		assertFalse(RMPC.deleteTableServiceRecords(new Date()));
	}

}
