package model;

public class Ornamental extends Plant{

	private double height;

	public Ornamental(String name, double cost,String id, double height){
		super(name,cost,id);
		this.height = height;
	}

	public double getHeight(){
		return height;
	}
}