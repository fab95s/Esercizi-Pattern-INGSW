package it.unical.Abstract;

import java.awt.Graphics;
import java.awt.Image;

import it.unical.Interface.Implementor;

public abstract class Component{
	
	protected Implementor imp;
	
	protected Component(Implementor imp) {
		this.imp = imp;
	}
	
	public abstract void make(Graphics g);
	public abstract Image getImage();
	public abstract void edit_Price(int price);

}
