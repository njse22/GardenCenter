package model;

import java.util.ArrayList;

public class GardenCenter{

    private ArrayList<Plant> plants;
    private String name; 
    private String direcction;

    private Plant[][] plantsMatrix;


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        this.plants = new ArrayList<Plant>();

    }

    public Plant searchPlant(String name){
        boolean isFound = false;
        Plant plant = null;

        for(int i=0; i < plants.size() && !isFound; i++){
            if(plants.get(i).getName().equalsIgnoreCase(name)){
                plant = plants.get(i);
                isFound = true;
            }
        }
        return plant;
    }

    public String addOrnamentalPlant(String name, double cost, double mts){
        String msgConfirmation = null;
        plants.add(new Ornamental(name,cost,mts));
        msgConfirmation = "\nSe ha agregado la planta ornamental correctamente.\n";
        return msgConfirmation;
    }

    public String addFruitPlant(String name, double cost, String givesFruit){
        String msgConfirmation = null;
        plants.add(new Fruit(name,cost, givesFruit));
        msgConfirmation = "\nSe ha agregado la planta frutal correctamente.\n";
        return msgConfirmation;
    }

    public Plant searchCalculateMts(double mts){
        boolean isFound = false;
        Plant plantCounter = null;

        for(int i=0; i < plants.size() && !isFound; i++){
            if(plants.get(i).getMts()){
                plantCounter = plants.get(i++);
                isFound = true;
            }
        }
        return plantCounter;
    }

    public void initPlants(Plant[][] plantsMatrix) {
		plantsMatrix = new Plant[plantsMatrix.length][plantsMatrix[0].length];
		int count = 0; 
		for (int i = 0; i < plantsMatrix.length; i++) {
			for (int j = 0; j < plantsMatrix[0].length; j++) {
				if(!plantsMatrix[i][j].equals(" ")){
					count++; 
						
				}
				else{
					System.out.println("\nMatriz creada e inicializada con exito.");
				}
			}
		}
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
        return plantsMatrix;
    }

    /**
     * @param plants the plants to set
     */
    public void setPlants(Plant[][] plantsMatrix) {
        this.plants = plants;
    } 

    

}