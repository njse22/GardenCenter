package model;

public class Frutal extends Plant{
    private String fruitName;
    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Frutal(String name, double cost, String fruitName){
        super(name, cost);
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return "Plant [" + (getName() != null ? "name= " + getName() + ", " : "") + "cost= " + getCost() + ", Fruit= "+this.fruitName+"]";
    } 
}

