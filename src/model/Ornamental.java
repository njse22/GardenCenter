package model;

public class Ornamental extends Plant {

    private double height;

    public Ornamental(String name, double cost, double height) {
        super(name, cost);
        this.height = height;
    }

    /**
     * @return double return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

}
