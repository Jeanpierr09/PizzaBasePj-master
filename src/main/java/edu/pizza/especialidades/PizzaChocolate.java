package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaChocolate extends Pizza {

    public PizzaChocolate(String name, double price, Topping... toppings){
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("Cholate", 4));
        super.addTopping(new Topping("Fresas", 3));
        super.addTopping(new Topping("Azucar", 1));
    }

}
