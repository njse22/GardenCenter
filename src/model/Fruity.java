package model;

public class Fruity extends Plant{
	
	private String fruitName;

	public Fruity(String name, double cost, String fruitName){
		super(name,cost);
		this.fruitName = fruitName;
	}

	public String getFruitName(){
		return this.fruitName;
	}

	public void setFruitName(String fruitName){
		this.fruitName = fruitName;
	}

	@Override
	public String toString(){
		return "Frutal: "+ getName() + " - Costo: " + getCost() + " - Nombre del fruto: " + this.fruitName;
	}
}