package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

class OrderPageControllerTest {

	private static KitchenController KC;
	private static BarController BC;
	private static PizzeriaController PC;
	private static Menu menu;
	private static WaiterPageController WPC;
	private static Order order;

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

		order = new Order();

		for (Dish d : menu.getDishes()) {
			OrderRecord or = new OrderRecord(d);
			order.addOrderRecord(or);
		}

		KC = new KitchenController(OrderManager.getInstance());
		BC = new BarController(OrderManager.getInstance());
		PC = new PizzeriaController(OrderManager.getInstance());

		WPC = new WaiterPageController(7015028);

		
	}

	@Test
	@DisplayName("Observer should work")
	void test() {
		WPC.placeOrderToTableService(order, 40);
		
		ArrayList<OrderRecord> kitchen = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			kitchen.add(new OrderRecord(menu.getDishes().get(i)));

		ArrayList<OrderRecord> pizzeria = new ArrayList<>();
		pizzeria.add(new OrderRecord(menu.getDishes().get(4)));

		ArrayList<OrderRecord> bar = new ArrayList<>();
		for (int i = 5; i < 8; i++)
			bar.add(new OrderRecord(menu.getDishes().get(i)));
		
		assertFalse(KC.getRecords().isEmpty(),"kitchen records is not empty");
		KC.getRecords().retainAll(kitchen);
		assertTrue(KC.getRecords().isEmpty(),"check kitchen records");
		
		assertFalse(PC.getRecords().isEmpty(),"pizzeria records is not empty");
		PC.getRecords().retainAll(pizzeria);
		assertTrue(PC.getRecords().isEmpty(),"check pizzeria records");
		
		assertFalse(BC.getRecords().isEmpty(),"bar records is not empty");
		BC.getRecords().retainAll(bar);
		assertTrue(BC.getRecords().isEmpty(),"check bar records");

	}

}
