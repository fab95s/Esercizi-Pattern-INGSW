package it.unical.ingsw.objects;

import it.unical.ingsw.interfaces.GoodVisitor;

public class GoodTaxVisitor implements GoodVisitor {

	@Override
	public double visit(NecessaryGood good) {
		return 0.21;
	}

	@Override
	public double visit(Tobacco good) {
		return 0.3;
	}

}
