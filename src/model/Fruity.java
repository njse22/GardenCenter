package model;

public class Fruity extends Plant{
    private String nameFruit;

    public Fruity(String name, double cost, String nameFruit) {
        super(name, cost);
        this.nameFruit = nameFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }
}
