package model;

import java.util.Random;

public abstract class Plant {
    
    protected String name; 
    private double cost;
    private String code;
    private int[][] matrixCode;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        matrixCode = new int[4][4];
        this.code = generateCode();
    }

     public int[][] fillMatrix(){
        Random aleatorio = new Random();
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                this.matrixCode[i][j] = (aleatorio.nextInt(10-0)+0);
            }
        }
        return matrixCode;
    }

    public String generateCode(){
        String autoCode = "";
        int[][] matrixFilled = fillMatrix();
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j<= 3; j++){
                if(j%2 == 0){
                    autoCode += "" + matrixFilled[i][j];
                }
            }
        }
        return autoCode;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Plant [" + "name=" + name + ", " + "cost=" + cost + "]";
    } 

     public String getCode(){
        return this.code;
    }


}
