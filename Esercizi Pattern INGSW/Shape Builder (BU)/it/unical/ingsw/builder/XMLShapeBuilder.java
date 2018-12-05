package it.unical.ingsw.builder;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLShapeBuilder extends ShapeBuilder {
	private DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder docBuilder;
	private Document doc;
	private NodeList list;
	
	public XMLShapeBuilder(final File file) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(file);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buildRectangle() {
		list = doc.getElementsByTagName("rectangle");
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				int x = Integer.parseInt(elem.getAttribute("x"));
				int y = Integer.parseInt(elem.getAttribute("y"));
				int width = Integer.parseInt(elem.getElementsByTagName("width").item(0).getTextContent());
				int height = Integer.parseInt(elem.getElementsByTagName("height").item(0).getTextContent());
				rects.add(new Rectangle(x, y, width, height));
			}
		}
	}

	@Override
	public void buildEllipse() {
		list = doc.getElementsByTagName("ellipse");
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				int x = Integer.parseInt(elem.getAttribute("x"));
				int y = Integer.parseInt(elem.getAttribute("y"));
				int width = Integer.parseInt(elem.getElementsByTagName("width").item(0).getTextContent());
				int height = Integer.parseInt(elem.getElementsByTagName("height").item(0).getTextContent());
				ellipses.add(new Ellipse2D.Double(x, y, width, height));
			}
		}
	}

	@Override
	public void buildTriangle() {
		list = doc.getElementsByTagName("triangle");
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Polygon tmp = new Polygon();
				for(int j=0; j<node.getChildNodes().getLength(); j++) {
					Node point = node.getChildNodes().item(j);
					if(point.getNodeType() == Node.ELEMENT_NODE) {
						Element elem = (Element) point;
						int x = Integer.parseInt(elem.getElementsByTagName("x").item(0).getTextContent());
						int y = Integer.parseInt(elem.getElementsByTagName("y").item(0).getTextContent());
						tmp.addPoint(x, y);
					}
				}
				triangles.add(tmp);
			}
		}
	}

}
