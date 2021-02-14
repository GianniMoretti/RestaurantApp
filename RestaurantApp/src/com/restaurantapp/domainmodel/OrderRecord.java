package com.restaurantapp.domainmodel;

import java.util.ArrayList;

public class OrderRecord {
	private int id;
	private Dish dish;
	private String comment;
	private ArrayList<Ingredient> addedIngredients;
	private ArrayList<Ingredient> removedIngredients;

	public OrderRecord(Dish dish) {
		//this.id = id;
		this.dish = dish;
		addedIngredients = new ArrayList<Ingredient>();
		removedIngredients = new ArrayList<Ingredient>();
	}
	
	public double getPrice() {
		double total=0;
		total+=dish.getPrice();
		for(Ingredient ingredient:addedIngredients) {
			total+=ingredient.getPrice();
		}
		for (Ingredient ingredient : removedIngredients) {
			total-=ingredient.getPrice();
		}
		return total;
	}
	
	public boolean addIngredient(Ingredient ingredient) {
		if(!dish.getIngredients().contains(ingredient) && !addedIngredients.contains(ingredient)) {
			addedIngredients.add(ingredient);
			return true;
		}
		return false;
	}

	public boolean removeIngredient(Ingredient ingredient) {
		if((dish.getIngredients().contains(ingredient) || addedIngredients.contains(ingredient)) && !removedIngredients.contains(ingredient)) {
			removedIngredients.add(ingredient);
			return true;
		}
		return false;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public Dish getDish() {
		return dish;
	}

	public ArrayList<Ingredient> getAddedIngredients() {
		return addedIngredients;
	}

	public ArrayList<Ingredient> getRemovedIngredients() {
		return removedIngredients;
	}

}
