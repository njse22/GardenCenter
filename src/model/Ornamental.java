package model;

public class Ornamental extends Plant {

    private double mts;

    public Ornamental(String name, double cost, double mts) {
        super(name, cost);

        this.mts = mts;
    }

    public void setMts(double mts){
        this.mts = mts;
    }

}
