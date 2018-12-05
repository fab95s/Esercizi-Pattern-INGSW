package it.unical.ingsw.state;

import java.awt.Graphics;

import it.unical.ingsw.state.State;

public class Elevator {
	private State current;
	private int actualFloor = 610;
	
	public Elevator() {
		current = Opened.getInstance();
	}
	
	public void setCurrent(State s) {
		current = s;
	}
	
	public int getFloor() {
		return actualFloor;
	}
	
	public void setActualFloor(int floor) {
		actualFloor = floor;
	}
	
	public boolean isOpened() {
		return (current instanceof Opened);
	}
	
	public void call() {
		current.call(this);
	}
	
	public void draw(Graphics g) {
		g.drawImage(current.getImage(), 65, actualFloor, 120, 150, null);
	}
}
