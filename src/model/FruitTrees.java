package model;

public class FruitTrees extends Plant {
    private String nameOfFruit;
    
    public FruitTrees(String name, double cost, String nameOfFruit){
        super(name, cost);
        this.nameOfFruit = nameOfFruit;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }
    
}
