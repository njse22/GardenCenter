package model;

public class Frutal extends Plant {
    
    private String nameFruit; 

    /**
     * @param name
     * @param cost
     */
    public Frutal(String name, double cost, String nameFruit, String id) {
        super(name,cost,id);
        this.nameFruit = nameFruit;
       }
    /**
     * @return the name
     */
    public String getNameFruit() {
        return nameFruit;
    }
}