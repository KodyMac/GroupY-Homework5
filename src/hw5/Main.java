package hw5;

import hw5.pizza.CookingStyleType;
import hw5.pizza.PizzaType;
import hw5.PizzaOrder;
import hw5.pizza.Toppings;

public class Main {

	public static void main(String[] args) {
		PizzaOrder order = new PizzaOrder();  //instantiate pizza order
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Adding one of each type of pizza ~\n");
		System.out.println(order.addPizzaToCart(PizzaType.VEGETARIAN));
		System.out.println(order.addPizzaToCart(PizzaType.HAWAIIAN));
		System.out.println(order.addPizzaToCart(PizzaType.SUPREME));
		System.out.println(order.addPizzaToCart(PizzaType.MARGHERITA));
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Printing Order Cart\n");
		order.printPizzaOrderCart(0);
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Getting pizza by OrderID ~\n");
		System.out.println("ID 1:  " + order.getPizzaByOrderID(1));
		System.out.println("ID 3:  " + order.getPizzaByOrderID(3));
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Printing Toppings of pizza by ID ~\n");
		System.out.println("ID 1:  ");
		order.printListOfToppingsByPizzaOrderID(1);
		System.out.println("ID 0:  ");
		order.printListOfToppingsByPizzaOrderID(0);
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Adding tomato to Margherita and Vegetarian");
		System.out.println("ID 0 has added tomato. " + order.addNewToppingToPizza(0, Toppings.TOMATO));
		System.out.println("ID 3 has added tomato. " + order.addNewToppingToPizza(3, Toppings.TOMATO));
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("Removing cheese topping on vegetarian ~\n");
		System.out.println("ID 0 has removed cheese: " + order.removeToppingFromPizza(0, Toppings.CHEESE));
		System.out.println(order.getPizzaByOrderID(0));
		
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("pizza 0 cooking strat is " + order.getPizzaByOrderID(0).getCookingStrategy());
		System.out.println("Updating strat\n");
		order.selectCookingStrategyByPizzaOrderID(0, CookingStyleType.CONVENTIONAL_OVEN);
		System.out.println("pizza 0 cooking strat is " + order.getPizzaByOrderID(0).getCookingStrategy());
		
		System.out.println("Checkout w/ exception thrown (not all pizzas have a cooking strat) :");
		try {
			System.out.println("Total order price: " + order.checkout());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Setting all cooking strats~");
		order.selectCookingStrategyByPizzaOrderID(0, CookingStyleType.BRICK_OVEN);
		order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.MICROWAVE);
		order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
		order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.BRICK_OVEN);
		
		System.out.println("Checkout w/ filled out cooking strats ~");
		try { 
			System.out.println("Total order price: " + order.checkout());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
