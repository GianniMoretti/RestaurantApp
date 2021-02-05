package BusinessLogic;
import java.util.ArrayList;

import java.util.Observable;
import DomainModel.OrderRecord;
import DomainModel.Order;
import DomainModel.KindOfDish;

//Interfaccia aperta direttamente senza login se si clicca sul pulsante Bar

public class BarController extends OrderPageController{

	public BarController(Observable obs) {
		obs.addObserver(this);
		orderRecords = new ArrayList<OrderRecord>();
	}
	
	@Override
	public void getOrder(Order order) {
		for(OrderRecord ord : order.getRecords()) {
			if(ord.getDish().getKindOfDish() == KindOfDish.DESSERT ||
			   ord.getDish().getKindOfDish() == KindOfDish.DRINK) {
				orderRecords.add(ord);
			}
		}
	}
}

