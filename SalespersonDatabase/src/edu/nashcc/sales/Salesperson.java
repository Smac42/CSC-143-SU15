package edu.nashcc.sales;

public class Salesperson {
	String ID;
	double sales;
	
	
	public Salesperson(String iD, double sales) {
		this.ID = iD;
		this.sales = sales;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}	
}
