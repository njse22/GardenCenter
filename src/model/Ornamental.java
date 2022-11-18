package model;

public class Ornamental extends Plant {
    
    private double height; 

    /**
     * @param name
     * @param cost
     */
    public Ornamental(String name, double cost, double height, String id) {
        super(name,cost,id);
        this.height = height;
       }
    /**
     * @return the name
     */
    public double getHeight() {
        return height;
    }
}