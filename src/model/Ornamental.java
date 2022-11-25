package model;

public class Ornamental extends Plant {

    private double height;
    protected String id;



    public Ornamental(String name, double cost, double height, String id){        
        super(name, cost, id);


        this.height = height;

    }

    public double getHeight(){
        return this.height;
    }



    
}
