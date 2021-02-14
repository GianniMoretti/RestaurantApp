package com.restaurantapp.businesslogic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import com.restaurantapp.domainmodel.ComposedTable;
//import com.restaurantapp.domainmodel.FakeMenuData;
//import com.restaurantapp.domainmodel.Menu;
//import com.restaurantapp.domainmodel.PhisicalTable;
//import com.restaurantapp.domainmodel.RepositoryMenu;
//import com.restaurantapp.domainmodel.TableContainer;
import com.restaurantapp.domainmodel.*;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class WaiterPageControllerTest {
	
	private static WaiterPageController WPC;
	private static Menu menu;

	@BeforeAll                                         
    public static void setUp(){
		PhisicalTable pt1 = new PhisicalTable(1);
		PhisicalTable pt3 = new PhisicalTable(3);
		
		PhisicalTable pt5 = new PhisicalTable(5);
		
        ComposedTable ct = new ComposedTable(40);
        ct.addTable(pt1);
        ct.addTable(pt3);
        
        ComposedTable ct1 = new ComposedTable(60);
        ct1.addTable(pt5);
        
        TableContainer tc = TableContainer.getInstance();
        tc.addTable(ct);
        tc.addTable(ct1);
        
        WPC = new WaiterPageController(7010270);
        
        menu = new Menu(new FakeMenuData());
    }
	
	@Test
	@DisplayName("Open table service")
	void testOpenTableService() {		
		assertEquals(true, WPC.openTableService(40, 6) ,"Table service created");
		assertEquals(false, WPC.openTableService(40, 6) ,"Table not available");
		assertEquals(false, WPC.openTableService(16, 4) ,"Table not found");		
	}

	@Test
	@DisplayName("Place order to table service") 
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
		 WPC.placeOrderToTableService(order, 60);
		 
		 TableServiceContainer tsc = TableServiceContainer.getInstance();
		 int size = tsc.getTableService(60).getOrders().size();
		 
		 assertEquals(1, size,"Order placed");
	}
	
}
