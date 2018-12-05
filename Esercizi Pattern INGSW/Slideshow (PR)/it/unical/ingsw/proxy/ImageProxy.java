package it.unical.ingsw.proxy;

import java.awt.Image;

import it.unical.ingsw.interfaces.ImageGraphic;

public class ImageProxy implements ImageGraphic {
	private String filename;
	private RealImageProxy image = null;
	
	public ImageProxy(String filename) {
		this.filename = filename;
	}

	@Override
	public Image getImage() {
		if(image == null) {
			image = new RealImageProxy(filename);
		}
		return image.getImage();
	}

}
