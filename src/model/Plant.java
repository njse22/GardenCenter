package model;

import java.util.Random;

public abstract class Plant {
    
    private String name; 
    private double cost;
    private String idCode;
    private Random random;
    private int[][] matrixId;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
      this.name = name;
      this.cost = cost;
      this.idCode = "";
      this.matrixId = new int[4][4];
      fillMatrixId(matrixId);
    }
    
    public void fillMatrixId(int[][] matrixId) {
      random = new Random();
      for (int i = 0; i < matrixId.length; i++) {
        for (int j = 0; j < matrixId.length; j++) {
          matrixId[i][j] = random.nextInt(10);
        }
      }
    }

    public int[][] getMatrixId() {
      return matrixId;
    }

    public void setIdCode(int num) {
      idCode += Integer.toString(num);
    }

    public String getIdCode() {
      return idCode;
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
