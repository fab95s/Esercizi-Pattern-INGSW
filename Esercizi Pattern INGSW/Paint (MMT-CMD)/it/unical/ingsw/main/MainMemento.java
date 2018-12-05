package it.unical.ingsw.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.memento.DrawArea;
import it.unical.ingsw.memento.Shape;

@SuppressWarnings("serial")
public class MainMemento extends JPanel {
	private JButton red = new JButton();
	private JButton green = new JButton();
	private JButton blue = new JButton();
	private JButton magenta = new JButton();
	private JButton orange = new JButton();
	private JButton gray = new JButton();
	private JButton black = new JButton();
	
	private JButton rectangle = new JButton("Rettangolo");
	private JButton ellipse = new JButton("Cerchio");
	private JButton line = new JButton("Linea");
	
	private JButton undo = new JButton("Annulla");
	private JButton redo = new JButton("Ripristina");
	
	private DrawArea draw = new DrawArea();
	private JPanel bottom = new JPanel();
	private JPanel colors = new JPanel();
	private JPanel shapes = new JPanel();
	private JPanel commands = new JPanel();
	
	public MainMemento() {
		super();
		this.setLayout(new BorderLayout());
		bottom.setLayout(new BorderLayout());
		
		red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(30, 30));
		green.setBackground(Color.GREEN);
		green.setPreferredSize(new Dimension(30, 30));
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(new Dimension(30, 30));
		magenta.setBackground(Color.MAGENTA);
		magenta.setPreferredSize(new Dimension(30, 30));
		orange.setBackground(Color.ORANGE);
		orange.setPreferredSize(new Dimension(30, 30));
		gray.setBackground(Color.GRAY);
		gray.setPreferredSize(new Dimension(30, 30));
		black.setBackground(Color.BLACK);
		black.setPreferredSize(new Dimension(30, 30));
		
		colors.add(red);
		colors.add(green);
		colors.add(blue);
		colors.add(magenta);
		colors.add(orange);
		colors.add(gray);
		colors.add(black);
		bottom.add(colors, BorderLayout.NORTH);
		
		shapes.add(rectangle);
		shapes.add(ellipse);
		shapes.add(line);
		bottom.add(shapes, BorderLayout.CENTER);
		
		commands.add(undo);
		commands.add(redo);
		bottom.add(commands, BorderLayout.SOUTH);
		
		this.add(draw, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
		initEH();
	}
	
	private void initEH() {
		red.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.RED);
			}
		});
		green.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.GREEN);
			}
		});
		blue.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.BLUE);
			}
		});
		magenta.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.MAGENTA);
			}
		});
		orange.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.ORANGE);
			}
		});
		gray.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.GRAY);
			}
		});
		black.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setPaint(Color.BLACK);
			}
		});
		
		rectangle.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setType(Shape.RECTANGLE);
			}
		});
		ellipse.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setType(Shape.ELLIPSE);
			}
		});
		line.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.setType(Shape.LINE);
			}
		});
		
		undo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.undo();
			}
		});
		redo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				draw.redo();
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Paint");
		frame.setSize(650, 780);
		frame.setLocation(100, 20);
		frame.setContentPane(new MainMemento());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
