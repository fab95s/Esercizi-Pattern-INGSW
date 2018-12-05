package it.unical.ingsw.chat;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import it.unical.ingsw.main.MainChatRoom;
import it.unical.ingsw.observer.Client;

@SuppressWarnings("serial")
public class ChatPanel extends JPanel {
	private MainChatRoom frame;
	private SpringLayout layout = new SpringLayout();
	private static JTextArea textarea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textarea);
	private JTextField message = new JTextField();
	private JLabel username = new JLabel();
	private JButton send = new JButton("Invia");
	private Client client = Client.getClient();
	
	public ChatPanel(MainChatRoom frame) {
		super();
		this.frame = frame;
		initGUI();
		initEH();
	}
	
	private void initGUI() {
		this.setLayout(layout);
		this.add(scroll);
		this.add(message);
		this.add(send);
		this.add(username);
		message.setPreferredSize(new Dimension(this.getSize().width, 30));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, scroll, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, scroll, -5, SpringLayout.NORTH, message);
		
		layout.putConstraint(SpringLayout.WEST, message, 5, SpringLayout.EAST, username);
		layout.putConstraint(SpringLayout.EAST, message, -5, SpringLayout.WEST, send);
		layout.putConstraint(SpringLayout.SOUTH, message, -5, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, send, 5, SpringLayout.SOUTH, scroll);
		layout.putConstraint(SpringLayout.EAST, send, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, send, -5, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, username, 5, SpringLayout.SOUTH, scroll);
		layout.putConstraint(SpringLayout.WEST, username, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, username, -5, SpringLayout.SOUTH, this);
	}

	private void initEH() {
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				client.sendMessage(message.getText());
				System.out.println(frame.getUsername());
			}
		});
	}
	
	public static void writeMessage(String message) {
		textarea.append(message);
	}
	
	public void setUsernameLabel(String user) {
		username.setText(user + ":");
	}
}
