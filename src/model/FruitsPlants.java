package model;

public class FruitsPlants extends Plant{
    private String fruitName;
    public FruitsPlants(String name, double cost, String fruitName){
        super(name, cost);
        this.fruitName=fruitName;

    }   
}