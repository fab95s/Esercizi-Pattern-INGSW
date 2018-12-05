package it.unical.ingsw.chat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import it.unical.ingsw.main.MainChatRoom;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private MainChatRoom frame;
	private SpringLayout layout = new SpringLayout();
	private JTextField username = new JTextField();
	private JButton login = new JButton("Accedi");
	
	public LoginPanel(MainChatRoom frame) {
		super();
		this.frame = frame;
		initGUI();
		initEH();
	}

	private void initGUI() {
		this.setLayout(layout);
		this.add(username);
		this.add(login);
		
		layout.putConstraint(SpringLayout.NORTH, username, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username, -10, SpringLayout.WEST, login);
		layout.putConstraint(SpringLayout.SOUTH, username, -10, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, login, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, login, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, login, -10, SpringLayout.SOUTH, this);
	}

	private void initEH() {
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					frame.setUsername(username.getText());
					frame.switchFrame();
				}
			}
		});
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setUsername(username.getText());
				frame.switchFrame();
			}
		});
	}
}
