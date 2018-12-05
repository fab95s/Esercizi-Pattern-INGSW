package it.unical.ingsw.observer;

import it.unical.ingsw.chat.Server;

public abstract class Observer {
	protected static Server server;
	public abstract void update();
}
