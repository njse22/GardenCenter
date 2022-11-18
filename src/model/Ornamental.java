package model;

public class Ornamental extends Plant{
    
    private double height;

    public Ornamental(double height, String name, double cost){
        super(name, cost);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;

    }
}
