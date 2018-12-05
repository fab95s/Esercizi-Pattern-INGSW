package it.unical.ingsw.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import it.unical.ingsw.memento_mmt.Memento;
import it.unical.ingsw.object.Ball;

@SuppressWarnings("serial")
public class Memento_Main  extends JPanel{
	
	private Ball b = new Ball();
	private Stack<Memento> insertMem = new Stack<Memento>();
	private Stack<Memento> redoMem = new Stack<Memento>();
	
	Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tree.png"));
	Image imgBcg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/sfondo.jpg"));
	
	JButton insert = new JButton("Inserisci");
	JButton undo = new JButton("Annulla");
	JButton redo = new JButton("Ripristina");
	
	public Memento_Main() {
		super();
		
		this.add(undo);
		this.add(redo);
		initEH();
	}

	private void initEH() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				b.setX(e.getX() - 50);
				b.setY(e.getY());
				insertMem.push(b.getMemento());
				redoMem.clear();
				repaint();
			}			
		});
		
		undo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!insertMem.isEmpty())
					redoMem.push(insertMem.pop());
				repaint();
			}
		});
		
		redo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!redoMem.isEmpty())
					insertMem.push(redoMem.pop());
				repaint();
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgBcg, 0, 0, 1000, 800, this);
		g.drawImage(img, 180, 60, 650, 650, this);
		
		for(Memento m : insertMem) {
			g.drawImage(m.getBall().getImage(), m.getBall().getX(), m.getBall().getY(), 100, 100, this);
		}

		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("ChristMas Tree");
		frame.setSize(1000, 800);
		frame.setLocation(300, 40);
		frame.setContentPane(new Memento_Main());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
