package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{

    private String name; 
    private String direcction;

    private Plant [][] plantss;
    private ArrayList<Plant> plants; 
    public static final int ROWS = 12;
    public static final int COLUMNS = 6;


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;

        plants = new ArrayList<Plant>(10);

    }

    public int[][] createMatrix(){
        
        int matrix[][] = new int[4][4];
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; i < COLUMNS; i++){
                matrix[i][j] = generateNumber();
            }
        }

        return matrix;
    }

    public int generateNumber(){
        int number = 0;
        Random random = new Random();
        number = (int)(random.nextInt()*9) + 0;

        return number;
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
    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public Plant[][] getPlantss() {
        return plantss;
    }


    

    public String addPlant(String plantName, double cost, double plantHeight, String fruitName, TypeOfPlant typeOfPlant){
        String msj = "";

        switch(typeOfPlant){
            case ORNAMENT:
            plants.add(new OrnamentPlant(plantHeight, plantName, cost));
            msj = "Ornament plant added successfully";
            break;
            case FRUITY:
            plants.add(new FruityPlant(fruitName, plantName, cost));
            msj = "Fruity plant added successfully";
            break;
        }

        return msj;
    }

    

}