package it.unical.ingsw.decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.interfaces.Pizza;

public class PeperoniDecorator extends PizzaDecorator {
	Image peperoni = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/peperoni.png"));

	public PeperoniDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public double getPrezzo() {
		return pizza.getPrezzo() + 0.80;
	}
	
	public void draw(Graphics g) {
		pizza.draw(g);
		g.drawImage(peperoni, 80, 60, 650, 670, null);
	}

}
