package model;

public class Ornamental extends Plant {

	private double height;

    public Ornamental(int type, String name, double cost, double height) {
        super(type, name, cost);

        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}