package model;

public class FrutalPlant extends Plant{
    private String fruitName;

    public FrutalPlant(String name, double cost, String fruitName) {
        super(name, cost);
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
