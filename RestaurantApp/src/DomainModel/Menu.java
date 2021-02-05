package DomainModel;

import java.util.ArrayList;

// TODO: aggiungere un Singleton?
// TODO: creato la momento del login del camerire?

public class Menu {

	private RepositoryMenu repo;
	
	public Menu(RepositoryMenu repositoryMenu){
		this.repo = repositoryMenu;
	}
	
	/*
	 * Pigiando pulsante che rappresenta piatto nel menu
	 * ritorna il this del piatto per poterlo inserire nell'OrderRecord  
	 */
	 // TODO: piatto passato come copia?

	public ArrayList<Dish> getDishes() {
		return repo.getDishes();
	}

	public ArrayList<Ingredient> getIngredients() {
		return repo.getIngredients();
	}
	
}
