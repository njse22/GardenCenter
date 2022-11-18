package model;

public class Ornamental extends Plant{
    private double maxHeight;

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Ornamental(String name, double cost, double maxHeight){
        super(name, cost);
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return "Plant [" + (getName() != null ? "name= " + getName() + ", " : "") + "cost= " + getCost() + ", Height= "+this.maxHeight+"]";
    } 
}
