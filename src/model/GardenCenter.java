package model;

import java.lang.Math;
import java.util.ArrayList;

public class GardenCenter{

    private String name; 
    private String direcction;
    private int[][] matrix;
    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;

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
     * @return the direcction
     */
    public String getDirecction() {
        return direcction;
    }

    /**
     * @param direcction the direcction to set
     */
    public void setDirecction(String direcction) {
        this.direcction = direcction;
    }

    /**
     * @return the plants
     */
    public Plant[][] getPlants() {
        return plants;
    }

    /**
     * @param plants the plants to set
     */
    public void setPlants(Plant[][] plants) {
        this.plants = plants;
    } 

    public String generateID(){
        initMatrix();
        String id = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i%2==0){
                    if(j%2==0){
                        id+= matrix[i][j];
                    }
                }
                if(i%2!=0){
                    if(j%2!=0){
                        id+= matrix[i][j];
                    }
                }
            }
        }
        return id;
    }
    public void initMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j]=(int)(Math.random()*9);
            }
        }
    }
    

}