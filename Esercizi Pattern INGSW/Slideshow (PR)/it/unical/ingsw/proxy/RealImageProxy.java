package it.unical.ingsw.proxy;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unical.ingsw.flyweight.StockImage;
import it.unical.ingsw.interfaces.ImageGraphic;

public class RealImageProxy implements ImageGraphic {
	private String filename;
	private Image image = null;
	
	public RealImageProxy(String filename) {
		this.filename = filename;
		loadFromDisk();
	}

	private void loadFromDisk() {
		try {
			image = ImageIO.read(StockImage.class.getResource(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Image getImage() {
		return image;
	}

}
