package model;

public class OrnamentalPlant extends Plant{
    private double height;
    public OrnamentalPlant(String name, double cost,double height){
        super(name, cost);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    
}
