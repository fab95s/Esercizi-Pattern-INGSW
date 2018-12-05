package it.unical.Factory;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.Abstract.Component;
import it.unical.Interface.Implementor;

public class Brake_Component extends Component{
	
	private String brand;
	private int code, price;
	
	public Brake_Component(String brand, int code, int price, Implementor imp) {
		super(imp);
		this.brand = brand;
		this.code = code;
		this.price = price;
	}

	@Override
	public void make(Graphics g) {
		imp.draw_Brekes(code, price, g);
	}

	@Override
	public void edit_Price(int p) {
		price += p;
	}

	@Override
	public Image getImage() {
		Image image = null;
		try {
			image = ImageIO.read(Brake_Component.class.getResource("/images/" + brand + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return image;
	}
}
