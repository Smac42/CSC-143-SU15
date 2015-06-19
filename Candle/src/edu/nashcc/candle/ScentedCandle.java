package edu.nashcc.candle;

public class ScentedCandle extends Candle {
	private String scent;
	
	private ScentedCandle(String color, int height, String scent){
		super(color, height);
		this.scent = scent;
		super.setPrice(height);
	}
	
	public void setScent(String scent){
		this.scent = scent;
	}
	public String getScent(){
		return this.scent;
	}
	public void setPrice(double Height){
		super.setPrice(height);
	}
}
