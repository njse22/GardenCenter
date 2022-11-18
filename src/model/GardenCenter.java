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
        this.plants = new Plant[12][6];
        this.plantsList = new ArrayList<>(this.plants.length*this.plants[0].length);

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

    public String addPlant(String name, double cost, String nameFruit, double height){
        String msj = "";
        boolean wasFound = false;
        for (int i = 0; i < plantsList.size() && !wasFound; i++) {
            if(plantsList.get(i) != null && plantsList.get(i).getName().equalsIgnoreCase(name)){
                wasFound = true;
            }
        }
        if(!wasFound){

            if(height == 0){
                // Fruity
                Fruity fruity = new Fruity(name, cost, nameFruit);

                // Array

                for (int i = 0; i < plants.length; i+=2) {
                    for (int j = 0; j < plants[0].length && !wasFound ;j++) {
                        if(this.plants[i][j] == null){
                            wasFound = true;
                            this.plants[i][j] = fruity;
                        }
                    }
                }
                // ArrayList
                plantsList.add(fruity);


            }else{
                // Ornamental
                Ornamental ornamental = new Ornamental(name, cost, height);
                // Array
                for (int i = 1; i < plants.length; i+=2) {
                    for (int j = 0; j < plants[0].length && !wasFound  ;j++) {
                        if(this.plants[i][j] == null){
                            wasFound = true;
                            this.plants[i][j] = ornamental;
                        }
                    }
                }
                // ArrayList
                plantsList.add(ornamental);
            }
            /*
            Print arrau for review
            for (Plant[] plant : plants) {
                for (int j = 0; j < plants[0].length; j++) {
                    if ( plant[j] != null ){
                        System.out.print(plant[j].getName() + " ");
                    }
                    else {
                        System.out.print("null ");
                    }
                }
                System.out.println(" ");
            }

             */

        }else{
            msj = "There is already that name of plant";
        }
        return msj;
    }
    public String listOrnamentalPlants(){
        StringBuilder msj = new StringBuilder();
        String msj2 = "";
        for (Plant plant : plantsList) {
            if ( plant instanceof Ornamental && ((Ornamental) plant).getHeight() > 1 ){
                msj.append("Name: ").append(plant.getName()).append(" Height: ").append(((Ornamental) plant).getHeight()).append("\n");
            }
        }
        return msj.toString();
    }

    public String sellPlant(String namePlant){
        StringBuilder msj = new StringBuilder();
        boolean wasFound = false;
        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[0].length && !wasFound; j++) {
                if ( plants[i][j] != null && plants[i][j].getName().equalsIgnoreCase(namePlant) ){
                    wasFound = true;
                    plants[i][j] = null;
                }
            }
        }
        if (wasFound){
            plantsList.removeIf(plant -> plant != null && plant.getName().equalsIgnoreCase(namePlant));
            msj.append("Removed plant");
            int[][] matrixOne = new int[4][4];
            int[][] matrixTwo = new int[4][4];
            int[][] matrixThree = new int[4][4];

            for (int i = 0; i < matrixOne.length; i++) {
                for (int j = 0; j < matrixOne[0].length; j++) {
                    matrixOne[i][j] = (int) (Math.random()*10);
                    matrixTwo[i][j] = (int) (Math.random()*10);
                    matrixThree[i][j] = matrixOne[i][j] * matrixTwo[i][j];
                }
            }

            for (int i = 0; i < matrixThree.length; i++) {
                msj.append(matrixThree[i][i]);
            }
            for (int i = 3; i > -1; i--) {
                msj.append(matrixThree[i][i]);
            }
        }else{
            msj.append("Plant not found");
        }




        return msj.toString();
    }

    public String showPlants(){
        StringBuilder msj = new StringBuilder();
        for (Plant[] plant : plants) {
            for (int j = 0; j < plants[0].length; j++) {
                if ( plant[j] != null ){
                    msj.append(plant[j].getName()).append(" ");
                }
                else {
                    msj.append("Empty ");
                }
            }
            msj.append("\n");
        }
        return msj.toString();
    }

}