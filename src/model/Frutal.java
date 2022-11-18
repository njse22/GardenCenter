package model;

public class Frutal extends Plant{
    private String fruitName;
    public Frutal(String name, double cost, String fruitName){
        super(name, cost);
        this.fruitName = fruitName;
    }
}

