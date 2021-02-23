package com.restaurantapp.domainmodel;

import java.util.ArrayList;

/*
 * Creato dall'interfaccia del cameriere al momento del login
 * Pigiando pulsante che rappresenta piatto nel menu
 * ritorna il this del piatto per poterlo inserire nell'OrderRecord
 */

public class Menu {
	
	private RepositoryMenu repositoryMenu;
	private ArrayList<Dish> dishes;
	private ArrayList<Ingredient> ingredients;
	
	public Menu(RepositoryMenu repositoryMenu){
		this.repositoryMenu=repositoryMenu;
		refresh();
	}

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
