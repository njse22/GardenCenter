package model;


public class Frutal extends Plant{

    protected String fruit;

    public Frutal(String name, double cost, String fruit){
        super(name, cost);
        this.fruit = fruit; 
    }
        

}

