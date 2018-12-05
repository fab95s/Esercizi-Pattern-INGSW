package it.unical.ingsw.main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.state_st.Lamp;

@SuppressWarnings("serial")
public class MainLamp extends JPanel {
	
	private JButton push = new JButton("On/Off");
	
	private Lamp l = new Lamp();
	
	public MainLamp() {
		super();
		this.add(push);
		push.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				l.push();
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(l.getImage(), 2, 30, 256, 256, this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lamp");
		frame.setSize(260, 320);
		frame.setLocation(200, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainLamp());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
