package model;
import java.util.Random;

public abstract class Plant {
    public static final int ROWS = 4; 
    public static final int COLUMNS = 4;
    
    private String name; 
    private double cost;
    private int[][] idMatrix;
    private String id;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        idMatrix = new int[ROWS][COLUMNS];
        createRandomMatrix();
        this.name = name;
        this.cost = cost;
        this.id = generateId();
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
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + ", id=" + id + "] \n" +
        getMatrix();
    } 

    public void createRandomMatrix(){
        Random r = new Random();
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                this.idMatrix[i][j] = r.nextInt(9)+1;
            }
        }
    }

    public String getMatrix(){
        String msj = "";
        for (int i = 0; i < ROWS; i++){
            msj += "\n";
            for (int j = 0; j < COLUMNS; j++){
                msj += this.idMatrix[i][j] + " ";
            }
        }
        return msj;
    }
    
    
    public String generateId(){
        String id = "";
       
        for (int i = 0; i<ROWS; i++) {
            for (int j = 0; j<COLUMNS; j++) {
                if ( (((i+j)%2) == 0) ){
                        id += this.idMatrix[i][j];
                }
            }
        }
        
        return id;
    }
}
