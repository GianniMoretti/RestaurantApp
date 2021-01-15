package DomainModel;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;

public abstract class RestaurantPageController implements Observer{

	//TODO: va bene protected?
	//Perchè lo abbiamo fatto?
	protected ArrayList<OrderRecord> orderRecords;
	
	@Override
	public void update(Observable ordermanager, Object order) {
		Order newOrder = (Order)order;
		getOrder(newOrder);
	}
	
	public abstract void getOrder(Order order);
}

