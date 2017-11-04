
public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplePizzaFactory pizzastore = new  SimplePizzaFactory();
	   System.out.println("the first customer coming");
		pizza pizza1 = SimplePizzaFactory.createPizza("CheesePizza");
		pizza1.prepare();
		pizza1.bake();
		pizza1.cut();
		
	 System.out.println("the second customer coming");
		pizza pizza2 = SimplePizzaFactory.createPizza("ClamPizza");
		pizza2.prepare();
		pizza2.bake();
		pizza2.cut();
	}

}
