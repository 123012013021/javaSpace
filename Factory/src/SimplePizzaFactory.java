
public class SimplePizzaFactory {
	public static pizza createPizza( String type) {
		if(type == null) {
			return null;
		}
		if(type == "CheesePizza"){
			return new  CheesePizza();
		}
		if(type == "ClamPizza"){
			return new  ClamPizza();
		}
		if(type == "PepperoniPizza"){
			return new PepperoniPizza();
		}
		return null;
		}
    
}
