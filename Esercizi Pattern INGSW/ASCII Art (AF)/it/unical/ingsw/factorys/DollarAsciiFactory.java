package it.unical.ingsw.factorys;

public class DollarAsciiFactory extends AsciiFactory {
	
	@Override
	public String makeText(String text) {
		return makeFromChar(text, '$');
	}
	
}
