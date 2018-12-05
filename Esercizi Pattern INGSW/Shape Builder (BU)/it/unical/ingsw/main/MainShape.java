package it.unical.ingsw.main;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.builder.ShapeDirector;

@SuppressWarnings("serial")
public class MainShape extends JFrame {
	File file = new File(getClass().getResource("/shapes.txt").getPath().replace("%20", " "));
	ShapeDirector director = new ShapeDirector();
	JPanel panel = new JPanel() {
		protected void paintComponent(Graphics g) {
			for(Rectangle r : director.getRectangles()) {
				g.drawRect(r.x, r.y, r.width, r.height);
			}
			for(Ellipse2D.Double e : director.getEllipses()) {
				g.drawOval((int) e.x, (int) e.y, (int) e.width, (int) e.height);
			}
			for(Polygon t : director.getTriangles()) {
				g.drawPolygon(t);
			}
		};
	};
	
	public MainShape() {
		super();
		this.setTitle("Shape Builder");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		director.setBuilderFromFile(file);
		director.constructShapes();
		this.add(panel);
	}
	
	public static void main(String[] args) {
		new MainShape().setVisible(true);
	}
	
}
