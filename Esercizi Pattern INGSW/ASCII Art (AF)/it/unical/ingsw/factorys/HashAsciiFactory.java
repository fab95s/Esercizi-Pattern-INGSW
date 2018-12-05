package it.unical.ingsw.factorys;

public class HashAsciiFactory extends AsciiFactory {
	
	@Override
	public String makeText(String text) {
		return makeFromChar(text, '#');
	}
	
}
