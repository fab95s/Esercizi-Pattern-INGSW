package it.unical.ingsw.memento;

public class ShapeMemento {
	private Shape state = new Shape();
	
	public ShapeMemento(Shape state) {
		this.state = state;
	}
	
	public Shape getState() {
		return state;
	}

	public void setState(Shape state) {
		this.state = state;
	}
}
