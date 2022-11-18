package model;

public class OrnamentalsPlants extends Plant{
    private double heightPlant;
    public OrnamentalsPlants(String name, double cost, double heightPlant){
        super(name, cost);
        this.heightPlant=heightPlant;

    }   
    public double getHeightPlant() {
        return heightPlant;
    }
    public void setHeightPlant(double heightPlant) {
        this.heightPlant = heightPlant;
    }
}