package model;
import java.util.Random;

public abstract class Plant {
    
    private static String name; 
    protected double cost;
    Random random = new Random();
    int [][] matrix;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.matrix = new int [4][4];
        generateMatrix();
    }

    //Will fill all the matrix with random numbers
    public void generateMatrix(){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                matrix[i][j] = random.nextInt(9);
            }
        }
    }

    //Will generate the matrix with the spaces (Just for checking)
    public void spacesInTheMatrix(){
        String msj = "";
        for(int i =0; i< matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                msj += " " +  matrix [i] [j];
            }
            msj += "\n";
        }
    }

    //Will get the id as in the Statement
    public String calculateId(){
        String msj = "";
        for(int i =matrix.length-1; i>=0; i--){
            for(int j = matrix.length-1; j>=0; j--){
                if((((i+j)%2)!=0) && ( (i+j) > 1 )){
                    msj += matrix[i][j];                       
                }
            }
        }
        return msj;
    }


    /**
     * @return the name
     */
    public static String getName() {
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
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + "]";
    } 

    
    

}
