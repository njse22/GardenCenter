package model;

public class Frutal extends Plant {

    private String nameFruto;

    public Frutal(String nameFruto,String name,double cost ){
        super(name, cost);
        this.nameFruto = nameFruto;
    }

    public String getNameFruto(){
        return nameFruto;
    }

    public void setNameFruto(String nameFruto){
        this.nameFruto = nameFruto;
    }
    

}
