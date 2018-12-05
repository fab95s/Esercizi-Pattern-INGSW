package it.unical.ingsw.factorys;

import it.unical.ingsw.interfaces.CarConfigurator;

public class VolkswagenCarFactory implements CarConfigurator {
	private static CarConfigurator instance = null;
	
	private VolkswagenCarFactory() {}
	
	public static VolkswagenCarFactory getInstance() {
		if(instance == null) {
			instance = new VolkswagenCarFactory();
		}
		return (VolkswagenCarFactory) instance;
	}

	@Override
	public Component makeGearbox() {
		return new Component("Volkswagen", "Cambio Marce", 59.90);
	}
	
	@Override
	public Component makeSeat() {
		return new Component("Volkswagen", "Sedile", 300.00);
	}
	
	@Override
	public Component makeBearing() {
		return new Component("Volkswagen", "Cuscinetti", 8.90);
	}
	
}
