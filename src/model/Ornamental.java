package model;

public class Ornamental extends Plant{

	private int size;

	public Ornamental(String name, double cost, int size){
		super(name,cost);
		this.size = size;
	}

	public int getSize(){
		return this.size;
	}

	public String getName(){
		return super.name;
	}

}
