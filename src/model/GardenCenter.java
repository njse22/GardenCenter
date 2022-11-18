package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{

    private String name; 
    private String direcction;
    private Random random;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        this.plantsList = new ArrayList<Plant>();
        this.plants = new Plant[6][12];
    }

    public String addPlant(boolean isOrnamental, String name, double cost, double height, String fruitName) {
        String msg = "No se ha podido agregar la planta";
        boolean isEmpty = true;
        Plant newPlant;

        if (searchPlantByName(name) != -1) {
            msg = "El nombre de esta planta ya ha sido registrado";
            return msg;
        }

        if (isOrnamental) {
            newPlant = new OrnamentalPlant(name, cost, height);
        } else {
            newPlant = new FrutalPlant(name, height, fruitName);
        }

        newPlant.setCode(generatePlantCode());

        for (int i = 0; i < plants.length && isEmpty == true; i++) {
            for (int j = 0; j < plants[0].length && isEmpty == true; j++) {
                if (plants[i][j] != null && j % 2 != 0 && isOrnamental) {
                    plants[i][j] = newPlant;
                    msg = "Planta Ornamental agregada exitosamente";
                    isEmpty = false;
                } else {
                    plants[i][j] = newPlant;
                    msg = "Planta Frutal agregada exitosamente";
                    isEmpty = false;
                }
            }
        }

        plantsList.add(newPlant);

        return msg;
    }

    public int searchPlantByName(String plantName) {
        int pos = -1;
        boolean isFound = false;

        for (int i = 0; i < plants.length && isFound == false; i++) {
            for (int j = 0; j < plants[0].length && isFound == false; j++) {
                if (plants[i][j] != null && plants[i][j].getName().equals(plantName)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }

    public String generatePlantCode() {
        int [][] code = new int[4][4];
        String msg = "";

        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < code.length; j++) {
                code[i][j] = random.nextInt(10);
            }
        }

        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        msg += code[i][j];
                    }
                } else {
                    if (j % 2 != 0) {
                        msg += code[i][j];
                    }
                }
            }
        }

        return msg;
    }

    public String oneMeterHigher() {
        String msg = "";

        for (int i = 0; i < plantsList.size(); i++) {
            if (plantsList.get(i) instanceof OrnamentalPlant) {
                msg += "* Nombre:" + plantsList.get(i).getName() + " Codigo: " + plantsList.get(i).getCode() + " Altura: " + ((OrnamentalPlant)(plantsList.get(i))).getHeight() + "\n";
            }
        }
        
        return msg;
    }
    
    public String sellPlant() {
        String msg = "No se ha podido vender la planta";

        

        return msg;
    }

    public String showAllPlants() {
        String msg = "";

        for (int i = 0; i < plantsList.size(); i++) {
            msg += (i + 1) + ". " + plantsList.get(i).getName() + " Codigo: " + plantsList.get(i).getCode();
        }

        return msg;
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

    

}