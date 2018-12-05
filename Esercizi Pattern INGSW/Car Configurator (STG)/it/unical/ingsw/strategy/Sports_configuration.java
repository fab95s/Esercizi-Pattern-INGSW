package it.unical.ingsw.strategy;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.factory.Car;
import it.unical.ingsw.interfaces.CarStrategy;

public class Sports_configuration implements CarStrategy{


	@Override
	public Car configurator(Car c) {
		
		Image R_Image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/GolfR.jpg"));
		c.setName("Volkswagen Golf R");
		c.setPrice(45500);
		c.setC(Color.black);
		c.setImg(R_Image);
		return c;
	}

	
	
}
