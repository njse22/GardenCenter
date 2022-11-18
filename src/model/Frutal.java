package model;

public class Frutal extends Plant{

	private String fruitName;

	public Frutal(String name, double cost,String id, String fruitName){
		super(name,cost,id);
		this.fruitName = fruitName;
	}
}