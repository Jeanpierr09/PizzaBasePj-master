package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class frmPizza {
    private JPanel jpanelPrincipal;
    private JComboBox comBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;

    private JList lista1;
    private JButton btnPreparar;
    private JComboBox comboBoxPizzas;
    private JButton btnSeleccionarPizza;
    private JRadioButton pequeñaRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton grandeRadioButton;

    private DefaultListModel modeloLista = new DefaultListModel();

    private List<Topping> ingredientes = new ArrayList();

    private List<Pizza> Pizzas = new ArrayList<>();


    private double total;


    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }

    private double preciofinal = 0.0;

    public frmPizza() {
        cargarToppings();


        PizzaChocolate PizzaRara1 = new PizzaChocolate("Pizza de Chocolate", 45);
        PizzaDeCabra PizzaRara2 = new PizzaDeCabra("Pizza de Cabra", 50);
        PizzaDePato PizzaRara3 = new PizzaDePato("Pizza de Pato", 55);
        PizzaItaliana PizzaRara4 = new PizzaItaliana("Pizza Italiana", 60);
        PizzPollo PizzaRara5 = new PizzPollo("Pizza de Pollo", 45);

        comboBoxPizzas.addItem(PizzaRara1);
        comboBoxPizzas.addItem(PizzaRara2);
        comboBoxPizzas.addItem(PizzaRara3);
        comboBoxPizzas.addItem(PizzaRara4);
        comboBoxPizzas.addItem(PizzaRara5);

        comboBoxPizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngredientesMostrar((Pizza) comboBoxPizzas.getSelectedItem());
            }
        });


        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingredientes = (Topping) comBoxToppings.getSelectedItem();
                modeloLista.addElement(ingredientes);
                lista1.setModel(modeloLista);

                preciofinal += ingredientes.getPrice();
                lblTotal.setText(String.valueOf(preciofinal));


            }

        });

        btnPreparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i < lista1.getModel().getSize(); i++) {
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();
            }
        });


        btnSeleccionarPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza Pizzas = (Pizza) comboBoxPizzas.getSelectedItem();
                modeloLista.addElement(Pizzas);
                lista1.setModel(modeloLista);
                txtPizza.setText(Pizzas.getName());
                btnSeleccionarPizza.setEnabled(false);

                double precioActualizado = PrecioActualizado(Pizzas);

                preciofinal = Pizzas.getPrice() + precioActualizado;
                lblTotal.setText(String.valueOf(preciofinal));

            }

        });

        pequeñaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal;
                medianaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);
            }
        });
        medianaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 15;
                lblTotal.setText(String.valueOf(preciofinal));
                pequeñaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);
            }
        });
        grandeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 30;
                pequeñaRadioButton.setSelected(false);
                medianaRadioButton.setSelected(false);
            }
        });
    }


    private void cargarToppings() {
        ingredientes.add(new Topping("Champiñones", 4.55));
        ingredientes.add(new Topping("Tomate", 2.55));
        ingredientes.add(new Topping("Cebolla", 6.55));
        ingredientes.add(new Topping("Salchica", 10.55));
        ingredientes.add(new Topping("Calamares", 11.55));
        ingredientes.add(new Topping("Chucho", 14.55));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comBoxToppings.setModel(model);

    }

    private void IngredientesMostrar(Pizza pizza) {
        modeloLista.clear();
        for (Topping topping : pizza.getToppings()) {
            modeloLista.addElement(topping);
        }
        lista1.setModel(modeloLista);
        PrecioActualizado(pizza);
    }

    private double PrecioActualizado(Pizza pizza) {
        double costo = 0.0;
        for (Topping topping : pizza.getToppings()) {
            costo += topping.getPrice();
        }
        lblTotal.setText(String.valueOf(costo));
        return costo;
    }

}