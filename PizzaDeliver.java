package Week3;

public class PizzaDeliver {

	public static void main(String[] args) {
		PizzaFac factory = new PizzaFac();
		PizzaStore store = new PizzaStore();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println(pizza);

		pizza = store.orderPizza("greek");
		System.out.println(pizza);
	}
}
