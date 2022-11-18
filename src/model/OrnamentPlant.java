package model;

public class OrnamentPlant extends Plant{

    private double plantHeight;

    public OrnamentPlant(double plantHeight, String name, double cost) {
        super(name, cost);

        this.plantHeight = plantHeight;
        
    }

    public double getPlantHeight(){
        return this.plantHeight;
    }

    public void setPlantHeight(int plantHeight){
        this.plantHeight = plantHeight;
    }
    
}
