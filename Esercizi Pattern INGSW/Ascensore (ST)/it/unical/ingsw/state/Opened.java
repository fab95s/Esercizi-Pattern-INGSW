package it.unical.ingsw.state;

import java.awt.Image;
import java.awt.Toolkit;

import it.unical.ingsw.state.State;

public class Opened extends State {
	private static Opened instance = new Opened();
	Image opened = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/elevator-opened.jpg"));
	
	private Opened() {}
	
	public static State getInstance() {
		return instance;
	}

	@Override
	public void call(Elevator e) {
		e.setCurrent(Closed.getInstance());
	}

	@Override
	public Image getImage() {
		return opened;
	}

}
