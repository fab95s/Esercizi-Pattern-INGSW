package it.unical.ingsw.chain_of_responsability;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class PrinterService {
	Image printer = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/printer.png"));
	
	protected String name;
	protected int memory;
	protected boolean active;
	protected boolean printed = false;
	protected PrinterService successor;
	
	protected int posx = 0;
	protected int posy = 0;
	
	abstract protected void setMemory();
	abstract protected void setActive();
	
	public void setSuccessor(PrinterService successor) {
		this.successor = successor;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		if(printed) {
			g.setColor(Color.RED);
		}
		g.drawString(name, posx + 8, posy);
		g.drawImage(printer, posx + 5, posy, 54, 54, null);
		g.setColor(Color.GREEN);
		if(active) {
			g.setColor(Color.RED);
		}
		g.fillOval(posx + 22, posy + 64, 20, 20);
	}
	
	public void processRequest(PrintRequest request) {
		if(!active & request.getMemory() < memory) {
			printed = true;
			System.out.println(name + ": " + request.getMessage());
		} else if(successor != null) {
			successor.processRequest(request);
		} else {
			System.out.println("Nessuna stampante ha potuto effettuare la stampa.");
		}
	}
}
