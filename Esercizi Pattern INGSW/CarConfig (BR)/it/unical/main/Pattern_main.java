package it.unical.main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import it.unical.Abstract.Component;
import it.unical.Factory.Bosh_Implementor;
import it.unical.Factory.Brake_Component;
import it.unical.Factory.Brembo_Implementor;


@SuppressWarnings("serial")
public class Pattern_main extends JPanel{
	
	Component tmp;
	Brake_Component BrComp;
	Image temp = null;
	boolean br = false, bo = false; 
	
	JButton Brembo = new JButton("Brembo");
	JButton Bosh = new JButton("Bosh");
	JPanel south = new JPanel();
	JPanel center = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(temp, this.getX() + 30, this.getY() + 110, 550, 550, this);
			if(br) {
				tmp.make(g);
			}
			else if(bo) {				
				tmp.make(g);
			}			
		}
	
	};
	
	public Pattern_main() {
		super();
		this.setLayout(new BorderLayout());
		south.add(Brembo);
		south.add(Bosh);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		initEH();
	}
	
	private void initEH() {
		Brembo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tmp = new Brake_Component("Brembo", 0603, 2000, new Brembo_Implementor());
				tmp.edit_Price(300);
				bo = false;
				br = true;
				temp = tmp.getImage();
				center.repaint();
			}
		});
		
		Bosh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tmp = new Brake_Component("Bosh",2402, 1500, new Bosh_Implementor());
				br = false;
				bo = true;
				temp = tmp.getImage();
				center.repaint();
			}
		});
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bridge Component Configurator");
		frame.setSize(1200, 900);
		frame.setLocation(300, 40);
		frame.setResizable(false);
		frame.setContentPane(new Pattern_main());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	 }	
}
