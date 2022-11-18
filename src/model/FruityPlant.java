package model;

public class FruityPlant extends Plant {

    private String fruitname;

    public FruityPlant(String fruitname, String name, double cost) {
        super(name, cost);

        this.fruitname = fruitname;
        
    }

    public String getFruitName(){
        return this.fruitname;
    }

    public void setFruitName(String fruitname){
        this.fruitname = fruitname;
    }
    
}
