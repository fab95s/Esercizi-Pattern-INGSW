package it.unical.ingsw.decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.interfaces.Pizza;

public class FunghiDecorator extends PizzaDecorator {
	Image funghi = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/funghi.png"));

	public FunghiDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public double getPrezzo() {
		return pizza.getPrezzo() + 1.00;
	}
	
	public void draw(Graphics g) {
		pizza.draw(g);
		g.drawImage(funghi, 120, 100, 600, 600, null);
	}

}
