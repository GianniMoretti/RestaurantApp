package DomainModel;
import java.util.ArrayList;
import java.util.Observable;

public class OrderManager extends Observable {
	
	private ArrayList<Order> orders; 
	private static OrderManager instance=null;
	
	private OrderManager() {
		orders = new ArrayList<Order> ();
	}
	
	// Singleton
	public static OrderManager getInstance() {
		if(instance==null) {
			instance= new OrderManager();
		}
		return instance;
	}
	
    public void addOrder(Order order) {
    	orders.add(order);
    	setChanged();
    	notifyObservers(order);
    }
   
}
