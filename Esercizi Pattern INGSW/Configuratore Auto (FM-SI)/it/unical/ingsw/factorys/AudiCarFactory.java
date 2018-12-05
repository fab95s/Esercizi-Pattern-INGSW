package it.unical.ingsw.factorys;

import it.unical.ingsw.interfaces.CarConfigurator;

public class AudiCarFactory implements CarConfigurator {
	private static CarConfigurator instance = null;
	
	private AudiCarFactory() {}
	
	public static AudiCarFactory getInstance() {
		if(instance == null) {
			instance = new AudiCarFactory();
		}
		return (AudiCarFactory) instance;
	}
	
	@Override
	public Component makeGearbox() {
		return new Component("Audi", "Cambio Marce", 69.90);
	}
	
	@Override
	public Component makeSeat() {
		return new Component("Audi", "Sedile", 250.00);
	}
	
	@Override
	public Component makeBearing() {
		return new Component("Audi", "Cuscinetti", 9.90);
	}
	
}
