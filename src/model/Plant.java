package model;
import java.util.Random;

public abstract class Plant {
    
    private String name; 
    private double cost;
    private int[][] matrix;
    private String code;
    private Random random;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.random = new Random();
        this.matrix = initializeMatrix();
        this.code = generateCode(matrix);
    }

    public int[][] initializeMatrix(){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public String generateCode(int[][] matrix){
        String code = "";
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if((i+j)%2 == 0){
                    code += String.valueOf(matrix[i][j]);
                }
            }
        }
        return code;
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
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + "]";
    } 

}
