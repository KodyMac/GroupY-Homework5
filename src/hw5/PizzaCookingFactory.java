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
	
	/**
	 * Copy constructor. Abstract pizza passed and a copy of it is returned
	 * @param p pizza to copy
	 * @return AbstractPizza
	 */
	public AbstractPizza copyPizza(AbstractPizza p) {
		if(p instanceof HawaiianPizza) {
			return new HawaiianPizza((HawaiianPizza)p);
		} else if (p instanceof MargheritaPizza) {
			return new MargheritaPizza((MargheritaPizza)p);
		} else if (p instanceof SupremePizza) {
			return new SupremePizza((SupremePizza)p);
		} else if (p instanceof VegetarianPizza) {
			return new VegetarianPizza((VegetarianPizza)p);
		}
		return null; //unknown pizza type
	}
}
