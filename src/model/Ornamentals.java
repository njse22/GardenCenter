package model;

public class Ornamentals extends Plant {
    private static double height;

    public Ornamentals(String name, double cost, double height){
        super(name, cost);
        this.height = height;
    }

    public static double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
}
