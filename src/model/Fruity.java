package model;

public class Fruity extends Plant{
	private String nameFruit; 

	public Fruity(String name, double cost, String id,  String nameFruit){
		super(name, cost, id);
		this.nameFruit = nameFruit;
	}
	 public String getNameFruit() {
        return nameFruit;
    }

}  