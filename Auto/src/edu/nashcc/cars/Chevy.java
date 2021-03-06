package edu.nashcc.cars;

public class Chevy extends Auto {

	private String model;
	public Chevy() {
		super("Chevy");
	}
	public void setPrice(int price){
		this.price = price; 
	}
	public String modelOptions(){
		StringBuilder sb = new StringBuilder();
		sb.append("1 - Camaro\n");
		sb.append("2 - Cavalier\n");
		
		return sb.toString();
	}
	public void setModel(String choice){
		switch(choice){
		case "1":
			this.model = "Camaro";
			setPrice(25000);
			break;
		case "2":
			this.model = "Cavalier";
			setPrice(15000);
			break;
		default:
			this.model = "";
		}
	}
	public String getModel(){
		return model;
	}
}