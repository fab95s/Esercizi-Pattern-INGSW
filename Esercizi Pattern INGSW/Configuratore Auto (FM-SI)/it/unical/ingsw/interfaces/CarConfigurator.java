package it.unical.ingsw.interfaces;

import it.unical.ingsw.factorys.Component;

public interface CarConfigurator {
	public Component makeGearbox();		// Metodo di creazione Cambio
	public Component makeSeat();		// Metodo di creazione Sedile
	public Component makeBearing();		// Metodo di creazione Cuscinetto
}
