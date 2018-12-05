package it.unical.ingsw.builder;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public abstract class ShapeBuilder {
	protected List<Rectangle> rects;
	protected List<Ellipse2D.Double> ellipses;
	protected List<Polygon> triangles;
	
	public List<Rectangle> getRects() {
		return rects;
	}
	
	public List<Ellipse2D.Double> getEllipses() {
		return ellipses;
	}
	
	public List<Polygon> getTriangles() {
		return triangles;
	}
	
	public void createRectangle() {
		rects = new ArrayList<Rectangle>();
	}
	
	public void createEllipses() {
		ellipses = new ArrayList<Ellipse2D.Double>();
	}
	
	public void createTriangle() {
		triangles = new ArrayList<Polygon>();
	}
	
	public abstract void buildRectangle();
	public abstract void buildEllipse();
	public abstract void buildTriangle();
}
