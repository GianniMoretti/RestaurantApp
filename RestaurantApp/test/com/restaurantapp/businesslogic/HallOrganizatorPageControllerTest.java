package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
			tables.add(new PhisicalTable(i + 1));

		HOPC = new HallOrganizatorPageController(tables);
	}

	@Test
	@DisplayName("Create Composed Table should work")
	void testSetTableUnusable() {
		assertTrue(HOPC.setTablesUnusable(new int[] { 2, 4, 6 }), "set table unusable");
		HOPC.createComposedTable(12, new int[] { 10 });
		assertFalse(HOPC.setTablesUnusable(new int[] { 2, 10 }), "set table unusable with unusable and unavailable");
	}

	@Test
	@DisplayName("Create Composed Table should work")
	void testCreateComposedTable() {
		assertTrue(HOPC.createComposedTable(40, new int[] { 1, 3, 5 }), "create composed table");
		assertFalse(HOPC.createComposedTable(50, new int[] { 2, 4, 7 }), "create composed table with unusable");
		assertFalse(HOPC.createComposedTable(60, new int[] { 3, 8, 9 }), "create composed table with unavailable");
	}

	@Test
	@DisplayName("Delete Composed Table should work")
	void testDeleteComposedTable() {
		HOPC.createComposedTable(40, new int[] { 1, 3, 5 });
		assertTrue(HOPC.deleteComposedTable(40), "delete composed table");
		assertTrue(tables.get(0).isAvailable(), "reset phisical table works 1");
		assertTrue(tables.get(2).isAvailable(), "reset phisical table works 2");
		assertTrue(tables.get(4).isAvailable(), "reset phisical table works 3");
		assertFalse(HOPC.deleteComposedTable(70), "create composed table with unusable");
	}

	@Test
	@DisplayName("Set Composed Table Available should work")
	void testSetComposedTableAvailable() {
		TableContainer tc = TableContainer.getInstance();
		ComposedTable ct = new ComposedTable(45);
		ct.addTable(tables.get(1));
		ct.addTable(tables.get(6));
		ct.addTable(tables.get(8));
		ct.setTableState(TableState.UNAVAILABLE);
		tc.addTable(ct);

		assertTrue(HOPC.setComposedTableAvailable(45),"set composed table available");
		assertEquals(TableState.AVAILABLE, ct.getTableState(),"check the effectice state of composed table");
		assertFalse(HOPC.setComposedTableAvailable(50),"set non-existest composed table available");
	}
}
