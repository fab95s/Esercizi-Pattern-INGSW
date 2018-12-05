package it.unical.ingsw.decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.interfaces.Pizza;

public class MozzarellaDecorator extends PizzaDecorator {
	Image mozzarella = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/mozzarella.png"));

	public MozzarellaDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public double getPrezzo() {
		return pizza.getPrezzo() + 0.50;
	}
	
	public void draw(Graphics g) {
		pizza.draw(g);
		g.drawImage(mozzarella, 80, 60, 650, 670, null);
	}

}
