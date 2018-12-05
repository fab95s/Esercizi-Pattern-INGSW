package it.unical.ingsw.interfaces;

import it.unical.ingsw.factory.Car;

public interface CarStrategy {

	public Car configurator(Car c);
}
