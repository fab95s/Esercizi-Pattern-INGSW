package it.unical.ingsw.main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.factory.Car;
import it.unical.ingsw.interfaces.CarStrategy;
import it.unical.ingsw.strategy.Classic_configuration;
import it.unical.ingsw.strategy.Sports_configuration;

@SuppressWarnings("serial")
public class CarStrategyMain extends JPanel{
	
	Car c = new Car(" ", 0 , null);
	
	JButton sport = new JButton("Sport");
	JButton classic = new JButton("Classic");
		
	private CarStrategy sc = new Sports_configuration();
	private CarStrategy cc = new Classic_configuration();
	
	public CarStrategyMain() {
		super();

		this.add(sport);
		this.add(classic);
		initEH();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(c.getImg(), 120, 80, this);
		g.setFont(new Font("Lucida", Font.CENTER_BASELINE, 20));
		g.drawString(c.getName(), 120, 680);
		g.drawString(""+c.getPrice() + "€", 120, 700);
		
	}

	private void initEH() {
		sport.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				c=sc.configurator(c);
				repaint();
			}
		});
		
		classic.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				c=cc.configurator(c);
				repaint();
			}
		});
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Car Configuration Strategy");
		frame.setSize(1000, 800);
		frame.setLocation(300, 40);
		frame.setResizable(false);
		frame.setContentPane(new CarStrategyMain());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
		
}
