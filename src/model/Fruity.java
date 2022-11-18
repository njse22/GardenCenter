package model;

public class Fruity extends Plant{
	private String fruitName;

	public Fruity(String name, double cost, String fruitName){
		super(name, cost);
		this.fruitName = fruitName;
	}
}