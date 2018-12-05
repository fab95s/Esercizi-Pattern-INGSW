package it.unical.ingsw.main;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import it.unical.ingsw.factorys.AsciiFactory;
import it.unical.ingsw.factorys.HashAsciiFactory;

@SuppressWarnings("serial")
public class MainAsciiArt extends JFrame {
	AsciiFactory factory = new HashAsciiFactory();
	JTextField field = new JTextField();
	ButtonGroup group = new ButtonGroup();
	JRadioButton hash = new JRadioButton("HashAscii");
	JRadioButton asterisk = new JRadioButton("AsteriskAscii");
	JRadioButton dollar = new JRadioButton("DollarAscii");
	String draw = "";
	
	public MainAsciiArt() {
		super();
		initGUI();
		initEH();
	}
	
	private void checkButtons() {
		Enumeration<AbstractButton> elem = group.getElements();
		while(elem.hasMoreElements()) {
			AbstractButton btn = elem.nextElement();
			if(btn.isSelected()) {
				try {
					factory = (AsciiFactory) Class.forName("it.unical.ingsw.factorys." + btn.getText() + "Factory").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private void initGUI() {
		this.setTitle("ASCII Art");
		this.setSize(600, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		hash.setSelected(true);
		group.add(hash);
		group.add(asterisk);
		group.add(dollar);
		
		this.add(field, BorderLayout.NORTH);
		this.add(hash, BorderLayout.WEST);
		this.add(asterisk, BorderLayout.CENTER);
		this.add(dollar, BorderLayout.EAST);
	}
	
	private void initEH() {
		field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkButtons();
					draw = factory.makeText(field.getText());
					System.out.println(draw);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new MainAsciiArt().setVisible(true);
	}
	
}
