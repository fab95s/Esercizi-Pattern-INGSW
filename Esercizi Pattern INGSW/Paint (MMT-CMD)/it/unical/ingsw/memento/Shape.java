package it.unical.ingsw.memento;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Shape {
	public static String RECTANGLE = "rectangle";
	public static String ELLIPSE = "ellipse";
	public static String LINE = "line";
	
	private Point old = new Point();
	private Point current = new Point();
	private String type = "rectangle";
	private Color color = Color.BLACK;
	
	public Shape() {}
	
	private Shape(Point old, Point current, String type, Color color) {
		this.old = old;
		this.current = current;
		this.type = type;
		this.color = color;
	}
	
	public Point getOld() {
		return old;
	}
	
	public Point getCurrent() {
		return current;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		if(type == Shape.RECTANGLE) {
			g.fillRect(old.x, old.y, current.x, current.y);
		}
		if(type == Shape.ELLIPSE) {
			g.fillOval(old.x, old.y, current.x, current.y);
		}
		if(type == Shape.LINE) {
			g.drawLine(old.x, old.y, current.x, current.y);
		}
	}
	
	public ShapeMemento getMemento() {
		return new ShapeMemento(new Shape(new Point(old), new Point(current), type, color));
	}

	public String toString() {
		return type + " : " + color.toString();
	}
}
