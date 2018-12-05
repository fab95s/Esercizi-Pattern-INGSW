package it.unical.ingsw.main;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.interfaces.ImageGraphic;
import it.unical.ingsw.proxy.ImageProtectionProxy;
import it.unical.ingsw.proxy.ImageProxy;

@SuppressWarnings("serial")
public class MainSlideshow extends JPanel {
	JButton prev = new JButton("Precedente");
	JButton next = new JButton("Prossima");
	int pos = 1;
	
	ImageGraphic image1 = new ImageProxy("/images/slide1.jpg");
	ImageGraphic image2 = new ImageProxy("/images/slide2.jpg");
	ImageGraphic image3 = new ImageProxy("/images/slide3.jpg");
	ImageGraphic image4 = new ImageProtectionProxy("/images/slide4.jpg");
	ImageGraphic image5 = new ImageProxy("/images/slide5.jpg");
	
	Image current = null;
	
	public MainSlideshow() {
		super();
		this.setLayout(new FlowLayout());
		this.add(prev);
		this.add(next);
		initEH();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(current != null) {			
			g.drawImage(current, 0, 0, this);
		}
	}
	
	private void initEH() {
		prev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pos--;
				if(pos == 0) {
					pos = 5;
				}
				switchImage();
				repaint();
			}
		});
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pos++;
				if(pos == 6) {
					pos = 1;
				}
				switchImage();
				repaint();
			}
		});
	}

	private void switchImage() {
		switch(pos) {
			case 1:
				current = image1.getImage();
				break;
			case 2:
				current = image2.getImage();
				break;
			case 3:
				current = image3.getImage();
				break;
			case 4:
				current = image4.getImage();
				break;
			case 5:
				current = image5.getImage();
				break;
			default:
				break;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Slidershow");
		frame.setSize(1000, 750);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainSlideshow());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
