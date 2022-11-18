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
        plants  = new Plant[12][6];
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
    public boolean verifyName(String name){
        boolean macth = false;
        for(int i = 0; i<plantsList.size();i++){
            if(plantsList.get(i).getName().equals(name)){
                 macth= true;
            }
        }
        return macth;
    }

    public String generatePlantCode(){
        int[][] matrix = new int[4][4];
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        String msj = "";
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                matrix[i][j] = (int)(Math.random()*range)+lowerBound;
            }
        }
        
        for(int i = 0; i <4; i++){
            msj += "\n"; 
            for(int j = 0; j <4; j++){
                msj += matrix[i][j] + " ";
            }
        }
        msj += "\n"+
                "Codigo de la planta:\n";
        for(int i = 0;i<1;i++){
            for(int j = 0;j<4;j++){
                if(i == 0 || i%2==0){
                    if(j == 0 || j%2==0){
                        msj += matrix[i][j];
                    }
                }
            }
        }
        for(int i = 0;i<2;i++){
            for(int j = 0;j<4;j++){
                if(i != 0 || i%2 != 0){
                    if(j%2!=0){
                        msj += matrix[i][j];
                    }
                }
            }
        }
        for(int i = 1;i<3;i++){
            for(int j = 0;j<4;j++){
                if(i == 0 || i%2==0){
                    if(j == 0 || j%2==0){
                        msj += matrix[i][j];
                    }
                }
            }
        }
        for(int i = 3;i<4;i++){
            for(int j = 0;j<4;j++){
                if(i != 0 || i%2 != 0){
                    if(j%2!=0){
                        msj += matrix[i][j];
                    }
                }
            }
        }
        return msj;
    }
    public String addOrnamentalPlant(String name, double cost,double height){
        OrnamentalPlant newPlant = new OrnamentalPlant(name, cost, height);
        newPlant.setId(generatePlantCode());
        String msj = "No se pudo agregar a la planta";
        boolean isEmpty = false;
        for(int i = 0;i<12 && !isEmpty;i++){
            for(int j = 0;j<6 && !isEmpty;j++){
                if(i%2!=0){
                    if(plants[i][j] ==null){
                        plants[i][j] = newPlant;
                        msj = "La planta ha sido agregada";
                        plantsList.add(newPlant);
                        isEmpty = true;
                    }
                }
            }
        }
        return msj;
    }
    public String addFruityPlant(String name, double cost,String fruitName){
        FruityPlant newPlant = new FruityPlant(name, cost, fruitName);
        newPlant.setId(generatePlantCode());
        boolean isEmpty = false;
        String msj = "No se pudo agregar a la planta";
        for(int i = 0;i<12 && !isEmpty;i++){
            for(int j = 0;j<6 && !isEmpty;j++){
                if(i%2==0){
                    plants[i][j] = newPlant;
                    msj = "La planta ha sido agregada";
                    plantsList.add(newPlant);
                    isEmpty = true;
                }
            }
        }
        return msj;
    }
    public String listOrnamentalPlantsBySize(){
        String msj = "";
        for(int i = 0;i<plantsList.size();i++){
            if(plantsList.get(i) instanceof OrnamentalPlant){
                if(((OrnamentalPlant)(plantsList.get(i))).getHeight()>1){
                    msj += plantsList.get(i).getName()+"\n";
                }
            }
        }
        return msj;
    }
    public String generateSellCode(){
        int[][] matrix = new int[4][4];
        int[][] matrix1 = new int[4][4];
        int[][] matrix2 = new int[4][4];
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        String msj = "";
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                matrix[i][j] = (int)(Math.random()*range)+lowerBound;
            }
        }
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                matrix1[i][j] = (int)(Math.random()*range)+lowerBound;
            }
        }
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                matrix2[i][j] = matrix[i][j]*matrix1[i][j];
            }
        }
        return "";
    } 

}