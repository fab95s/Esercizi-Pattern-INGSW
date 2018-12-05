package it.unical.ingsw.main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.flyweight.StockImage;

@SuppressWarnings("serial")
public class MainGiocoImmagini extends JPanel {
	Image background = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/background.jpg"));
	JButton nails = new JButton("Chiodi");
	JButton hammer = new JButton("Martello");
	JButton screws = new JButton("Viti");
	JButton screwdriver = new JButton("Cacciavite");
	Map<Point, String> points = new HashMap<Point, String>();
	StockImage images = new StockImage();
	Random rand = new Random();
	JPanel south = new JPanel();
	JPanel center = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, 0, this);
			if(!points.isEmpty()) {
				for(Map.Entry<Point, String> point : points.entrySet()) {
					g.drawImage(images.getImage(point.getValue()), point.getKey().x, point.getKey().y, 100, 100, this);
				}
			}
		}
	};
	
	public MainGiocoImmagini() {
		super();
		this.setLayout(new BorderLayout());
		south.add(nails);
		south.add(hammer);
		south.add(screws);
		south.add(screwdriver);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		initEH();
	}
	
	private void initEH() {
		nails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(800);
				int y = rand.nextInt(800);
				points.put(new Point(x, y), StockImage.NAILS);
				center.repaint();
			}
		});
		hammer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(800);
				int y = rand.nextInt(800);
				points.put(new Point(x, y), StockImage.HAMMER);
				center.repaint();
			}
		});
		screws.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(800);
				int y = rand.nextInt(800);
				points.put(new Point(x, y), StockImage.SCREWS);
				center.repaint();
			}
		});
		screwdriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(800);
				int y = rand.nextInt(800);
				points.put(new Point(x, y), StockImage.SCREWDRIVER);
				center.repaint();
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Gioco Immagini");
		frame.setSize(800, 900);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainGiocoImmagini());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
