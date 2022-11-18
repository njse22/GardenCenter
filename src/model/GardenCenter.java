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
        this.name = name;
        this.direcction = direcction;
        plants = new Plant[ROWS][COLUMNS];
        plantsList = new ArrayList<Plant>(10);
    }

    public boolean validateCorrectOption(int numprueba){
        boolean isCorrect = false;
        if(numprueba >= 1 && numprueba <= 2){
            isCorrect = true;
        }
        return isCorrect;
    }

    public String addFrutalPlant(String plantName, double plantCost, String plantFrutsName){
        String msj = "";
        Frutal newFrutalPlant = new Frutal(plantName, plantCost, plantFrutsName);
        if(validateNameExists(plantName) == -1){
            plantsList.add(newFrutalPlant);
            msj = "The plant was added succesfully \n" +
                  "Code: " + newFrutalPlant.getCode();
        }else{
            msj = "There's already another Plant with this name";
        }
        return msj;
    }

    public String addOrnamentalPlant(String plantName, double plantCost, int size){
        String msj = "";
        Ornamental newOrnamentalPlant = new Ornamental(plantName, plantCost, size);
         if(validateNameExists(plantName) == -1){
            plantsList.add(newOrnamentalPlant);
            msj = "The plant was added succesfully \n" +
                  "Code: " + newOrnamentalPlant.getCode();
        }else{
            msj = "There's already another Plant with this name";
        }
        return msj;
    }

    public int validateNameExists(String plantName){
        int pos = -1;
        for(int i = 0; i < plantsList.size(); i++){
            if(plantsList.get(i) != null){
                if((plantsList.get(i).getName().equalsIgnoreCase(plantName))){
                    pos = i;
                }
            }
        }
        return pos;
    }

    public String listHighOrnamentals(){
        String msj = "";
        for(int i = 0; i < plantsList.size(); i++){
                if(plantsList.get(i) != null){
                    if(plantsList.get(i) instanceof Ornamental){
                        if(((Ornamental)(plantsList.get(i))).getSize() >1){
                            msj += ((Ornamental)(plantsList.get(i))).toString() + "Size: " + ((Ornamental)(plantsList.get(i))).getSize() + " mts";
                        }
                    }
                }
        }
    return msj;
    }

//------------------------------------ Getters and setters-----------------------------------------

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

}