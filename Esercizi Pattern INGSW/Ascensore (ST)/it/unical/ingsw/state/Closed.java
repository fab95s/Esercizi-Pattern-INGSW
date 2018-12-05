package it.unical.ingsw.state;

import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.state.State;

public class Closed extends State {
	private static Closed instance = new Closed();
	Image closed = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/elevator-closed.jpg"));
	
	private Closed() {}
	
	public static State getInstance() {
		return instance;
	}

	@Override
	public void call(Elevator e) {
		e.setCurrent(Opened.getInstance());
	}

	@Override
	public Image getImage() {
		return closed;
	}

}
