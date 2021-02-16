package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import com.restaurantapp.domainmodel.ComposedTable;
import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.FakeMenuData;
import com.restaurantapp.domainmodel.Menu;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;
import com.restaurantapp.domainmodel.PhisicalTable;
import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.TableServiceContainer;
import com.restaurantapp.domainmodel.TableState;


class WaiterPageControllerTest {
	
	private static WaiterPageController WPC;
	private static Menu menu;

	@BeforeAll                                         
    static void setUpBeforeClass(){
		PhisicalTable pt1 = new PhisicalTable(1);
		PhisicalTable pt3 = new PhisicalTable(3);
		
		PhisicalTable pt5 = new PhisicalTable(5);
		PhisicalTable pt6 = new PhisicalTable(6);
		
        ComposedTable ct = new ComposedTable(40);
        ct.addTable(pt1);
        ct.addTable(pt3);
        
        ComposedTable ct1 = new ComposedTable(60);
        ct1.addTable(pt5);
        
        ComposedTable ct2 = new ComposedTable(70);
        ct2.addTable(pt6);
        ct2.setTableState(TableState.UNUSABLE);
        
        TableContainer tc = TableContainer.getInstance();
        tc.addTable(ct);
        tc.addTable(ct1);
        tc.addTable(ct2);
        
        WPC = new WaiterPageController(7010270);
        
        menu = new Menu(new FakeMenuData());
    }
	
	@Test
	@DisplayName("Ensures that table service opening takes place correctly")
	void testOpenTableService() {		
		assertTrue(WPC.openTableService(40, 6), "Table service created");
		assertFalse(WPC.openTableService(40, 6) ,"Table not available");
		assertFalse(WPC.openTableService(16, 4) ,"Table not found");
		assertFalse(WPC.openTableService(60, 4) ,"Table unusable");
	}

	@Test
	@DisplayName("Placing an order to table service should work") 
	void testPlaceOrderToTableService() {
		
		 Order order = new Order();
		 
		 Dish dish = menu.getDishes().get(0);
		 //Ingredient ingredient = menu.getIngredients().get(1); //FIXME: Non è presente
		 
		 OrderRecord orderRecord = new OrderRecord(dish);
		 orderRecord.setComment("impasto integrale");
		 
		 //TODO: Vediamo se deve esserci
		 /*assertEquals(true, orderRecord.addIngredient(ingredient),"Ingredient added");
		 assertEquals(false, orderRecord.addIngredient(dish.getIngredients().get(0)),"Ingredient already inside");
		 assertEquals(true, orderRecord.removeIngredient(ingredient),"Ingredient removed");
		 assertEquals(false, orderRecord.removeIngredient(ingredient),"Ingredient not inside");*/
		 
		 order.addOrderRecord(orderRecord);
		 WPC.openTableService(60, 3);
		 	 
		 assertTrue(WPC.placeOrderToTableService(order, 60),"Order placed");
		 assertFalse(WPC.placeOrderToTableService(order, 20),"Order placed");
	}
}
