package model;

public class Fruit extends Plant {
    private String fruitName;
    public Fruit(String name, double cost, String fruitName) {
        super(name, cost);
        this.fruitName = fruitName;
    }

}
