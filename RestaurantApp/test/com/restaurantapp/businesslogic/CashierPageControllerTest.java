package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.restaurantapp.datalayer.FakeMenuData;
import com.restaurantapp.datalayer.FakeTableRecord;
import com.restaurantapp.datalayer.RepositoryTableRecord;
import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.Menu;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;
import com.restaurantapp.domainmodel.TableState;
import com.restaurantapp.domainmodel.Waiter;

class CashierPageControllerTest {

	private static CashierPageController CPC;
	private static RepositoryTableRecord repository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		PhisicalTable pt1 = new PhisicalTable(1);
		PhisicalTable pt3 = new PhisicalTable(3);

		PhisicalTable pt5 = new PhisicalTable(5);
		PhisicalTable pt6 = new PhisicalTable(6);

		ComposedTable ct1 = new ComposedTable(40);
		ct1.addTable(pt1);
		ct1.addTable(pt3);

		ComposedTable ct2 = new ComposedTable(60);
		ct2.addTable(pt5);
		ct2.addTable(pt6);
		
		TableContainer tc = TableContainer.getInstance();
		tc.addTable(ct1);
		tc.addTable(ct2);

		TableService ts1 = new TableService(new Waiter("7015028"), ct1, new TableServiceRecord("Francesco", "123456789"));
		TableService ts2 = new TableService(new Waiter("7010270"), ct2, new TableServiceRecord("Gianni", "987654321"));

		TableServiceContainer tsc = TableServiceContainer.getInstance();
		tsc.addTableService(ts1);
		tsc.addTableService(ts2);

		Menu menu = new Menu(new FakeMenuData());
		
		Order service1= new Order();
		for(int i=0; i<4 ; i++) {
			OrderRecord or0= new OrderRecord(menu.getDishes().get(8));
			service1.addOrderRecord(or0);
		}
		
		ts1.addOrder(service1);
		
		Order service2= new Order();
		for(int i=0; i<3 ; i++) {
			OrderRecord or0= new OrderRecord(menu.getDishes().get(8));
			service2.addOrderRecord(or0);
		}
		
		ts2.addOrder(service2);

		Order o1 = new Order();
		
		Dish dish1 = menu.getDishes().get(0);
		OrderRecord or1 = new OrderRecord(dish1);
		o1.addOrderRecord(or1);
		
		Dish dish2 = menu.getDishes().get(2);
		OrderRecord or2 = new OrderRecord(dish2);
		o1.addOrderRecord(or2);
		
		Dish dish3 = menu.getDishes().get(4);
		OrderRecord or3 = new OrderRecord(dish3);
		or3.addIngredient(menu.getIngredients().get(3));
		o1.addOrderRecord(or3);
		
		Dish dish4 = menu.getDishes().get(6);
		OrderRecord or4 = new OrderRecord(dish4);
		o1.addOrderRecord(or4);
		
		ts1.addOrder(o1);
		
		Order o2 = new Order();
		OrderRecord or9 = new OrderRecord(menu.getDishes().get(0));
		or9.removeIngredient(menu.getIngredients().get(5));
		o2.addOrderRecord(or9);
		ts1.addOrder(o2);
		
		Order o3 = new Order();
		
		Dish dish5 = menu.getDishes().get(1);
		OrderRecord or5 = new OrderRecord(dish5);
		o3.addOrderRecord(or5);
		
		Dish dish6 = menu.getDishes().get(3);
		OrderRecord or6 = new OrderRecord(dish6);
		o3.addOrderRecord(or6);
		
		Dish dish7 = menu.getDishes().get(5);
		OrderRecord or7 = new OrderRecord(dish7);
		o3.addOrderRecord(or7);
		
		Dish dish8 = menu.getDishes().get(7);
		OrderRecord or8 = new OrderRecord(dish8);
		or8.removeIngredient(menu.getIngredients().get(7));
		o3.addOrderRecord(or8);

		ts2.addOrder(o3);
		
		Order o4 = new Order(true);
		o4.addOrderRecord(new OrderRecord(menu.getDishes().get(3)));
		ts2.addOrder(o4);

		repository = new FakeTableRecord();
		CPC = new CashierPageController(repository, "7233977");

	}

	@Test
	@DisplayName("getBill should return the exact price")
	void testGetBill() {
		assertEquals(44, CPC.getBill(40), "Bill with added and removed ingredients");
		assertEquals(25.5, CPC.getBill(60), "Bill with write off");
		assertEquals(TableState.DIRTY, TableContainer.getInstance().getTable(40).getTableState(), "Assert first DIRTY");
		assertEquals(TableState.DIRTY, TableContainer.getInstance().getTable(60).getTableState(), "Assert second DIRTY");
		
		assertEquals(2, repository.getRecords(LocalDate.now()).size(), "check saved records");
	}
	
	@AfterAll
	static void cleanUp() {
		TableContainer.getInstance().deleteTable(40);
		TableContainer.getInstance().deleteTable(60);
	}
}
