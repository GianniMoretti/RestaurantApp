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
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;

class OrderPageControllerTest {

	private static KitchenController KC;
	private static BarController BC;
	private static PizzeriaController PC;
	private static Menu menu;
	private static WaiterPageController WPC;

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
		
		Order order1 = new Order(true);
		Dish d= menu.getDishes().get(2);
		OrderRecord or1= new OrderRecord(d);
		order1.addOrderRecord(or1);
		
		KC = new KitchenController(OrderManager.getInstance());
		BC = new BarController(OrderManager.getInstance());
		PC = new PizzeriaController(OrderManager.getInstance());

		WPC = new WaiterPageController(7015028);

		WPC.openTableService(40, new TableServiceRecord("Francesco", "123456789"));
		WPC.placeOrderToTableService(order, 40);
		WPC.placeOrderToTableService(order1, 40);
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

		assertEquals(4, KC.getRecords().size(), "kitchen records is of right size");
		KC.getRecords().retainAll(kitchen);
		assertTrue(KC.getRecords().isEmpty(), "check kitchen records");

		assertEquals(1, PC.getRecords().size(), "pizzeria records is of right size");
		PC.getRecords().retainAll(pizzeria);
		assertTrue(PC.getRecords().isEmpty(), "check pizzeria records");

		assertEquals(3, BC.getRecords().size(), "bar records is of right size");
		BC.getRecords().retainAll(bar);
		assertTrue(BC.getRecords().isEmpty(), "check bar records");
		
		Order order2= new Order();
		Dish d= menu.getDishes().get(0);
		OrderRecord or2= new OrderRecord(d);
		order2.addOrderRecord(or2);
		WPC.placeOrderToTableService(order2,40);
		
		assertEquals(1, KC.getRecords().size(), "kitchen has received right order");
		assertTrue(PC.getRecords().isEmpty(), "pizzeria hasn't received any order");
		assertTrue(BC.getRecords().isEmpty(), "bar hasn't received any order");

	}
	
	@AfterAll
	static void cleanUp() {
		TableContainer.getInstance().deleteTable(40);
		TableService ts= TableServiceContainer.getInstance().getTableService(40);
		TableServiceContainer.getInstance().removeTableService(ts);
	}
}
