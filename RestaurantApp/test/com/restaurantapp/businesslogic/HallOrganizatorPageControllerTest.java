package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableState;

class HallOrganizatorPageControllerTest {
	private static HallOrganizatorPageController HOPC;
	private static ArrayList<PhisicalTable> tables;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tables = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			tables.add(new PhisicalTable(i));

		HOPC = new HallOrganizatorPageController(tables);
	}

	@Test
	@DisplayName("Set Composed Table Unusable should work")
	void testSetTableUnusable() {
		assertTrue(HOPC.setTablesUnusable(new int[] { 1, 3, 5 }), "set table unusable");
		HOPC.createComposedTable(12, new int[] { 9 });
		assertFalse(HOPC.setTablesUnusable(new int[] { 1, 9 }), "set table unusable with unusable and unavailable");
		assertFalse(HOPC.setTablesUnusable(new int[] { 13 }), "try to set table unusable with unexistent table");
	}

	@Test
	@DisplayName("Create Composed Table should work")
	void testCreateComposedTable() {
		assertTrue(HOPC.createComposedTable(40, new int[] { 0, 2, 4 }), "create composed table");
		assertFalse(HOPC.createComposedTable(50, new int[] { 1, 3, 6 }), "create composed table with unusable");
		assertFalse(HOPC.createComposedTable(60, new int[] { 2, 7, 8 }), "create composed table with unavailable");
		assertFalse(HOPC.createComposedTable(40, new int[] { 6, 7}), "create composed with existent ID");
	}

	@Test
	@DisplayName("Delete Composed Table should work")
	void testDeleteComposedTable() {
		HOPC.createComposedTable(80, new int[] { 6, 7});
		assertTrue(HOPC.deleteComposedTable(80), "delete composed table");
		assertTrue(tables.get(6).isAvailable(), "reset phisical table works #1");
		assertTrue(tables.get(7).isAvailable(), "reset phisical table works #2");
		assertFalse(HOPC.deleteComposedTable(70), "delete unexistent composed table");
	}

	@Test
	@DisplayName("Set Composed Table Available should work")
	void testSetComposedTableAvailable() {
		ComposedTable ct = new ComposedTable(TableState.DIRTY, 45);
		ct.addTable(tables.get(6));
		ct.addTable(tables.get(7));
		ct.addTable(tables.get(8));
		TableContainer.getInstance().addTable(ct);

		assertTrue(HOPC.setComposedTableAvailable(45),"set composed table available");
		assertEquals(TableState.AVAILABLE, ct.getTableState(),"check the effectice state of composed table");
		assertFalse(HOPC.setComposedTableAvailable(50),"set unexistent composed table available");
	}
	
	@AfterAll
	static void cleanUp() {
		TableContainer.getInstance().deleteTable(1);
		TableContainer.getInstance().deleteTable(3);
		TableContainer.getInstance().deleteTable(5);
		TableContainer.getInstance().deleteTable(12);
		TableContainer.getInstance().deleteTable(40);
		TableContainer.getInstance().deleteTable(45);
	}
	
}
