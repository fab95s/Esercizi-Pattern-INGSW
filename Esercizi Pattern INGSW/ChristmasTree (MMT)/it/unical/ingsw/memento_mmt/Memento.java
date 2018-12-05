package it.unical.ingsw.memento_mmt;

import it.unical.ingsw.object.Ball;

public class Memento {
	
	private Ball b = new Ball();
	
	public Memento(Ball b) {
		this.b = b;
	}
	
	public Ball getBall() {
		return b;	
	}

	public void setBall(Ball b) {
		this.b = b;
	}	
}
