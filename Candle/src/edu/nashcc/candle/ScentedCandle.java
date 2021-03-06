package edu.nashcc.candle;

public class ScentedCandle extends Candle {
	private String scent;
	
	public ScentedCandle(String color, int height, String scent){
		super(color, height);
		setScent(scent);
		setPrice(height);
	}
	
	public void setScent(String scent){
		this.scent = scent;
	}
	public String getScent(){
		return this.scent;
	}
	protected void setPrice(int height){
		super.setPrice(height);
		this.price = 3 * height; // $3/inch
		}
}
