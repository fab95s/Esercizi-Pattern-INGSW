package it.unical.Factory;

import java.awt.Font;
import java.awt.Graphics;

import it.unical.Interface.Implementor;

public class Brembo_Implementor implements Implementor{

	@Override
	public void draw_Brekes(int code, int price, Graphics g) {
		g.setFont(new Font("Arial", Font.ITALIC, 20));
		g.drawString("Brembo", 750, 240);
		g.drawString("" + code, 750, 270);
		g.drawString("" + price + "€", 750, 300);
	}

}
