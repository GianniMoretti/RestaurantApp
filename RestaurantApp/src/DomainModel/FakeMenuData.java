package DomainModel;

import java.util.ArrayList;

public class FakeMenuData implements RepositoryMenu {
	
	private ArrayList<Dish> dishes;
	private ArrayList<Ingredient> ingredients;
	
	public FakeMenuData() {
		dishes = new ArrayList<>();
		ingredients = new ArrayList<>();
	}

	@Override
	public void addDish(Dish dish) {
		dishes.add(dish);
	}

	@Override
	public void removeDish(Dish dish) {
		dishes.remove(dish);
	}

	@Override
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	@Override
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}

	@Override
	public ArrayList<Dish> getDishes() {
		return dishes;
	}

	@Override
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	private void initializeIngredients() {
		// TODO genera fake ingredients	
	}
	
	private void initializeDishes() {
		//TODO genera fake dishes
	}
}
