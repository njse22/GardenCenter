package model;

public class Frutal extends Plant {
    private String nameFrut;
    
    public Frutal(String name, double cost, String nameFrut){
        super(nameFrut, cost);
        this.nameFrut=nameFrut;
    }
    public String getNameFrut(){
        return this.nameFrut;
    }
}
