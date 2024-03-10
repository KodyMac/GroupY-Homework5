package hw5;

import hw5.cookingStrategy.*;
import hw5.pizza.*;
//import hw5.pizza.AbstractPizza;
//import hw5.pizza.CookingStyleType;
//import hw5.pizza.PizzaType;
//import hw5.pizza.Toppings;

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
		AbstractPizza pizza = null;
		for(AbstractPizza ap : pizzaOrderList) {
			if(ap.getPizzaOrderID()==orderID) {
				pizza = ap;
				break;
			}
		}
		if(pizza==null) {
			return;
		}
		for(Toppings t : pizza.getToppingList()) {
			System.out.println(t);
		}
	}

/**
 * Prints the pizzas in pizzaOrderList	
 * @param orderID
 */
	public void printPizzaOrderCart(int orderID) {
		for(AbstractPizza p : pizzaOrderList) {
			System.out.println(p);
		}
	}
	
/**
 * Finds and returns the pizza with the corresponding orderID
 * @param orderID
 * @return AbstractPizza
 */
	public AbstractPizza getPizzaByOrderID(int orderID) {
		for(AbstractPizza p : pizzaOrderList) {
			if(p.getPizzaOrderID()==orderID) {  //do i need a copy?
				return pizzaFactory.copyPizza(p);
			}
		}
		return null;
	}
	
	/**
	 * Creates a new pizza with the given pizzaType and adds it to the order list.
	 * Returns true if successful and false if not.
	 * @param pizzaType
	 * @return boolean
	 */
	public boolean addPizzaToCart(PizzaType pizzaType) {
		AbstractPizza p = pizzaFactory.createPizza(pizzaType);
		if(p==null) {
			return false;
		}
		pizzaOrderList.add(p);
		return true;
	}
	
	/**
	 * checks if topping is on pizza
	 * @param topping
	 * @param pizza
	 * @return boolean
	 */
	private boolean checkForTopping(Toppings topping, AbstractPizza p) {
		List<Toppings> t=p.getToppingList();
		return t.contains(topping);
	}
	
	/**
	 * Checks if topping is already on the pizza, and if not, it adds it to the pizza
	 * and updates the price
	 * @param orderID
	 * @param topping
	 * @return boolean
	 */
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		AbstractPizza p = getPizzaByOrderID(orderID); //get pizza by ID    //copy?
		if(p!=null) {
			if(checkForTopping(topping,p)) {
				p.getToppingList().add(topping);
				p.updatePizzaPrice();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if pizza object has specified topping, and if it does, it
	 * removes the topping, updates price, and returns true. If the
	 * topping isn't present, it returns false.
	 * @param orderID
	 * @param topping
	 * @return boolean
	 */
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		AbstractPizza p = getPizzaByOrderID(orderID);
		if(p!=null) {
			if(checkForTopping(topping,p)) {
				p.getToppingList().remove(topping);
				p.updatePizzaPrice();
				return true;
			}
		}
		return false;
}
	
	/**
	 * Returns true if there is a pizza that doesn't have an assigned cooking
	 * strategy, and returns false if there is none
	 * @return boolean
	 */
	public boolean isThereAnyUncookedPizza() {
		for(AbstractPizza pizza : pizzaOrderList) {
			ICookingStrategy strategy = pizza.getCookingStrategy();
			if(strategy == null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks if there are any uncooked pizzas. If all pizzas are cooked, it calculates the total 
	 * price of all pizzas and returns the total cart price. However, if there is at least one uncooked 
	 * pizza it throws an exception (Use the general Exception class). The checkout method calls the 
	 * isThereAnyUncookedPizza method to check for uncooked pizzas and throws an exception
	 * @return double
	 * @throws Exception
	 */
	public double checkout() throws Exception {
		if(isThereAnyUncookedPizza()) {
			throw new Exception("There is uncooked pizza! You don't want to buy it raw!");
		}
		
		double total = 0.0;
		for(AbstractPizza pizza : pizzaOrderList) {
			total+=pizza.getTotalPrice();
		}
		return total;
	}
	
	/**
	 * Helper method that returns pizza with given orderID
	 * @param orderID
	 * @return
	 */
	private AbstractPizza getPizzaByID(int orderID) {
		for(AbstractPizza p : pizzaOrderList) {
			if(p.getPizzaOrderID()==orderID) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * gets the pizza with the given order ID, instantiates the cookingStrategy according to the 
	 * cookingStrategyType parameter. Calls the cook function for the pizza of the pizza order 
	 * with the given order ID.
	 * @param orderID
	 * @param cookingStrategyType
	 * @return boolean
	 */
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		AbstractPizza pizza = getPizzaByID(orderID);
		if(pizza != null) {
			if(cookingStrategyType == CookingStyleType.BRICK_OVEN) {
				BrickOvenCookingStrategy tempStrat = new BrickOvenCookingStrategy();
				if(pizza.getCookingStrategy() != null && pizza.getCookingStrategy().getClass() == tempStrat.getClass()) {
					return false;
				}
				return tempStrat.cook(pizza);
			}
			
			if(cookingStrategyType == CookingStyleType.CONVENTIONAL_OVEN) {
				ConventionalOvenCookingStrategy tempStrat = new ConventionalOvenCookingStrategy();
				if(pizza.getCookingStrategy() != null && pizza.getCookingStrategy().getClass() == tempStrat.getClass()) {
					return false;
				}
				return tempStrat.cook(pizza);
			}
		
			if(cookingStrategyType == CookingStyleType.MICROWAVE) {
				MicrowaveCookingStrategy tempStrat = new MicrowaveCookingStrategy();
				if(pizza.getCookingStrategy() != null && pizza.getCookingStrategy().getClass() == tempStrat.getClass()) {
					return false;
				}
				return tempStrat.cook(pizza);
			}
		}
		return false;
	
	}
}