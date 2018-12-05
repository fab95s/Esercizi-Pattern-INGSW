package it.unical.ingsw.factorys;

public class Component {
	private String name;
	private String type;
	private double price;
	
	public Component(final String name, final String type, final double d) {
		this.name = name;
		this.type = type;
		this.price = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
