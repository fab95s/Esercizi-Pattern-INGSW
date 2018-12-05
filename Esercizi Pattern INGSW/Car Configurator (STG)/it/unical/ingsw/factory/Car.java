package it.unical.ingsw.factory;

import java.awt.Color;
import java.awt.Image;

public class Car {
	
	String name;
	int price;
	Color c;
	Image img = null;
	


	public Car(String name, int price, Color c) {
		this.name = name;
		this.price = price;
		this.c = c;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setC(Color c) {
		this.c = c;
	}


	public double getPrice() {
		return price;
	}
	
	public Color getC() {
		return c;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}


	public Image getImg() {
		return img;
	}
}
