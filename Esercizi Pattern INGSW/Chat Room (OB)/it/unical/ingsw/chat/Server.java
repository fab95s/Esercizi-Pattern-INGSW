package it.unical.ingsw.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import it.unical.ingsw.observer.Client;
import it.unical.ingsw.observer.Observer;

public class Server {
	private List<Observer> clients = new ArrayList<Observer>();
	private ServerSocket server;
	
	public Server() {
		try {
			server = new ServerSocket(1111);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() {
		for(Observer client : clients) {
			client.update();
		}
	}

	public void startServer() {
		while(true) {
			try {
				server.accept();
				System.out.println("Il client ha accettato.");
				Client client = new Client(this);
				clients.add(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.startServer();
	}

}
