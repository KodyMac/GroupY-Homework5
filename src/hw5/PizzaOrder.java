package hw5;

import hw5.cookingStrategy.ICookingStrategy;
import hw5.pizza.AbstractPizza;
import hw5.pizza.CookingStyleType;
import hw5.pizza.PizzaType;
import hw5.pizza.Toppings;

import java.util.ArrayList;
import java.util.List;

import hw5.PizzaCookingFactory;

public class PizzaOrder {

	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() {
		pizzaFactory = new PizzaCookingFactory();
		pizzaOrderList = new ArrayList<AbstractPizza>();
	}

	public void printListOfToppingsByPizzaOrderID(int orderID) {
		
	}

	
	public void printPizzaOrderCart(int orderID) {
		
	}

	public AbstractPizza getPizzaByOrderID(int orderID) {
		return null;
	}
	
	public boolean addPizzaToCart(PizzaType pizzaType) {
		return false;
	}
	
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		return false;
	}
	
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		return false;
	}
	
	public boolean isThereAnyUncookedPizza() {
		return false;
	}
	
	public double checkout() throws Exception {
		return 0.0;
	}
	
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		return false;
	}
}


