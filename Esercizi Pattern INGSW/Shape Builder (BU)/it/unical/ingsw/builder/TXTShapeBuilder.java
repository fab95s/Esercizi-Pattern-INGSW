package it.unical.ingsw.builder;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TXTShapeBuilder extends ShapeBuilder {
	private BufferedReader reader;
	private List<String> shapes = new ArrayList<String>();
	
	public TXTShapeBuilder(final File file) {
		try {
			reader = new BufferedReader(new FileReader(file));
			String st;
			while((st = reader.readLine()) != null) {
				shapes.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buildRectangle() {
		for(String s : shapes) {
			String[] shape = s.split(" ");
			if(shape[0].equals("rectangle")) {
				int x = Integer.parseInt(shape[1].replace("x=", ""));
				int y = Integer.parseInt(shape[2].replace("y=", ""));
				int width = Integer.parseInt(shape[3].replace("width=", ""));
				int height = Integer.parseInt(shape[4].replace("height=", ""));
				rects.add(new Rectangle(x, y, width, height));
			}
		}
	}

	@Override
	public void buildEllipse() {
		for(String s : shapes) {
			String[] shape = s.split(" ");
			if(shape[0].equals("ellipse")) {
				int x = Integer.parseInt(shape[1].replace("x=", ""));
				int y = Integer.parseInt(shape[2].replace("y=", ""));
				int width = Integer.parseInt(shape[3].replace("width=", ""));
				int height = Integer.parseInt(shape[4].replace("height=", ""));
				ellipses.add(new Ellipse2D.Double(x, y, width, height));
			}
		}
	}

	@Override
	public void buildTriangle() {
		for(String s : shapes) {
			String[] shape = s.split(" ");
			if(shape[0].equals("triangle")) {
				Polygon tmp = new Polygon();
				for(int i=1; i<shape.length-1; i++) {
					int x = Integer.parseInt(shape[i].replace("x=", ""));
					int y = Integer.parseInt(shape[++i].replace("y=", ""));
					tmp.addPoint(x, y);
				}
				triangles.add(tmp);
			}
		}
	}

}
