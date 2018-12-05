package it.unical.ingsw.state_st;

import java.awt.Image;

import it.unical.ingsw.state_st.State;

public class Lamp {

	private State Current;
	
	public Lamp() {
		Current = Off.instance();
	}

	public void push() {
		Current.push(this);
	}

	public void setCurrent(State current) {
		Current = current;
	}
	
	public Image getImage() {
		return Current.getImage();
	}
	
}
