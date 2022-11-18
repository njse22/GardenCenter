package model;

import java.util.ArrayList;

public class GardenCenter{

    private String name; 
    private String direcction;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList;
    private ArrayList<String> namePlants;


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
      this.name = name;
      this.direcction = direcction;
      this.plants = new Plant[12][6];
    }
    
    public String addFrutalPlant(String name, double cost, String nameFruto) {
      String msj = "";
      boolean wasAdded = false;
      int posPlant = searchPlantByName(name);
      if (posPlant == -1) {
        Frutal plantFrutal = new Frutal(name, cost, nameFruto);
        if (plants[i][j] == null) {
          plants[i][j] = plantFrutal;
          addPlantToList(plantFrutal);
          addNameOfPlant(name);
          wasAdded = true;
          msj = "La planta frutal fue añadida al vivero";
        } else {
          msj = "Ya no hay espacio para más plantas en el vivero.";
        }
      } else {
        msj = "La planta ya existe dentro del vivero.";
      }
      return msj;
    }

    public String addOrnamentalPlant(String name, double cost, double altura) {
      String msj = "";
      boolean wasAdded = false;
      int posPlant = searchPlantByName(name);
      if (posPlant == -1) {
        Ornamental plantOrnamental = new Ornamental(name, cost, altura);
        if (plants[i][j] == null) {
          plants[i][j] = plantOrnamental;
          addPlantToList(plantOrnamental);
          addNameOfPlant(name);
          wasAdded = true;
          msj = "La planta ornamental fue añadida al vivero";
        } else {
          msj = "Ya no hay espacio para más plantas en el vivero.";
        }
      } else {
        msj = "La planta ya existe dentro del vivero.";
      }
      return msj;
    }

    public String runMatrix(String name) {
      String msj = "";
      int posPlant = searchPlantByName(name);
      if (posPlant != -1) {
        for(int i = 0; i < 2; i++){
          if(i%2==0){
            
          }
        }
        plantsList.get(posPlant).setIdCode(plantsList.get(posPlant).getMatrixId()[0][]);
      }
    }

    public void addNameOfPlant(String namePlant) {
      boolean wasFound = false;
      for (int i = 0; i < namePlants.size() && !wasFound; i++) {
        if (namePlants.get(i) != null && namePlants.get(i).equalsIgnoreCase(namePlant)) {
          wasFound = true;
        }
      }
      if (!wasFound) {
        wasFound = true;
        namePlants.add(namePlant);
      }
    }
  
    public void addPlantToList(Plant plant) {
    boolean wasFound = false;
    for (int i = 0; i < plantsList.size() && !wasFound; i++) {
      if (plantsList.get(i) != null && plantsList.get(i).getName().equalsIgnoreCase(plant.getName())) {
        wasFound = true;
      }
    }
    if (!wasFound) {
      wasFound = true;
      plantsList.add(plant);
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
        return plants;
    }

    /**
     * @param plants the plants to set
     */
    public void setPlants(Plant[][] plants) {
        this.plants = plants;
    } 

    public int searchPlantByName(String plantName) {
      int pos = -1;
      boolean wasFound = false;
      for (int i = 0; i < plantsList.size() && !wasFound; i++) {
        if (plantsList.get(i) != null && plantsList.get(i).getName().equalsIgnoreCase(plantName)) {
          pos = i;
          wasFound = true;
        }
      }
      return pos;
    }

}