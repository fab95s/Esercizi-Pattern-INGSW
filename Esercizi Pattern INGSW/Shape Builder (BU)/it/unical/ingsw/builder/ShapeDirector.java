package it.unical.ingsw.builder;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.List;

public class ShapeDirector {
	private ShapeBuilder builder;
	
	public void setBuilderFromFile(final File file) {
		String ext = file.getName().substring(file.getName().lastIndexOf('.') + 1);
		switch(ext) {
			case "xml":
				builder = new XMLShapeBuilder(file);
				break;
			case "txt":
				builder = new TXTShapeBuilder(file);
				break;
		}
	}
	
	public List<Rectangle> getRectangles() {
		return builder.getRects();
	}
	
	public List<Ellipse2D.Double> getEllipses() {
		return builder.getEllipses();
	}
	
	public List<Polygon> getTriangles() {
		return builder.getTriangles();
	}
	
	public void constructShapes() {
		builder.createRectangle();
		builder.buildRectangle();
		builder.createEllipses();
		builder.buildEllipse();
		builder.createTriangle();
		builder.buildTriangle();
	}
}
