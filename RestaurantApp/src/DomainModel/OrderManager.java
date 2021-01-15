package DomainModel;
import java.util.ArrayList;
import java.util.Observable;

//TODO: is this a singleton pattern?
public class OrderManager extends Observable {
	
	private ArrayList<Order> orders; 
	
	public OrderManager() {
		orders = new ArrayList<Order> ();
	}
	
    public void addOrder(Order order) {
    	orders.add(order);
    	setChanged();
    	notifyObservers(order);
    }
}
