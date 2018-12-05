package it.unical.ingsw.object;

import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.memento_mmt.Memento;

public class Ball{
	
	String name;	
	int x, y;
	private Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ball.png"));
	
	public Ball(String b, int x, int y) {
		this.name = b;
		this.x = x;
		this.y = y;
	}   
	
	public Ball() {}
	
	public Memento getMemento() {
		return new Memento(new Ball(name,x,y));
	}
	
	public String getName() {
		return name;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
