package model;

import java.lang.Math;

public abstract class Plant {

    private String name;
    private double cost;
    private int[][] matrix;
    private int[][] matrix2;
    private int[][] matrix3;
    private String plantCode;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        matrix = new int[4][4];
        matrix2= new int[4][4];
        matrix3= new int[4][4];
        initMatrixCode();
        this.plantCode=createPlantCode();
    }

    public void initMatrixCode() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = ((int) (Math.random() * 9)) + 1;
                matrix2[i][j] = ((int) (Math.random() * 9)) + 1;
            }
        }
    }

    public String printMatrix(){
        String msj = ""; 

        for(int i = 0; i < 4; i++){
            msj += "\n"; 
            for(int j = 0; j < 4; j++){
                msj += matrix[i][j] + " ";
            }
        }
        for(int i = 0; i < 4; i++){
            msj += "\n"; 
            for(int j = 0; j < 4; j++){
                msj += matrix2[i][j] + " ";
            }
        }
        for(int i = 0; i < 4; i++){
            msj += "\n"; 
            for(int j = 0; j < 4; j++){
                msj += matrix3[i][j] + " ";
            }
        }
        return msj; 
    }


    public String createPlantCode() {
        String code="";
        for (int i = 0; i <= 2; i += 2) {
            code += Integer.toString(matrix[0][i]);
        }
        for (int i = 1; i <= 3; i += 2) {
            code += Integer.toString(matrix[1][i]);
        }
        for (int i = 0; i <= 2; i += 2) {
            code += Integer.toString(matrix[2][i]);
        }
        for (int i = 1; i <= 3; i += 2) {
            code += Integer.toString(matrix[3][i]);
        }
        return code;
    }

    public String createBillCode(){
        int value=0;
        String code="";
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                value=matrix[i][j]*matrix2[i][j];
                matrix3[i][j]=value;
            }
        }
        for(int i=0;i<=3;i+=3){
            code += Integer.toString(matrix3[0][i]);
        }
        for(int i=1;i<=2;i++){
            code += Integer.toString(matrix3[1][i]);
        }
        for(int i=1;i<=2;i++){
            code += Integer.toString(matrix3[2][i]);
        }
        for(int i=0;i<=3;i+=3){
            code += Integer.toString(matrix3[3][i]);
        }
        return code;
    }

    public String getPlantCode() {
        return plantCode;
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
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + "]";
    }

}
