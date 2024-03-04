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
				return p;
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
	 * @return
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


