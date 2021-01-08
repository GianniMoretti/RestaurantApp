package DomainModel;

public class Ingredient {
	private String name;
	private double price;

	public Ingredient(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
