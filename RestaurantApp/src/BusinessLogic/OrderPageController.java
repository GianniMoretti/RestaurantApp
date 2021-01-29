package BusinessLogic;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;
import DomainModel.OrderRecord;
import DomainModel.Order;
import DomainModel.KindOfDish;

public abstract class OrderPageController implements Observer{

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

