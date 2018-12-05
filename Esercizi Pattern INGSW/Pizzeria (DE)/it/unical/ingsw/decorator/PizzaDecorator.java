package it.unical.ingsw.decorator;

import java.awt.Graphics;

import it.unical.ingsw.interfaces.Pizza;

public abstract class PizzaDecorator implements Pizza {
	protected Pizza pizza;
	
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public double getPrezzo() {
		return pizza.getPrezzo();
	}

	@Override
	public void draw(Graphics g) {
		pizza.draw(g);
	}

}
