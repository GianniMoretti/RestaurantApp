package DomainModel;

import java.util.ArrayList;

public class Dish {
	private String name;
	private double price;
	private ArrayList<Ingredient> ingredients;
	private KindOfDish kindOfDish;

	public Dish(String name, double price, KindOfDish kindOfDish) {
		this.name = name;
		this.price = price;
		this.ingredients = new ArrayList<Ingredient>();
		this.kindOfDish = kindOfDish;
	}

	public void addIngredient(Ingredient ingredient) {
		if(!ingredients.contains(ingredient))
			ingredients.add(ingredient);
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public KindOfDish getKindOfDish() {
		return kindOfDish;
	}

}
