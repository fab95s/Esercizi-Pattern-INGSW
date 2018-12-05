package it.unical.ingsw.factorys;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public abstract class AsciiFactory {
	
	protected String makeFromChar(final String text, final char c) {
		int width = text.length() * 18;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
		Graphics2D graphic = (Graphics2D) g;
		graphic.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphic.drawString(text, 10, 20);
		
		String ascii = "";
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				ascii += (image.getRGB(x, y) == -16777216 ? " " : c);
			}
			ascii += "\r\n";
		}
		return ascii;
	}
	
	public abstract String makeText(String text);

}
