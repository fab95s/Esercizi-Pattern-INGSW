package it.unical.ingsw.state;

import java.awt.Image;

public abstract class State {
	public abstract void call(Elevator e);
	public abstract Image getImage();
}
