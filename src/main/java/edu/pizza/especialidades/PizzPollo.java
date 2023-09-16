package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzPollo extends Pizza{
    public PizzPollo(String name, double price, Topping... toppings) {
        super(name, price, toppings);

        IngredientesPorDefecto();
    }
    private void IngredientesPorDefecto(){
        super.addTopping(new Topping("Curry", 5));
        super.addTopping(new Topping("Cebolla", 6));
        super.addTopping(new Topping("Pimiento", 8));
    }

}
