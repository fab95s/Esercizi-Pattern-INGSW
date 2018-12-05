package it.unical.ingsw.decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.interfaces.Pizza;

public class SimplePizza implements Pizza {
	Image emptyPizza = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/empty_pizza.png"));
	
	@Override
	public double getPrezzo() {
		return 3.00;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(emptyPizza, 10, 10, 770, 790, null);
	}

}
