package model;

public class Ornamental extends Plant{
    
    private double height;

    public Ornamental(String name, double cost, double height){
        super(name, cost);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }
}
