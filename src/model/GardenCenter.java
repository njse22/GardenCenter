package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{

    private String name; 
    private String direcction;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList;
    private final int PLANTS_WIDHT = 12;
    private final int PLANTS_HEIGHT = 6;

    private Random random;


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        this.plants = new Plant[PLANTS_WIDHT][PLANTS_HEIGHT];
        this.plantsList = new ArrayList<Plant>();
        this.random = new Random();
    }

    public String addPlant(int type, String name, double cost, String fruitName, double maxHeight){
        String msj = "Capacidad maxima de plantas alcanzada";
        Plant plant;
        boolean added = false;
        if(searchMatrixPlantPos(name)[0] != -1){
            return msj = "Ya existe una planta con ese nombre";
        }
        if(type == 1){
            plant = new FruityPlant(name, cost, fruitName);
            for(int i = 0; i < PLANTS_WIDHT && !added; i++){
                for(int j = 0; j < PLANTS_HEIGHT && !added; j++){
                    if(i%2 == 0){
                        if(plants[i][j] == null){
                            plants[i][j] = plant;
                            added = true;
                            msj = "Planta añadida con exito";
                        }
                    }
                }
            }
        } else {
            plant = new OrnamentalPlant(name, cost, maxHeight);
            for(int i = 0; i < PLANTS_WIDHT && !added; i++){
                for(int j = 0; j < PLANTS_HEIGHT && !added; j++){
                    if(i%2 != 0){
                        if(plants[i][j] == null){
                            plants[i][j] = plant;
                            added = true;
                            msj = "Planta añadida con exito";
                        }
                    }
                }
            }
        }
        plantsList.add(plant);
        return msj;
    }

    public String ornameltalPlantsWithMoreThanOneMeter(){
        String msj = "";
        double maxHeight;
        for(int i = 0; i < plantsList.size(); i++){
            if(plantsList.get(i) instanceof OrnamentalPlant){
                maxHeight = ((OrnamentalPlant) plantsList.get(i)).getMaxHeight();
                if(maxHeight > 1){
                    msj += plantsList.get(i).getName() + ", mide: " + maxHeight + " m\n";
                }
            }
        }
        return msj;
    }

    public String listPlants(){
        String msj = "";
        msj += plantsList.toString() + "\n";
        return msj;
    }

    public String sellProduct(String name){
        String msj = "Se a vendido la planta, tu codigo de factura es: ";
        int[] matrixPos = searchMatrixPlantPos(name);
        int arrayListPos = searchArraylistPlantPos(name);
        if(matrixPos[0] == -1){
            return msj = "Una planta con ese nombre no existe";
        }
        plants[matrixPos[0]][matrixPos[1]] = null;
        plantsList.remove(arrayListPos);
        int[][] invoiceMatrix = generateInvoiceMatrix();
        String invoiceCode = generateInvoiceCode(invoiceMatrix);
        msj += invoiceCode;
        return msj;
    }

    public int[][] generateInvoiceMatrix(){
        int[][] firstMatrix = new int[4][4];
        int[][] secondMatrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                firstMatrix[i][j] = random.nextInt(10);
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                secondMatrix[i][j] = random.nextInt(10);
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                firstMatrix[i][j] *= secondMatrix[i][j];
            }
        }
        return firstMatrix;
    }

    public String generateInvoiceCode(int[][] matrix){
        String msj = "";
        for(int i = 0; i < 4; i += 3){
            for(int j = 0; j < 4; j += 3){
                msj += String.valueOf(matrix[i][j]);
            }
        }
        for(int i = 1; i < 3; i++){
            for(int j = 1; j < 3; j++){
                msj += String.valueOf(matrix[i][j]);
            }
        }
        return msj;
    }

    public int[] searchMatrixPlantPos(String name){
        int[] pos = new int[2];
        pos[0] = -1;
        boolean found = false;
        for(int i = 0; i < PLANTS_WIDHT && !found; i++){
            for(int j = 0; j < PLANTS_HEIGHT && !found; j++){
                if(plants[i][j] != null){
                    if(plants[i][j].getName().equals(name)){
                        pos[0] = i;
                        pos[1] = j;
                    }
                }
            }
        }
        return pos;
    }

    public int searchArraylistPlantPos(String name){
        int pos = -1;
        boolean found = false;
        for(int i = 0; i < plantsList.size() && !found; i++){
            if(plantsList.get(i).getName().equals(name)){
                pos = i;
                found = true;
            }
        }
        return pos;
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