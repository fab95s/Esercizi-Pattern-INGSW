package it.unical.ingsw.interfaces;

import it.unical.ingsw.objects.NecessaryGood;
import it.unical.ingsw.objects.Tobacco;

public interface GoodVisitor {
	public double visit(NecessaryGood good);
	public double visit(Tobacco good);
}
