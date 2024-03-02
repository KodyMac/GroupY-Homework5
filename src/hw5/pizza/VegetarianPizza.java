package hw5.pizza;

public class VegetarianPizza extends AbstractPizza {
	//normal constructor
	public VegetarianPizza() {
		super(1.50, 1.50, AbstractPizza.orderIDCounter++, null, 0);
		getToppingList().add(Toppings.TOMATO);
		getToppingList().add(Toppings.CHEESE);
		addToppingsToPrice(priceWithoutToppings);
	}
	
	//copy constructor
	public VegetarianPizza(VegetarianPizza pizza) {
		super(pizza);
	}

	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		double calculatedTotalPrice = priceWithoutToppings;
		for(Toppings c : getToppingList()) {
			calculatedTotalPrice += c.getToppingPrice();
		}
		this.totalPrice = calculatedTotalPrice;
		return calculatedTotalPrice;
	}

	@Override
	public double updatePizzaPrice() {
		double calculatedTotalPrice = this.priceWithoutToppings;
		for(Toppings c : getToppingList()) {
			calculatedTotalPrice += c.getToppingPrice();
		}
		this.totalPrice = calculatedTotalPrice;
		this.totalPrice += cookingPrice;
		return calculatedTotalPrice;
	}

	@Override
	public String toString() {
		return "VegetarianPizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
				+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
				+ cookingStrategy + ", cookingPrice=" + cookingPrice + "]";
	}
}
