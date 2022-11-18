package model;

public class Frutal extends Plant {

    private String nameFruit;

    public Frutal(String name, double cost, String nameFruit) {
        super(name, cost);
        this.nameFruit = nameFruit;

    }

    /**
     * @return String return the nameFruit
     */
    public String getNameFruit() {
        return nameFruit;
    }

    /**
     * @param nameFruit the nameFruit to set
     */
    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

}