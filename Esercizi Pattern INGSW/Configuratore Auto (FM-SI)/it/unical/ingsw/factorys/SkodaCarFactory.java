package it.unical.ingsw.factorys;

import it.unical.ingsw.interfaces.CarConfigurator;

public class SkodaCarFactory implements CarConfigurator {
	private static CarConfigurator instance = null;
	
	private SkodaCarFactory() {}
	
	public static SkodaCarFactory getInstance() {
		if(instance == null) {
			instance = new SkodaCarFactory();
		}
		return (SkodaCarFactory) instance;
	}

	@Override
	public Component makeGearbox() {
		return new Component("Skoda", "Cambio Marce", 49.90);
	}
	
	@Override
	public Component makeSeat() {
		return new Component("Skoda", "Sedile", 190.00);
	}
	
	@Override
	public Component makeBearing() {
		return new Component("Skoda", "Cuscinetti", 7.90);
	}
	
}
