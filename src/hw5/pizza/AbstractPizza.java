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
	
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	public abstract double updatePizzaPrice();
	
	
	
}
