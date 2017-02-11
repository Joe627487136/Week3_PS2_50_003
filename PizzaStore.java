package Week3;

import java.util.Scanner;

public class PizzaStore {
	public static void main(String[] args) {
		PizzaFac factory = new PizzaFac();
		PizzaStore store = new PizzaStore();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println(pizza);

		pizza = store.orderPizza("greek");
		System.out.println(pizza);
	}
	public Pizza orderPizza (String type) {
		Pizza pizza = null;
		
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		}
		if (type.equals("greek")) {
			pizza = new GreekPizza();
		}
		if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}

class Pizza {

	public void prepare() {
		System.out.println("Preparing");
	}

	public void box() {
		System.out.println("Boxing");
	}

	public void cut() {
		System.out.println("Cutting");
	}

	public void bake() {
		System.out.println("Baking");
	}
}


class CheesePizza extends Pizza {}
class GreekPizza extends Pizza {}
class PepperoniPizza extends Pizza {}

class PizzaFac{
	public Pizza makepizza(String newType){
		Pizza makepizza = null;
		if (newType.equals("cheese")){
			return new CheesePizza();
		}
		if (newType.equals("greek")){
			return new GreekPizza();
		}
		if (newType.equals("pepperoni")){
			return new PepperoniPizza();
		}
		else return null;
	}
}
