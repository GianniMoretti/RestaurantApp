package DomainModel;

import java.util.ArrayList;

// TODO: aggiungere un Singleton?

public class Menu {
	private ArrayList<Dish> dishes;
	private ArrayList<Ingredient> ingredients;
	
	public Menu(RepositoryMenu repositoryMenu){
		this.dishes=repositoryMenu.getDishes();
		this.ingredients=repositoryMenu.getIngredients();
	}
	
	/*
	 * Pigiando pulsante che rappresenta piatto nel menu
	 * ritorna il this del piatto per poterlo inserire nell'OrderRecord  
	 */
	 // TODO: piatto passato come copia?

	public ArrayList<Dish> getDishes() {
		return dishes;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	
	
}
