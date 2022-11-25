package model;

public class Fruity extends Plant {

    private String fruit;

    public Fruity(String name, double cost, String fruit, String id){
        super(name, cost, id);

        this.fruit = fruit;

    }
    
    
}
