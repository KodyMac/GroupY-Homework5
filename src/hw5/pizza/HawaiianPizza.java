package hw5.pizza;

public class HawaiianPizza extends AbstractPizza {

	
		//normal constructor
		public HawaiianPizza() { 
			super(3.00, 3.00, AbstractPizza.orderIDCounter++, null, 0);
			getToppingList().add(Toppings.CANADIAN_BACON);
			getToppingList().add(Toppings.CHEESE);
			getToppingList().add(Toppings.PINEAPPLE);
			addToppingsToPrice(priceWithoutToppings);
		}
		
		//copy constructor
		public HawaiianPizza(HawaiianPizza pizza) {
			super(pizza);
		}

		@Override
		protected double addToppingsToPrice(double priceWithoutToppings) {
			double calculatedPrice = priceWithoutToppings;
			for(Toppings c : getToppingList()) {
				calculatedPrice += c.getToppingPrice();
			}
			this.totalPrice = calculatedPrice;
			return calculatedPrice;
		}

		@Override
		public double updatePizzaPrice() {
			double calculatedPrice = this.priceWithoutToppings;
			for(Toppings c : getToppingList()) {
				calculatedPrice += c.getToppingPrice();
			}
			this.totalPrice = calculatedPrice;
			this.totalPrice += cookingPrice;
			return calculatedPrice;
		}

		@Override
		public String toString() {
			return "HawaiianPizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
					+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
					+ cookingStrategy + ", cookingPrice=" + cookingPrice + "]";
		}
}
