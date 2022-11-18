package model;

import java.util.ArrayList;

public class GardenCenter {

    private String name;
    private String direcction;
    private String msj;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList;

    public GardenCenter(String name, String direcction) {
        msj = "";
        this.name = name;
        this.direcction = direcction;
        plants = new Plant[12][6];
        plantsList = new ArrayList<Plant>();
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

    public String addPlant(String name, double cost, String fruitName, double maxHeight, int option) {
        msj = "El nombre de la planta está repetido";
        if (searchPlantByName(name) == -1) {
            boolean isAdded = false;
            msj = "Capacidad Maxima alcanzada";
            switch (option) {
                case 1:
                    for (int i = 0; i < plants.length && !isAdded; i += 2) {
                        for (int j = 0; j < plants[0].length && !isAdded; j++) {
                            if (plants[i][j] == null) {
                                isAdded=true;
                                Plant newFruit = new Fruit(name, cost, fruitName);
                                plants[i][j] = newFruit;
                                plantsList.add(newFruit);
                                msj = "Planta frutal añadida correctamente \n";
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < plants.length && !isAdded; i += 2) {
                        for (int j = 0; j < plants[0].length && !isAdded; j++) {
                            if (plants[i][j] == null) {
                                isAdded=true;
                                Plant newOrnamental = new Ornamental(name, cost, maxHeight);
                                plants[i][j] = newOrnamental;
                                plantsList.add(newOrnamental);
                                msj = "Planta Ornamental añadida correctamente \n";
                            }
                        }
                    }
                    break;
            }
        }
        return msj;
    }

    public String list1mtsPlants() {
        msj="";
        for (int i = 0; i < plantsList.size(); i++) {
            if (plantsList.get(i) instanceof Ornamental) {
                if (((Ornamental) plantsList.get(i)).getMaxHeight() >= 1.0) {
                    msj += "La planta: " + ((Ornamental) plantsList.get(i)).getName() + " mide :"
                            + ((Ornamental) plantsList.get(i)).getMaxHeight() + " mts\n";
                }
            }
        }
        return msj;
    }

    public String listPlants() {
        msj="";
        for (int i = 0; i < plantsList.size(); i++) {
            if (plantsList.get(i) instanceof Ornamental) {
                msj+="(Ornamental)"+" Nombre: "+ ((Ornamental) plantsList.get(i)).getName()+ " precio: " + ((Ornamental) plantsList.get(i)).getCost()+"\n";
            }else{
                msj+="(Fruit)"+" Nombre: "+ ((Fruit) plantsList.get(i)).getName()+ " precio: " + ((Fruit) plantsList.get(i)).getCost()+ "\n";
            }
        }
        return msj;
    }

    public String sellPlant(String name){
        msj="La planta no existe";
        if(searchPlantByName(name)!=-1){
            for(int i=0;i<plants.length;i++){
                for(int j=0;j<plants[0].length;j++){
                    if(name.equals(plants[i][j].getName())){
                        msj="Numero de Factura: "+plants[i][j].createBillCode();
                        msj+= "\n" + plants[i][j].printMatrix();
                        plants[i][j]=null;
                        plantsList.remove(searchPlantByName(name));
                    }
                }
            }
        }
        return msj;
    }

    public int searchPlantByName(String name) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < plantsList.size() && !isFound; i++) {
            if (plantsList.get(i) != null) {
                if (name.equals(plantsList.get(i).getName())) {
                    pos = i;
                    isFound = true;
                }
            }
        }
        return pos;
    }

}