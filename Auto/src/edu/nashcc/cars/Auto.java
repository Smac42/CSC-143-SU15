package edu.nashcc.cars;

public abstract class Auto {
	protected String make;
	protected double price;
	
	public Auto(String make) {
		this.make = make;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	public abstract void setPrice(int price);
	public double getPrice(){
		return price;
	}
	public abstract String modelOptions();
	public abstract void setModel(String choice);
	public abstract String getModel();
}
