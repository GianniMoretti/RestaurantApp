package DomainModel;
import java.util.ArrayList;
import java.util.Observable;

public class PizzeriaController extends RestaurantPageController{

	public PizzeriaController(Observable obs) {
		obs.addObserver(this);
		orderRecords = new ArrayList<OrderRecord>();
	}
	
	@Override
	public void getOrder(Order order) {
		for(OrderRecord ord : order.getRecords()) {
			if(ord.getDish().getKindOfDish() == KindOfDish.PIZZA) {
				orderRecords.add(ord);
			}
		}
	}
}