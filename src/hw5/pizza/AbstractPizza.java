package hw5.pizza;


import java.util.ArrayList;
import java.util.List;

import hw5.cookingStrategy.ICookingStrategy;

public abstract class AbstractPizza {

	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter = 1;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	//normal constructor
	public AbstractPizza(double priceWithoutToppings, double totalPrice, int pizzaOrderID, ICookingStrategy cookingStrategy, double cookingPrice) {
		this.toppingList = new ArrayList<Toppings>();
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = totalPrice;
		this.pizzaOrderID = pizzaOrderID;
		this.cookingStrategy = cookingStrategy;
		this.cookingPrice = cookingPrice;
	}
	
	//copy constructor
	public AbstractPizza(AbstractPizza dif) {
		this.toppingList = new ArrayList<Toppings>(dif.toppingList);
		this.priceWithoutToppings = dif.priceWithoutToppings;
		this.totalPrice = dif.totalPrice;
		this.pizzaOrderID = dif.pizzaOrderID;
		this.cookingStrategy = dif.cookingStrategy;
		this.cookingPrice = dif.cookingPrice;
	}
	/**
	 * calculates the total price of the pizza using 
	 * priceWithoutToppings and the prices of each topping in the 
	 * toppingsList. It also assigns totalPrice attribute to the 
	 * calculated total price, and priceWithoutToppings attribute 
	 * to the passed parameter. This could be called once to add 
	 * the default toppings
	 * @param priceWithoutToppings
	 * @return double
	 */
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	
	/**
	 * calculates and updates the totalPrice of the pizza using priceWithoutToppings
	 * attribute and the prices of each topping in the toppingsList. You can use 
	 * this method on each update you make with the pizza
	 * @return double
	 */
	public abstract double updatePizzaPrice();
	
	
	//getters and setters
	public List<Toppings> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}

	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}

	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPizzaOrderID() {
		return pizzaOrderID;
	}

	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}

	public static int getOrderIDCounter() {
		return orderIDCounter;
	}

	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter;
	}

	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}

	public double getCookingPrice() {
		return cookingPrice;
	}

	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}

	
}
