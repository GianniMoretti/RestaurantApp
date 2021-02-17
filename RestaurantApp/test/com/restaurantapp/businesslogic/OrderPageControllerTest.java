package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.FakeMenuData;
import com.restaurantapp.domainmodel.Menu;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderManager;
import com.restaurantapp.domainmodel.OrderRecord;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;

class OrderPageControllerTest {

	private static KitchenController KC;
	private static BarController BC;
	private static PizzeriaController PC;
	private static Menu menu;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		PhisicalTable pt1 = new PhisicalTable(1);
		PhisicalTable pt2 = new PhisicalTable(2);
		PhisicalTable pt3 = new PhisicalTable(3);

		ComposedTable ct = new ComposedTable(40);
		ct.addTable(pt1);
		ct.addTable(pt2);
		ct.addTable(pt3);

		TableContainer.getInstance().addTable(ct);

		menu = new Menu(new FakeMenuData());

		Order order = new Order();

		for (Dish d : menu.getDishes()) {
			OrderRecord or = new OrderRecord(d);
			order.addOrderRecord(or);
		}

		KC = new KitchenController(OrderManager.getInstance());
		BC = new BarController(OrderManager.getInstance());
		PC = new PizzeriaController(OrderManager.getInstance());

		WaiterPageController WPC = new WaiterPageController(7015028);

		WPC.openTableService(40, 4, new TableServiceRecord("Francesco", "123456789"));
		WPC.placeOrderToTableService(order, 40);
	}

	@Test
	@DisplayName("Observer should work")
	void test() {
		ArrayList<OrderRecord> kitchen = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			kitchen.add(new OrderRecord(menu.getDishes().get(i)));

		ArrayList<OrderRecord> pizzeria = new ArrayList<>();
		pizzeria.add(new OrderRecord(menu.getDishes().get(4)));

		ArrayList<OrderRecord> bar = new ArrayList<>();
		for (int i = 5; i < 8; i++)
			bar.add(new OrderRecord(menu.getDishes().get(i)));

		assertEquals(4, KC.getRecords().size(), "kitchen records is of the right size");
		KC.getRecords().retainAll(kitchen);
		assertTrue(KC.getRecords().isEmpty(), "check kitchen records");

		assertEquals(1, PC.getRecords().size(), "pizzeria records is of the right size");
		PC.getRecords().retainAll(pizzeria);
		assertTrue(PC.getRecords().isEmpty(), "check pizzeria records");

		assertEquals(3, BC.getRecords().size(), "bar records is of the right size");
		BC.getRecords().retainAll(bar);
		assertTrue(BC.getRecords().isEmpty(), "check bar records");

	}
	
	@AfterAll
	static void cleanUp() {
		TableContainer.getInstance().deleteTable(40);
	}
}
