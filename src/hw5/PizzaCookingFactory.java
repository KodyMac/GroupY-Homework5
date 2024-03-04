package hw5;

import hw5.pizza.AbstractPizza;
import hw5.pizza.HawaiianPizza;
import hw5.pizza.MargheritaPizza;
import hw5.pizza.PizzaType;
import hw5.pizza.SupremePizza;
import hw5.pizza.VegetarianPizza;

public class PizzaCookingFactory {

	/**
	 * Creates an AbstractPizza instance and instantiates it according 
	 * to the pizzaType parameter. It also sets the pizzaOrderID of the 
	 * pizza using the current orderIDCounter of the pizza. The 
	 * orderIDCounter will be incremented and assigned automatically on 
	 * every creation of pizza, to assign unique pizza order IDs
	 * 
	 * @param pizzaType
	 * @return AbstractPizza
	 */
	public AbstractPizza createPizza(PizzaType pizzaType) {
		AbstractPizza pizza;
		
		if(pizzaType.equals(PizzaType.HAWAIIAN)) {
			return new HawaiianPizza();
		} else if(pizzaType.equals(PizzaType.MARGHERITA)) {
			return new MargheritaPizza();
		} else if(pizzaType.equals(PizzaType.VEGETARIAN)) {
			return new VegetarianPizza();
		} else if(pizzaType.equals(PizzaType.SUPREME)) {
			return new SupremePizza();
		}
		
		return null;
	}
}
