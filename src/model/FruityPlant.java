package model;

public class FruityPlant extends Plant{
    private String fruitName;
    public FruityPlant(String name, double cost,String fruitName){
        super(fruitName, cost);
        this.fruitName = fruitName;
    }
    public String getFruitName() {
        return fruitName;
    }
    
}
