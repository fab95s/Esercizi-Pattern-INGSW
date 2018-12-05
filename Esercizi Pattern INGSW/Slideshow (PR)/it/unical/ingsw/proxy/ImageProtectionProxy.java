package it.unical.ingsw.proxy;

import java.awt.Image;
import java.util.Scanner;

import it.unical.ingsw.interfaces.ImageGraphic;

public class ImageProtectionProxy implements ImageGraphic {
	private String filename;
	private String password = "0000";
	private String userPass = "";
	private RealImageProxy image = null;
	private Scanner scan = new Scanner(System.in);
	
	public ImageProtectionProxy(String filename) {
		this.filename = filename;
	}

	@Override
	public Image getImage() {
		if(image == null) {
			System.out.print("Password: ");
			userPass = scan.nextLine();
			if(password.equals(userPass)) {				
				image = new RealImageProxy(filename);
				return image.getImage();
			} else {
				throw new RuntimeException("Password errata!");
			}
		} else if(password.equals(userPass)) {
			return image.getImage();
		}
		return null;
	}

}
