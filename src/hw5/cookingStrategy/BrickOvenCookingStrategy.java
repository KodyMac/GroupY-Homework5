package hw5.cookingStrategy;

import hw5.pizza.AbstractPizza;

public class BrickOvenCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingStrategy(new BrickOvenCookingStrategy());
		pizza.setCookingPrice(10);
		pizza.updatePizzaPrice();
		return true;
	}	
}
