package hw5.cookingStrategy;

import hw5.pizza.AbstractPizza;

public class ConventionalOvenCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingStrategy(new ConventionalOvenCookingStrategy());
		pizza.setCookingPrice(8.00);
		pizza.updatePizzaPrice();
		return true;
	}

}
