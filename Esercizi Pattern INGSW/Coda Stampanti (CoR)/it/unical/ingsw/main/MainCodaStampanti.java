package it.unical.ingsw.main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unical.ingsw.chain_of_responsability.PrintRequest;
import it.unical.ingsw.chain_of_responsability.Printer;

@SuppressWarnings("serial")
public class MainCodaStampanti extends JPanel implements Runnable {
	private JTextField field = new JTextField(20);
	private JButton print = new JButton("Stampa");
	private PrintRequest request = new PrintRequest();
	private Printer[] printers = new Printer[50];
	
	public MainCodaStampanti() {
		super();
		this.add(field);
		this.add(print);
		int x = 0, y = 128;
		printers[0] = new Printer(0, x, y);
		x += 64;
		for(int i=1; i<50; i++) {
			printers[i] = new Printer(i, x, y);
			x += 64;
			printers[i - 1].setSuccessor(printers[i]);
			if(x >= 640) {
				x = 0;
				y += 128;
			}
			(new Thread(printers[i])).start();
		}
		(new Thread(this)).start();
		initEH();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Printer printer : printers) {
			printer.draw(g);
		}
	}
	
	private void initEH() {
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				request.setMessage(field.getText());
				printers[0].processRequest(request);
				repaint();
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
		JFrame frame = new JFrame("Coda Stampanti");
		frame.setSize(650, 780);
		frame.setLocation(100, 20);
		frame.setResizable(false);
		frame.setContentPane(new MainCodaStampanti());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
