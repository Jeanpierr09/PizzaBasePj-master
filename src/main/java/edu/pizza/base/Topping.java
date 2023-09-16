package edu.pizza.base;

import java.util.ArrayList;

public class Topping {

    private String nombre; // Nombre del topping

    private double price;

    public double getPrice() {
        return price;
    }

    private ArrayList<String> ingredientes = new ArrayList<>(); // Ingredientes del topping

    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public Topping(String nombre, double price) {
        this.nombre = nombre;
        this.price = price;
    }

    @Override
    public String toString() {
        return nombre + " " +  "Q"+ price;

    }


    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }


}
