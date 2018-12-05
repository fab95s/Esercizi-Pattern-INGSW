package it.unical.ingsw.main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.state.Elevator;

@SuppressWarnings("serial")
public class MainAscensore extends JPanel implements Runnable {
	private JButton top = new JButton("Sali");
	private JButton bottom = new JButton("Scendi");
	private JButton call = new JButton("Chiudi");
	private Elevator elevator = new Elevator();
	
	public MainAscensore() {
		super();
		new Thread(this).start();
		this.add(top);
		this.add(bottom);
		this.add(call);
		call.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(call.isEnabled()) {
					call.setText(elevator.isOpened() ? "Apri" : "Chiudi");
					elevator.call();
					repaint();
				}
			}
		});
		top.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!elevator.isOpened() && elevator.getFloor() > 70 && top.isEnabled()) {
					new Thread(() -> {
						top.setEnabled(false);
						bottom.setEnabled(false);
						call.setEnabled(false);
						int floor = elevator.getFloor();
						for(int i=floor; i>=(floor - 180); i--) {
							elevator.setActualFloor(i);
							repaint();
							try {
								Thread.sleep(8);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						top.setEnabled(true);
						bottom.setEnabled(true);
						call.setEnabled(true);
					}).start();
				}
			}
		});
		bottom.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!elevator.isOpened() && elevator.getFloor() < 610 && bottom.isEnabled()) {
					new Thread(() -> {
						top.setEnabled(false);
						bottom.setEnabled(false);
						call.setEnabled(false);
						int floor = elevator.getFloor();
						for(int i=floor; i<=(floor + 180); i++) {
							elevator.setActualFloor(i);
							repaint();
							try {
								Thread.sleep(8);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						top.setEnabled(true);
						bottom.setEnabled(true);
						call.setEnabled(true);
					}).start();
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		elevator.draw(g);
		g.drawString("Piano Terra", 20, 600);
		g.drawString("Piano 1", 20, 420);
		g.drawString("Piano 2", 20, 240);
		g.drawString("Piano 3", 20, 60);
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Ascensore");
		frame.setSize(250, 800);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainAscensore());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
