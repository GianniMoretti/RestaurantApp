package BusinessLogic;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;
import DomainModel.OrderRecord;
import DomainModel.Order;
import DomainModel.KindOfDish;

public abstract class OrderPageController implements Observer{

	//TODO: va bene protected?
	//Perchè lo abbiamo fatto? -> più facile aggiungere altri controller
	protected ArrayList<OrderRecord> orderRecords;
	
	@Override
	public void update(Observable ordermanager, Object order) {
		Order newOrder = (Order)order;
		getOrder(newOrder);
	}
	
	public abstract void getOrder(Order order);
	
	// chiamato al logout o alla chiusura dell'applicativo
	public void detach(Observable obs) {
		obs.deleteObserver(this);
	}
}

