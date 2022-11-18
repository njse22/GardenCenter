package model;

public class Fruit extends Plant {

    private String givesFruit;

    public Fruit(String name, double cost, String givesFruit) {
        super(name, cost);

        this.givesFruit = givesFruit;
    }

    public String getGivesFruit(){
        return givesFruit;
    }

    public void setGivesFruit(String givesFruit){
        this.givesFruit = givesFruit;
    }
    
}
