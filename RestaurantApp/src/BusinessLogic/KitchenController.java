package BusinessLogic;
import java.util.ArrayList;
import java.util.Observable;
import DomainModel.OrderRecord;
import DomainModel.Order;
import DomainModel.KindOfDish;

public class KitchenController extends OrderPageController{

	public KitchenController(Observable obs) {
		obs.addObserver(this);
		orderRecords = new ArrayList<OrderRecord>();
	}
	
	@Override
	public void getOrder(Order order) {
		for(OrderRecord ord : order.getRecords()) {
			if(ord.getDish().getKindOfDish() == KindOfDish.STARTER ||
			   ord.getDish().getKindOfDish() == KindOfDish.FIRST_COURSE || 
			   ord.getDish().getKindOfDish() == KindOfDish.SECOND_COURSE ||  
			   ord.getDish().getKindOfDish() == KindOfDish.SIDE_DISH) {
				orderRecords.add(ord);
			}
		}
	}
}