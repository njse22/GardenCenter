package model;

import java.util.ArrayList;

public class GardenCenter{
    public static final int ROWS = 12; 
    public static final int COLUMNS = 6;

    private String name; 
    private String direcction;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.plants = new Plant[ROWS][COLUMNS];
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

    public int searchPlant(String plantName){
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i<ROWS && !isFound; i++){
            for (int j = 0; j<COLUMNS && !isFound; j++){
                if (plants[i][j] != null){
                    if (plants[i][j].getName().equals(plantName)){
                        pos = 2;
                        isFound = true;
                    }
                }
                
            }
        }
        return pos;
    }

    public String plantRegister(int option, String plantName, double plantCost, String fruitName, double alture){
        String msj = "";
        Plant newPlant = null;
        switch(option){
            case 1:
                newPlant = new Fruity(plantName, plantCost, fruitName);
                msj = addPlant(option, newPlant);
                break;
            case 2:
                newPlant = new Ornamental(plantName, plantCost, alture);
                msj = addPlant(option, newPlant);
                break;
            default:
                msj = "Invalid Option.";
                break;
        }
        
        return msj;
    }

    public String addPlant(int option, Plant newPlant){
        String msj = "Maximum capacity reached.";
        boolean isAdded = false;
        switch(option){
            case 1:
                for (int i = 0; i<ROWS && i%2 != 0 && !isAdded; i++) {
                    for (int j = 0; j<COLUMNS && !isAdded; j++) {
                        if(plants[i][j] == null){
                            isAdded = true;
                            plants[i][j] = newPlant;
                            msj = "New fruit plant added.\n" +
                                newPlant.toString();
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i<ROWS && i%2 == 0 && !isAdded; i++) {
                    for (int j = 0; j<COLUMNS && !isAdded; j++) {
                        if(plants[i][j] == null){
                            isAdded = true;
                            plants[i][j] = newPlant;
                            msj = "New ornamental plant added.\n" +
                            newPlant.toString();
                        }
                    }
                }
                break;
        }

        return msj;
    }

    public String printOrnamentalPlants(){
        String msj = "<<< Ornamental Plants >>>\n";
        for(int i = 0; i<ROWS; i++){
            for (int j = 0; j<COLUMNS; j++){
                if(plants[i][j] instanceof Ornamental && plants[i][j] != null){
                    double alture = (( Ornamental ) ( plants[i][j] )).getAlture();
                    if (alture > 1.0){
                        msj += plants[i][j].toString() + "\n";
                    }
                }
            }
            
        }
        return msj;
    }

}