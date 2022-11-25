package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{

    private final int SIZE_ROWS = 12;
    private final int SIZE_COLUMNS = 6;

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
        this.plants = new Plant[SIZE_ROWS][SIZE_COLUMNS];


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


    public String addFruit(String name, double cost, String fruit){
        String message = "No se ha podido añadir el frutal.";
        String id = generateId();
        boolean isCreatedFruity = false;
        if(cost == -1){
            message = "Error al digitar el costo.";
        }
        else{
            Fruity fruity = new Fruity(name, cost, fruit, id);
            
            for(int i = 0; i < SIZE_ROWS && !isCreatedFruity; i++){
                if(i%2 == 0){
                    for(int j = 0; j < SIZE_COLUMNS; j++){
                        if(plants[i][j] == null){
                            plants[i][j] = fruity;
                            isCreatedFruity = true;
                            message = "Frutal añadido con exito.";
                        }
                    }
                }
            }
        }

        return message;
    }

    
    public String addOrnamental(String name, double cost, double height){
        String message = "No se ha podido añadir la planta ornamental.";
        boolean isCreatedOrnamental = false;
        String id = generateId();
        if(cost == -1){
            message = "Error al digitar el costo.";
        }
        else{
            Ornamental ornamental  = new Ornamental(name, cost, height, id);
            
            for(int i = 1; i < SIZE_ROWS && !isCreatedOrnamental; i++){
                if(i%2 != 0){
                    for(int j = 0; j < SIZE_COLUMNS; j++){
                        if(plants[i][j] == null){
                            plants[i][j] = ornamental;
                            isCreatedOrnamental = true;
                            message = "Planta ornamental añadido con exito.";
                        }
                    }
                }
            }
        }

        return message;
    }

    public String listHighOrnamental(){
        String message = "";
        Ornamental ornamental;

        for(int i = 0; i < SIZE_ROWS; i++){
            for(int k = 0; k < SIZE_COLUMNS; k++){
                if(plants[i][k] instanceof Ornamental){
                    ornamental = (Ornamental) (plants[i][k]);
                    if(ornamental.getHeight() > 1){
                        message += ornamental.toString() + "\n";
                    }
                }
            }
        }

        return message; 
    }


    public String generateId(){
        String result = "";
        int[][] matriz = generateMatriz();

        
        for (int i = 1; i <= 3; i++){
            if(i%2 != 0){
                result += matriz[0][i];
            }
        }
        for(int k = 0; k <= 3; k++){
            if(k%2 == 0){
                result += matriz[1][k];
            }
        }
        for (int f = 1; f <= 3; f++){
            if(f%2 != 0){
                result += matriz[2][f];
            }
        }
        for(int d = 0; d <= 3; d++){
            if(d%2 == 0){
                result += matriz[3][d];
            }
        }


        return result;
    }

    
    public int [][] generateMatriz(){
        Random random = new Random();
    
        int matriz[][] = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j= 0; j < 4; j++){
                matriz[i][j] = random.nextInt(9); 
            }
        }
        return matriz;
    }

    public String printList(){
        String message = "Lista de plantas disponibles: \n";

        for(int i = 0; i < SIZE_ROWS; i++){
            for(int k = 0; k < SIZE_COLUMNS; k++){
                if(plants[i][k] != null){
                    message += plants[i][k].toString() + "\n";
                }
            }
        }

        return message;
    }

    public String buyPlant(String nameToBuy){
        String message = "";
        String bill = "";

        int[] position = searchPlant(nameToBuy);
        int row = position[0];
        int column = position[1];

        plants[row][column] = null;
        
        message = "Planta vendida con exito. \n" + "Numero de Factura: \n";

        bill = generateBill();    

        message += bill;

        return message;

    }

    public int[] searchPlant(String name){
        int[] result = new int[2];
        boolean isFounded = false;

        for(int i = 0; i < SIZE_ROWS && !isFounded; i++){
            for(int k = 0; k < SIZE_COLUMNS; k++){
                if(plants[i][k] != null){ 
                    if( plants[i][k].getName().equalsIgnoreCase(name)){
                        result[0] = i;
                        result[1] = k;
                    }
                }
            }
        }

        return result;
    }

    public String generateBill(){
        String result = "";

        int[][] matrizOne = generateMatriz();
        int[][] matrizTwo = generateMatriz();
        int[][] matrizThree = generateMatriz();


        for(int i = 0; i < SIZE_ROWS; i++){
            for(int k = 0; k < SIZE_COLUMNS; k++){
                matrizThree[i][k] = (matrizOne[i][k]*matrizTwo[i][k]);
            }
        }
        for(int h = 1; h < 3; h++){
            result += matrizThree[0][h];
        }
        for(int l = 0; l < SIZE_COLUMNS; l++){
            if(l != 1 && l != 2){
                result += matrizThree[1][l];
            }
        }
        for(int n = 0; n < SIZE_COLUMNS; n++){
            if(n != 1 && n != 2){
                result += matrizThree[1][n];
            }
        }
        for(int g = 1; g < 3; g++){
            result += matrizThree[3][g];
        }

        return result;
    }

}