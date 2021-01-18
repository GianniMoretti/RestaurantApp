package DomainModel;

import java.util.ArrayList;

public interface RepositoryMenu {

	public void addDish(Dish dish);
	public void removeDish(Dish dish);
	public void addIngredient(Ingredient ingredient);
	public void removeIngredient(Ingredient ingredient);
	public ArrayList<Dish> getDishes();
	public ArrayList<Ingredient> getIngredients();
	
}
