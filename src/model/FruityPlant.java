package model;

public class FruityPlant extends Plant{

    private String fruitName;

    public FruityPlant(String name, double cost, String fruitName){
        super(name, cost);
        this.fruitName = fruitName;
    }
}
