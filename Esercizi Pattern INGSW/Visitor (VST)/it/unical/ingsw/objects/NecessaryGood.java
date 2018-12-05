package it.unical.ingsw.objects;

import it.unical.ingsw.interfaces.Good;
import it.unical.ingsw.interfaces.GoodVisitor;

public class NecessaryGood implements Good {

	@Override
	public void accept(GoodVisitor visitor) {
		visitor.visit(this);
	}

}
