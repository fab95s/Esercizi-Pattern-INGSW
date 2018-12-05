package it.unical.ingsw.strategy;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.factory.Car;
import it.unical.ingsw.interfaces.CarStrategy;

public class Classic_configuration implements CarStrategy{

	@Override
	public Car configurator(Car c) {

		Image C_Image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Golf.jpg"));
		c.setName("Volkswagen Golf");
		c.setPrice(30500);
		c.setC(Color.WHITE);
		c.setImg(C_Image);
		return c;
	}

}
