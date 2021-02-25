package com.restaurantapp.datalayer;

import java.util.ArrayList;

import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.Ingredient;

public interface RepositoryMenu {

	public void addDish(Dish dish);
	public void removeDish(Dish dish);
	public void addIngredient(Ingredient ingredient);
	public void removeIngredient(Ingredient ingredient);
	public ArrayList<Dish> getDishes();
	public ArrayList<Ingredient> getIngredients();
	
}
