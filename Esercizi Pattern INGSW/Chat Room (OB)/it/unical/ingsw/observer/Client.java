package it.unical.ingsw.observer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import it.unical.ingsw.chat.ChatPanel;
import it.unical.ingsw.chat.Server;

public class Client extends Observer {
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket socket;
	private String recived;
	
	public Client(Server se) {
		server = se;
		try {
			socket = new Socket("localhost", 1111);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Client getClient() {
		return new Client(server);
	}
	
	public void sendMessage(String message) {
		try {
			dos.writeUTF(message);
			dos.flush();
			server.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		try {
			recived = dis.readUTF();
			ChatPanel.writeMessage(recived);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
