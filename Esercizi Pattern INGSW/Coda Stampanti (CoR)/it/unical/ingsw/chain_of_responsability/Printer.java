package it.unical.ingsw.chain_of_responsability;

import java.util.Random;

public class Printer extends PrinterService implements Runnable {
	private Random rand = new Random();
	
	public Printer(int num, int x, int y) {
		this.name = "Printer " + (num + 1);
		this.posx = x;
		this.posy = y;
		this.setMemory();
		this.setActive();
	}

	@Override
	protected void setMemory() {
		memory = rand.nextInt(20) + 5;
	}

	@Override
	protected void setActive() {
		active = rand.nextBoolean();
	}

	@Override
	public void run() {
		while(true) {
			active = rand.nextBoolean();
			try {
				Thread.sleep(rand.nextInt(5000) + 2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
