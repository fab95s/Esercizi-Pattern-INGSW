package it.unical.ingsw.decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.interfaces.Pizza;

public class SalameDecorator extends PizzaDecorator {
	Image salame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/salame.png"));

	public SalameDecorator(Pizza pizza) {
		super(pizza);
	}

	public double getPrezzo() {
		return pizza.getPrezzo() + 0.70;
	}
	
	public void draw(Graphics g) {
		pizza.draw(g);
		g.drawImage(salame, 80, 60, 650, 670, null);
	}
}
