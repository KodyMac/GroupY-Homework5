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
		
	}

}
