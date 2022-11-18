package model;

public class Ornamental extends Plant{
	private double alture;

	public Ornamental(String name, double cost, double alture){
		super(name, cost);
		this.alture = alture;
	}

	public double getAlture(){
		return this.alture;
	}
}