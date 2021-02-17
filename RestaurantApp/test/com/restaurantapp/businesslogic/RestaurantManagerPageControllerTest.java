package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
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
		
		repository.addRecord(new TableServiceRecord("Francesco", "123456789"));
		repository.addRecord(new TableServiceRecord("Gianni", "987654321"));
		
		records=repository.getRecords(LocalDate.now());
		
	}
	
	@Test
	@DisplayName("Get Table Service should work")
	void testGetTableServiceRecords() {
		
		assertTrue(records.equals(RMPC.getTableServiceRecords(LocalDate.now())), "get table service record");
	}
	
	@Test
	@DisplayName("Delete Table Service should work")
	void testDeleteTableServiceRecords() {
		ArrayList<TableServiceRecord> tmp = new ArrayList<>();
		assertFalse(tmp.equals(RMPC.getTableServiceRecords(LocalDate.now())), "check if the record list is not empty");
		assertTrue(RMPC.deleteTableServiceRecords(LocalDate.now()), "delete records");
		assertTrue(tmp.equals(RMPC.getTableServiceRecords(LocalDate.now())), "check if the record list is empty");
		assertFalse(RMPC.deleteTableServiceRecords(LocalDate.now()), "no data to delete");
	}
	
}
