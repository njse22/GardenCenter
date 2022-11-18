package model;

import java.util.ArrayList;

public class GardenCenter{

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

    public Plant searchPlant(String name){
        Plant plant = null;
        boolean isFound = false;

        for(int i = 0; i < plantsList.size() && !isFound; i++){
            if(plantsList.get(i).getName().equalsIgnoreCase(name)){
                plant = plantsList.get(i);
                isFound = true;
            }
        }
    }

    public String addPlantFruit(String name, double cost, String fruit){
        
        String msj = "";
        Plant plant = searchPlant(name);
        /**Plant[][] plants;

        plants = new Plant[garden.lenght][garden[0].lenght];
        int count = 0;
        */

        if(plant != null){
            msj = "Este nombre de planta ya existe :c ";
        }else{
            
            /**
            for(int i = 0; i < garden.lenght; i++){
            }
            */
            
            Plant newPlant = new Frutal(name, cost, fruit);
            plants.add(newPlant);
            msj = "Nueva fruta añadida :p";
        }
        return msj;
    }

    public String addPlantOrnamental(String name, double cost, double height){
        
        String msj = "";
        Plant plant = searchPlant(name);
 
        if(plant != null){
            msj = "Este nombre de planta ya existe :c ";
        }else{

            Plant newPlant = new Ornamental(name, cost, height);
            plants.add(newPlant);
            msj = "Nueva fruta añadida :p";
        }
        return msj;
    }


}