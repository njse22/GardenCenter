package model;

import java.util.ArrayList;

public class GardenCenter {

    private String name;
    private String direcction;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList;

    public static final int ROWS_PLANT = 12;

    public static final int COLUMNS_PLANT = 6;

    /**
     * The rows of the matrix for generate the id
     */
    public static final int ROWS = 4;

    /**
     * The colums of the matrix for generate the id
     */
    public static final int COLUMNS = 4;

    /**
     * The matrix for generate id
     */
    int[][] matrixCode = new int[ROWS][COLUMNS];

    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        this.plantsList = new ArrayList<Plant>();
        this.plants = new Plant[ROWS_PLANT][COLUMNS_PLANT];

    }

    public String listPlantsMoreThan1Meter() {

        String msj = "";
        for (int i = 0; i < plantsList.size(); i++) {
            if (plantsList.get(i) != null) {
                if (plantsList.get(i) instanceof Ornamental) {

                    if (((Ornamental) plantsList.get(i)).getHeight() > 1) {
                        msj += "Nombre de la planta" + (i+1) + ": " + plantsList.get(i).getName() + "\n" + "Costo de la planta: "
                                + plantsList.get(i).getCost() +
                                "\n" + "Altura de la planta: " + ((Ornamental) plantsList.get(i)).getHeight() + "\n" + "\n";
                    }
                }
            }
        }

        if (msj == "") {
            msj = "No hay plantas que pasen el metro";
        }

        return msj;

    }

    public boolean addPlantWithObject(Plant plant) {

        boolean isEmpty = false;
        if (plant instanceof Frutal) {
            for (int i = 0; i < ROWS_PLANT && !isEmpty; i++) {
                for (int j = 0; j < COLUMNS_PLANT; j++) {
                    if (plants[i][j] == null && i % 2 == 0) {
                        plants[i][j] = plant;
                        isEmpty = true;
                    }
                }

            }

        } else {
            for (int i = 0; i < ROWS_PLANT && !isEmpty; i++) {
                for (int j = 0; j < COLUMNS_PLANT; j++) {
                    if (plants[i][j] == null && i % 2 != 0) {
                        plants[i][j] = plant;
                        isEmpty = true;
                    }

                }

            }

        }
        return isEmpty;

    }

    public String addPlantSystem(String name, double cost, String nameFruit, double height, boolean option) {

        Plant newPlant = null;
        String msj = "No hay espacio en el vivero";
        int posPlant = searchPlantByName(name);

        if (posPlant == -1) {

            if (option == true) {
                newPlant = new Frutal(name, cost, nameFruit);
                if (addPlantWithObject(newPlant) == true) {
                    String matrix = addRandomNumbersMatrixAndPrint();
                    String autoId = generateId();
                    newPlant.setId(autoId);
                    msj = "Nueva planta frutal agregada" + "\n" +
                            "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                            "El codigo de su planta es: " + newPlant.getId() + "\n";

                }

            } else {

                newPlant = new Ornamental(name, cost, height);
                if (addPlantWithObject(newPlant) == true) {
                    String matrix = addRandomNumbersMatrixAndPrint();
                    String autoId = generateId();
                    newPlant.setId(autoId);
                    msj = "Nueva planta ornamental agregada" + "\n" +
                            "La matriz usada para el codigo fue: " + "\n" + matrix + "\n" + "\n" +
                            "El codigo de su planta es: " + newPlant.getId() + "\n";
                }
            }

            addPlant(newPlant);

        } else {
            msj = "El nombre de la planta ya existe elija otro";
        }
        return msj;
    }

    public boolean addPlant(Plant newPlant) {
        return plantsList.add(newPlant);
    }

    public int searchPlantByName(String name) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < plantsList.size() && !isFound; i++) {
            if (plantsList.get(i) != null) {
                if (plantsList.get(i).getName().equalsIgnoreCase(name)) {
                    pos = i;
                    isFound = true;
                }
            }
        }
        return pos;
    }

    /**
     * addRandomNumbersMatrixAndPrint: This method add random integer numbers of the
     * matrix of the id in a range of 0 to 9
     * 
     * @return msj: String - The matrix with random numbers
     */
    public String addRandomNumbersMatrixAndPrint() {
        String msj = "";
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;

        for (int i = 0; i < ROWS; i++) {
            msj += "\n";
            for (int j = 0; j < COLUMNS; j++) {
                matrixCode[i][j] = (int) (Math.random() * range) + lowerBound;
                msj += matrixCode[i][j] + " ";
            }
        }
        return msj;

    }

    /**
     * generateDefaultAutoId: This method generate a id
     * 
     * @return autoId: String - the generated id
     */
    public String generateId() {

        String autoId = "";

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    autoId += matrixCode[i][j];
                } else if (i % 2 == 0 && j % 2 == 0) {
                    autoId += matrixCode[i][j];
                }
            }
        }

        return autoId;
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