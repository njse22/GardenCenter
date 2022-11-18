package model;

public class OrnamentalPlant extends Plant{

    private double maxHeight;

    public OrnamentalPlant(String name, double cost, double maxHeight){
        super(name, cost);
        this.maxHeight = maxHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

}