package DomainModel;

import java.util.ArrayList;

public class Menu {
	
	private RepositoryMenu repositoryMenu;
	private ArrayList<Dish> dishes;
	private ArrayList<Ingredient> ingredients;
	
	public Menu(RepositoryMenu repositoryMenu){
		this.repositoryMenu=repositoryMenu;
		refresh();
	}
	
	/*
	 * Pigiando pulsante che rappresenta piatto nel menu
	 * ritorna il this del piatto per poterlo inserire nell'OrderRecord
	 */

	public void refresh() {
		this.dishes=repositoryMenu.getDishes();
		this.ingredients=repositoryMenu.getIngredients();
	}

	public ArrayList<Dish> getDishes() {
		return dishes;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
}
