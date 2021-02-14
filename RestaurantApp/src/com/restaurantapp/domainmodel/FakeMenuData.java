package com.restaurantapp.domainmodel;

import java.util.ArrayList;
import java.util.HashMap;

public class FakeMenuData implements RepositoryMenu {
	
	private ArrayList<Dish> dishes;
	private HashMap<String, Ingredient> ingredients;
	
	public FakeMenuData() {
		dishes = new ArrayList<>();
		ingredients = new HashMap<String, Ingredient>();
		initializeIngredients();
		initializeDishes();
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
		ingredients.put(ingredient.getName(), ingredient);
	}

	@Override
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient.getName());
	}

	@Override
	public ArrayList<Dish> getDishes() {
		return dishes;
	}

	@Override
	public ArrayList<Ingredient> getIngredients() {
		return new ArrayList<Ingredient>(ingredients.values());
	}
	
	private void initializeIngredients() {
		Ingredient i= new Ingredient("Bufala", 2);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Pomodoro", 0.5);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Salsiccia", 2);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Stracchino", 2);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Friarielli", 1.5);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Banana", 0.5);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Gelato al Cioccolato", 1.5);
		ingredients.put(i.getName(), i);
		i= new Ingredient("Prosciutto Crudo", 2);
		ingredients.put(i.getName(), i);
	}
	
	private void initializeDishes() {
		Dish d= new Dish("Coccoli", 7.5, KindOfDish.STARTER);
		d.addIngredient(ingredients.get("Stracchino"));
		d.addIngredient(ingredients.get("Prosciutto Crudo"));
		dishes.add(d);
		
		d= new Dish("Pasta alla Norma", 11, KindOfDish.FIRST_COURSE);
		d.addIngredient(ingredients.get("Melanzane"));
		d.addIngredient(ingredients.get("Bufala"));
		d.addIngredient(ingredients.get("Pomodoro"));
		dishes.add(d);
		
		d= new Dish("Sarsiccie ai ferri", 14, KindOfDish.SECOND_COURSE);
		d.addIngredient(ingredients.get("Salsiccia"));
		dishes.add(d);
		
		d= new Dish("Friarielli saltati", 4, KindOfDish.SIDE_DISH);
		d.addIngredient(ingredients.get("Friarielli"));
		dishes.add(d);
		
		d= new Dish("Regina Margherita", 7, KindOfDish.PIZZA);
		d.addIngredient(ingredients.get("Bufala"));
		d.addIngredient(ingredients.get("Pomodoro"));
		dishes.add(d);
		
		d= new Dish("Birra alla spina piccola", 3, KindOfDish.DRINK);
		dishes.add(d);
		
		d= new Dish("Acqua Naturale 1l", 1.5, KindOfDish.DRINK);
		dishes.add(d);
		
		d= new Dish("Banana Split", 7.5, KindOfDish.DESSERT);
		d.addIngredient(ingredients.get("Gelato al Cioccolato"));
		d.addIngredient(ingredients.get("Banana"));
		dishes.add(d);
		
	}
}
