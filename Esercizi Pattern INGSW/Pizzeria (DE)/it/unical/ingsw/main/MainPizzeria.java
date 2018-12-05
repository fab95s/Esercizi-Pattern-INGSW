package it.unical.ingsw.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.decorator.BlasphemyPizzaComponentException;
import it.unical.ingsw.decorator.FunghiDecorator;
import it.unical.ingsw.decorator.MozzarellaDecorator;
import it.unical.ingsw.decorator.PeperoniDecorator;
import it.unical.ingsw.decorator.SalameDecorator;
import it.unical.ingsw.decorator.SimplePizza;
import it.unical.ingsw.interfaces.Pizza;

@SuppressWarnings("serial")
public class MainPizzeria extends JPanel implements Runnable {
	JButton mozzarella = new JButton("Mozzarella");
	JButton salame = new JButton("Salame");
	JButton peperoni = new JButton("Peperoni");
	JButton funghi = new JButton("Funghi");
	JButton ananas = new JButton("Ananas");
	Pizza pizza = new SimplePizza();
	JPanel south = new JPanel();
	JPanel center = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			pizza.draw(g);
			g.setFont(new Font("Arial", Font.ITALIC, 16));
			g.drawString("Prezzo: " + pizza.getPrezzo(), 10, 20);
		}
	};
	
	public MainPizzeria() {
		super();
		this.setLayout(new BorderLayout());
		south.add(mozzarella);
		south.add(salame);
		south.add(peperoni);
		south.add(funghi);
		south.add(ananas);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		(new Thread(this)).start();
		initEH();
	}
	
	private void initEH() {
		mozzarella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pizza = new MozzarellaDecorator(pizza);
				center.repaint();
			}
		});
		salame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pizza = new SalameDecorator(pizza);
				center.repaint();
			}
		});
		peperoni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pizza = new PeperoniDecorator(pizza);
				center.repaint();
			}
		});
		funghi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pizza = new FunghiDecorator(pizza);
				center.repaint();
			}
		});
		ananas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				throw new BlasphemyPizzaComponentException("Non bestemmiare!");
			}
		});
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pizzeria");
		frame.setSize(800, 900);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainPizzeria());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
