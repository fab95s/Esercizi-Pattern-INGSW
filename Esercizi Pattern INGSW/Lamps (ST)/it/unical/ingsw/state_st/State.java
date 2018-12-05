package it.unical.ingsw.state_st;

import java.awt.Image;

public abstract class State {
	
	public void push(Lamp l) {
		l.setCurrent(Off.instance());
	}
	
	public abstract Image getImage();

}
