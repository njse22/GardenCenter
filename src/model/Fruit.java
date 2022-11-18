package model;

public class Fruit extends Plant {
	private String fruit;

    public Fruit(int type, String name, double cost, String fruit) {
        super(type, name, cost);

        this.fruit = fruit;
    }


    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

}