package edu.nashcc.candle;

public class Candle {
	protected String color;
	protected int height;
	protected double price;
	
	protected Candle(){
		// prevents empty object instantiation
	}
	public Candle(String color, int height){
		this.color = color;
		this.height = height;
		setPrice(height);
	}
	
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return this.color;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setPrice(int height){
		this.price = 2 * height; // $2/inch
	}
	public double getPrice(){
		return this.price;
	}
}
