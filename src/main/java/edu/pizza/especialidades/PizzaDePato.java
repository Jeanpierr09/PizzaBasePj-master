package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaDePato extends Pizza {



    public PizzaDePato(String name, double price, Topping... toppings){
        super(name, price, toppings);

        IngredientesPorDefecto();
    }

    private void IngredientesPorDefecto(){
        super.addTopping(new Topping("Pato Confitado", 7));
        super.addTopping(new Topping("Salsa", 2));
        super.addTopping(new Topping("Mozzarella",6));
    }
}
