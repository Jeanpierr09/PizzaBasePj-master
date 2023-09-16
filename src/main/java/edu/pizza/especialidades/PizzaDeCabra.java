package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaDeCabra extends Pizza {

    public PizzaDeCabra(String name, double price, Topping... toppings){
        super(name, price, toppings);
        IngredientesPorDefecto();
    }

    private void IngredientesPorDefecto(){
        super.addTopping(new Topping("Queso de Cabra", 5));
        super.addTopping(new Topping("Cebolla Caramelizada", 3));
        super.addTopping(new Topping("Nueces", 1));
        super.addTopping(new Topping("Miel", 1));
    }

}
