package it.unical.ingsw.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import it.unical.ingsw.chat.ChatPanel;
import it.unical.ingsw.chat.LoginPanel;

@SuppressWarnings("serial")
public class MainChatRoom extends JFrame {
	private String username;
	private SpringLayout layout = new SpringLayout();
	private ChatPanel chat = new ChatPanel(this);
	private LoginPanel login = new LoginPanel(this);
	
	public MainChatRoom() {
		super("Chat Room");
		this.setLayout(layout);
		this.setResizable(false);
		this.setMinimumSize(new Dimension(500, 80));
		this.setLocation(100, 20);
		this.setContentPane(login);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layout.putConstraint(SpringLayout.NORTH, chat, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, chat, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, chat, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, chat, 0, SpringLayout.EAST, this);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void switchFrame() {
		chat.setUsernameLabel(username);
		this.setContentPane(chat);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(500, 300));
		this.pack();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public static void main(String[] args) {
		new MainChatRoom();
	}
}
