package com.restaurantapp.businesslogic;

import java.time.LocalDate;
import java.util.ArrayList;

import com.restaurantapp.datalayer.RepositoryMenu;
import com.restaurantapp.datalayer.RepositoryTableRecord;
import com.restaurantapp.domainmodel.Dish;
import com.restaurantapp.domainmodel.Ingredient;
import com.restaurantapp.domainmodel.TableServiceRecord;

/**
 *  Il login attraverso l'interfaccia prende l'ID e chiama il costruttore del RestaurantManagerPageController.
 */

public class RestaurantManagerPageController {
	private String id;
	private RepositoryMenu repositoryMenu;
	private RepositoryTableRecord repositoryTableRecord;

	public RestaurantManagerPageController(String id, RepositoryMenu repositoryMenu, RepositoryTableRecord repositoryTableRecord) {
		this.id = id;
		this.repositoryMenu = repositoryMenu;
		this.repositoryTableRecord = repositoryTableRecord;
	}

	public boolean deleteTableServiceRecords(LocalDate date) {
		return repositoryTableRecord.deleteRecords(date);
	}

	public ArrayList<TableServiceRecord> getTableServiceRecords(LocalDate date) {
		return repositoryTableRecord.getRecords(date);
	}

	public void addDish(Dish dish) {
		repositoryMenu.addDish(dish);
	}

	public void removeDish(Dish dish) {
		repositoryMenu.removeDish(dish);
	}

	public void addIngredient(Ingredient ingredient) {
		repositoryMenu.addIngredient(ingredient);
	}

	public void removeIngredient(Ingredient ingredient) {
		repositoryMenu.removeIngredient(ingredient);
	}
}
