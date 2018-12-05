package it.unical.ingsw.factorys;

public class AsteriskAsciiFactory extends AsciiFactory {
	
	@Override
	public String makeText(String text) {
		return makeFromChar(text, '*');
	}
	
}
