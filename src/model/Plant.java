package model;

import java.util.Random;

public abstract class Plant {

    public static final int ROWS = 4;
    public static final int COLUMS = 4;

    private String name; 
    private double cost;
    private String id;

    private int[][] codes;
    private Random random;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        random =  new Random();
        codes = new int[ROWS][COLUMS];
        id = getNewId();
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

    public String getId(){
        return id;
    }

    public void fillMatrixNumbers(){
        for(int i = 0; i < codes.length; i++){
            for(int j =0; j< codes.length; j++){
                codes[i][j] = random.nextInt(9-0+1)+0;
            }
        }
    }

    public String getNewId(){
        String msj = "";
        for(int i = 0; i < codes.length; i++){
            if(codes.length%2 == 0){
                msj += codes[0][i];
            }
        }

        for(int j = codes.length -3; j >= 0; j++){
            if(codes.length%2 != 0){
                msj += codes[1][j];
            }
        }

        for(int z = codes.length -2; z >= 0; z++){
            if((codes.length%2) == 0){
                msj += codes[2][z];
            }
        }

        for(int w = codes.length -1; w >= 0; w++){
            if(codes.length%2 != 0){
                msj += codes[3][w];
            }
        }

        return msj;
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
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + "]";
    } 

    
    

}
