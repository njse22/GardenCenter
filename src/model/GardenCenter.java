package model;

import java.util.ArrayList;

public class GardenCenter{

    private String name; 
    private String direcction;
    private int k = 0;
    private int l = 0;

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


    public boolean addPlant(Plant plant){
        

        /*
        if(plantsList.get(k).getType == 1) {

            if (k%2) {
                plants[k][l] = plant;

            } else {
                k++;
                l++;
                plants[k][l] = plant;
            }
        } else if(plantsList.get(k).getType == 2) {
            if (k%3) {
                plants[k][l] = plant;
            } else {
                k++;
                l++;
                plants[k][l] = plant;

            }
        }
        */

        return plantsList.add(plant);
    }


    public boolean checkPlantName(String plantName) {
        boolean isAvailable = true;

        try {
            for(int i = 0; i < plantsList.size(); i++ ) {
                if(plantsList.get(i).getName().equals(plantName)) {
                    isAvailable = false;
                }
            }

        } catch(NullPointerException e) {

        }

        return isAvailable;
    }

    public boolean checkRange(int min, int max, int range) {
        boolean isOnRange = false;
        if (range >= min && range <=max) {
            isOnRange = true;
        }

        return isOnRange;
    }

    public String generateIdPlant(int max, int min) {
        String matrix[][] = new String[4][4];
        String digitId;
        String idPlant = "";
        int number;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < 4; i++) {
                number = (int) (Math.random() * 9) + 1;
                digitId = String.valueOf(number);
                matrix[i][j] = digitId;
                idPlant += digitId;
                number = (int) (Math.random() * 9) + 1;
                digitId = String.valueOf(number);
                idPlant+= digitId;
            }
        }

        return idPlant;
  
    }


/*
        //Se introducen por teclado los valores de la matriz
        System.out.println("Lectura de elementos de la matriz: ");
        for (i = 0; i < FILAS; i++) {
            for (j = 0; j < COLUMNAS; j++) {
                System.out.print("A[" + i + "][" + j + "]= ");
                A[i][j] = sc.nextInt();
            }
        }

        //Mostrar por pantalla los valores que contiene la matriz
        System.out.println("valores introducidos:");
        for (i = 0; i < A.length; i++) { 
            for (j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        */

    public String listPlants() {
        double theHeight;
        String plantNames = "";


        try {
            for(int i = 0; i < plantsList.size(); i++ ) {
                if(plantsList.get(i) instanceof Ornamental){
                    theHeight = ((Ornamental)(plantsList.get(i))).getHeight();
                    if (theHeight > 1) {
                        plantNames += ((Ornamental)(plantsList.get(i))).getHeight() + "\n";
                    }
                }
            }

        } catch(NullPointerException e) {

        }

        return plantNames;

    }

    public String printPlants() {
        String print = "";

        for(int i = 0; i < plantsList.size(); i++ ) {
            print += plantsList.get(i).toString() + "\n";   
        }

        return print;
    }
    


}