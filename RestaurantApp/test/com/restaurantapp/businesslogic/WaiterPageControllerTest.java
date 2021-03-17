package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import com.restaurantapp.datalayer.FakeMenuData;
import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.Ingredient;
import com.restaurantapp.domainmodel.Menu;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableService;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableServiceRecord;
import com.restaurantapp.domainmodel.TableState;


class WaiterPageControllerTest {
	
	private static WaiterPageController WPC;
	private static Menu menu;

	@BeforeAll                                         
    static void setUpBeforeClass() throws Exception {
		PhisicalTable pt1 = new PhisicalTable(1);
		PhisicalTable pt3 = new PhisicalTable(3);
		
		PhisicalTable pt5 = new PhisicalTable(5);
		PhisicalTable pt6 = new PhisicalTable(6);
		
        ComposedTable ct = new ComposedTable(40);
        ct.addTable(pt1);
        ct.addTable(pt3);
        
        ComposedTable ct1 = new ComposedTable(60);
        ct1.addTable(pt5);
        
        ComposedTable ct2 = new ComposedTable(TableState.UNUSABLE,70);
        ct2.addTable(pt6);
        
        TableContainer tc = TableContainer.getInstance();
        tc.addTable(ct);
        tc.addTable(ct1);
        tc.addTable(ct2);
        
        WPC = new WaiterPageController("7011250");
        
        menu = new Menu(new FakeMenuData());
    }
	
	@Test
	@DisplayName("Ensure that table service opening takes place correctly")
	void testOpenTableService() {		
		assertTrue(WPC.openTableService(40, new TableServiceRecord("Francesco", "7013028")), "Table service created");
		assertFalse(WPC.openTableService(40, new TableServiceRecord("Francesco", "7165028")) ,"Table not available");
		assertFalse(WPC.openTableService(16, new TableServiceRecord("Gianni", "7015778")) ,"Table not found");
		assertFalse(WPC.openTableService(70, new TableServiceRecord("Francesco", "7015028")) ,"Table unusable");
	}

	@Test
	@DisplayName("Placing an order to table service should work") 
	void testPlaceOrderToTableService() {
		
		 Order order = new Order();
		 
		 Dish dish = menu.getDishes().get(0);
		 Ingredient ingredient = menu.getIngredients().get(1);
		 
		 OrderRecord orderRecord = new OrderRecord(dish);
		 orderRecord.setComment("impasto integrale");
		 
		 assertTrue(orderRecord.addIngredient(ingredient),"Ingredient added");
		 assertFalse(orderRecord.addIngredient(dish.getIngredients().get(0)),"Ingredient already inside");
		 assertTrue(orderRecord.removeIngredient(ingredient),"Ingredient removed");
		 assertFalse(orderRecord.removeIngredient(ingredient),"Ingredient not inside");
		 
		 order.addOrderRecord(orderRecord);
		 WPC.openTableService(60, new TableServiceRecord("Gianni", "7019928"));
		 	 
		 assertTrue(WPC.placeOrderToTableService(order, 60),"Order placed");
		 assertFalse(WPC.placeOrderToTableService(order, 20),"try to place an Order to unexistent TableService");
	}
	
	@AfterAll
	static void cleanUp() {
		TableContainer.getInstance().deleteTable(40);
		TableContainer.getInstance().deleteTable(60);
		TableContainer.getInstance().deleteTable(70);
		TableService ts= TableServiceContainer.getInstance().getTableService(40);
		TableServiceContainer.getInstance().removeTableService(ts);
		ts= TableServiceContainer.getInstance().getTableService(60);
		TableServiceContainer.getInstance().removeTableService(ts);
	}
}
