package it.unical.ingsw.flyweight;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class StockImage {
	public static String NAILS = "nails";
	public static String HAMMER = "hammer";
	public static String SCREWS = "screws";
	public static String SCREWDRIVER = "screwdriver";
	
	private Map<String, Image> products = new HashMap<String, Image>();
	
	public Image getImage(String imageName) {
		if(!products.containsKey(imageName)) {
			try {
				Image image = ImageIO.read(StockImage.class.getResource("/images/" + imageName + ".png"));
				products.put(imageName, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return products.get(imageName);
	}
}
