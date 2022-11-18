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
        this.plantsList = new ArrayList<>();
        this.plants = new Plant [12][6];
    }




    public String addPlantFruitTrees(String name, double cost, String nameOfFruString){
        String msj = "Se ha añadido exitosamente";
        if(plantsList.add(new FruitTrees(name, cost, nameOfFruString)) == true){
            return msj;
        }else{
            System.out.println("Error");
        }
        return msj;
        
    }

    public String addPlantOrnamentals(String name, double cost, double height){
        String msj = "Se ha añadido exitosamente";
        if(plantsList.add(new Ornamentals(name, cost,height)) == true){
            return msj;
        }else{
            System.out.println("Error");
        }
        return msj;
    }

    public String listPlantsHeight(){
        String msj = "Estas son las plantas que miden mas de un metro: ";
        for(int i =0; i<plantsList.size(); i++){
            if(Ornamentals.getHeight() >= 1 ){
                msj += Plant.getName();
            }
        }
        return msj;
    }

    public String listPlants(){
        String msj = "";
        for(int i =0; i <plantsList.size(); i++){
            msj += Plant.getName();
        }
        return msj;
    }


    /**
     * @return the name
     */
    public String getName(){

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