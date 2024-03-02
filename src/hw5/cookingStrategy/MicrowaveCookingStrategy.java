package hw5.cookingStrategy;

import hw5.pizza.AbstractPizza;

public class MicrowaveCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingStrategy(new MicrowaveCookingStrategy());
		pizza.setCookingPrice(1.00);
		pizza.updatePizzaPrice();
		return true;
	}

}
