package it.unical.ingsw.main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unical.ingsw.interfaces.Strategy;
import it.unical.ingsw.strategy.BubbleSortStrategy;
import it.unical.ingsw.strategy.SelectionSortStrategy;

@SuppressWarnings("serial")
public class MainArraySort extends JPanel {
	private int[] array = new int[40];
	private Random rand = new Random();
	private String before = "", after = "";
	private JButton bubble = new JButton("Bubble Sort");
	private JButton selection = new JButton("Selection Sort");
	
	private Strategy bubbleSort = new BubbleSortStrategy();
	private Strategy selectionSort = new SelectionSortStrategy();
	
	public MainArraySort() {
		super();
		for(int i=0; i<array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		before = arrayToString();
		this.add(bubble);
		this.add(selection);
		initEH();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
		g.drawString(before, 10, 100);
		g.drawString(after, 10, 150);
	}
	
	private void initEH() {
		bubble.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					array = bubbleSort.sort(array);
					after = arrayToString();
					repaint();
				}
			}
		});
		selection.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					array = selectionSort.sort(array);
					after = arrayToString();
					repaint();
				}
			}
		});
	}
	
	private String arrayToString() {
		String tmp = "";
		for(int i=0; i<array.length; i++) {
			tmp += Integer.toString(array[i]) + "-";
		}
		return tmp.substring(0, tmp.length() - 1);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Array Sort");
		frame.setSize(750, 250);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainArraySort());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
