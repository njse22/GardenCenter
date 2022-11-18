package model;

public class Ornamental extends Plant {
    private double maxHeight;

    public Ornamental(String name, double cost, double maxHeight) {
        super(name, cost);
        this.maxHeight = maxHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

}
