package hw5.pizza;

public class SupremePizza extends AbstractPizza{

	//normal constructor
	public SupremePizza() {
		super(3.50, 3.50, AbstractPizza.orderIDCounter++, null, 0);
		getToppingList().add(Toppings.TOMATO);
		getToppingList().add(Toppings.CHEESE);
		getToppingList().add(Toppings.BELL_PEPPER);
		getToppingList().add(Toppings.ITALIAN_SAUSAGE);
		getToppingList().add(Toppings.BLACK_OLIVE);
		getToppingList().add(Toppings.PEPPERONI);
		getToppingList().add(Toppings.MUSHROOM);
		addToppingsToPrice(priceWithoutToppings);
	}
	
	//copy constructor
	public SupremePizza(SupremePizza pizza) {
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
		return "SupremePizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
				+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
				+ cookingStrategy + ", cookingPrice=" + cookingPrice + "]";
	}
}
