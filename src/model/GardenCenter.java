package model;

import java.lang.Math;
import java.util.ArrayList;

public class GardenCenter{

    private String name; 
    private String direcction;
    private int[][] matrix;
    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        this.plantsList = new ArrayList<Plant>(72);
        this.matrix = new int[4][4];
        plants = new Plant[12][6];

    }

    public String addPlant(Plant anyPlant){
        String msj = "";
        Boolean isUnic = true; 
        Plant holdPlant = searchPlant(anyPlant.getName());
        if(holdPlant==null){
            anyPlant.setId(generateID());
            do{
                isUnic = isUnic(anyPlant.getId());
            }while(!isUnic);
            if(anyPlant instanceof Frutal){
                msj = addPlant(anyPlant, 1);
            }else{
                msj = addPlant(anyPlant, 2);
            }
        }else{
            msj = "Ya hay una planta registrada con ese nombre";
        }

        return msj;
    }
    
    public boolean isUnic(String id){
        boolean isFound = false;
        for (int i = 0; i < matrix.length && !isFound; i++) {
            for (int j = 0; j < matrix[0].length && !isFound; j++) {
                if(plants[i][j]!=null){
                    if(plants[i][j].getId().equals(id)){
                        isFound = true;
                    }
                }
            }
        }
        return !isFound;
    }
    public String addPlant(Plant anyPlant, int option){
        String msj = "";
        boolean isAdded = false;
        if(option == 1){
            for (int i = 0; i < plants.length && !isAdded; i+=2) {
                for (int j = 0; j < plants[0].length && !isAdded; j++) {
                        if(plants[i][j]==null){
                            plants[i][j] = anyPlant;
                            isAdded = true;
                            msj = "Se agrego la planta";
                            plantsList.add(anyPlant);
                        }
                }
            }
        }else{
            for (int i = 1; i < plants.length && !isAdded; i+=2) {
                for (int j = 0; j < plants[0].length && !isAdded; j++) {      
                        if(plants[i][j]==null){
                            plants[i][j] = anyPlant;
                            isAdded = true;
                            msj = "Se agrego la planta";
                            plantsList.add(anyPlant);
                        }
                }
            }      
        }
        if(!isAdded){
            msj = "No hay espacio para plantas de este tipo";
        }
        return msj;
    }

    public Plant searchPlant(String name){
        boolean isFound = false;
        Plant anyPlant = null;
        for (int i = 0; i < matrix.length && !isFound; i++) {
            for (int j = 0; j < matrix[0].length && !isFound; j++) {
                if(plants[i][j]!=null){
                    if(plants[i][j].getName().equals(name)){
                        isFound = true;
                        anyPlant = plants[i][j];
                    }
                }
            }
        }
        return anyPlant;
    }

    public String list1MeterPlants(){
        String msj =  "Plantas mas altas que 1m \n";
        for (int i = 1; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix.length; j++) {
                if(plants[i][j]!=null){
                    if(((Ornamental)(plants[i][j])).getMaxHeight()>1){
                        msj += plants[i][j].toString()+"\n";
                    }
                }
            }
        }
        return msj;
    }
    public String sellPlant(String name){
        String msj = "";
        Plant anyPlant = searchPlant(name);
        if(anyPlant!=null){
            deletePlant(anyPlant);
            msj = "ID de compra "+generateVoucher()+"\n"+
            "Planta comprada";
        }else{
            msj = "No se encontro la planta";
        }
        return msj;
    }
    public void deletePlant(Plant plant){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(plants[i][j]!=null){
                    if(plants[i][j].equals(plant)){
                        plants[i][j] = null;
                    }
                }
            }
        }
        plantsList.remove(plant);
    }
    public String generateVoucher(){
        int[][] matrix2 = new int[4][4];
        this.matrix = initMatrix(this.matrix);
        matrix2 = initMatrix(matrix2);
        matrix2 = multiplyMatrix(matrix2, this.matrix);
        String code = "";
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                if(i == 0 && j == 0){
                    code += matrix2[i][j];
                }
                if(i == 0 && j == matrix2.length-1){
                    code += matrix2[i][j];
                }
            }
        }
        for (int i = 1; i < matrix2.length-1; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                if(j != 0 && j<matrix2.length-1){
                    code += matrix2[i][j];
                }
            }
        }
        for (int i = matrix2[0].length-1; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                if(i == matrix2[0].length-1 && j == 0){
                    code += matrix2[i][j];
                }
                if(i == matrix2[0].length-1 && j == matrix2.length-1){
                    code += matrix2[i][j];
                }
            }
        }
        return code.substring(4);
    }

    public int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int[][] matrix3 = new int[4][4];
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                matrix3[i][j]=matrix1[i][j]*matrix2[i][j];
            }
        }
        return matrix3;
    }
    public String listPlants(){
        String msj = "lista de plantas: \n";
        for (int i = 0; i < plantsList.size(); i++) {
            msj += "- "+plantsList.get(i).toString()+"\n";
        }
        return msj;
    }
    public Plant createPlant(String name, double costs, double maxHeight, String fruteName, int option){
        Plant anyPlant = null;
        if(option==1){
            anyPlant = new Frutal(name, costs, fruteName);
        }else{
            anyPlant = new Ornamental(name, costs, maxHeight);
        }
        return anyPlant;
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

    public String generateID(){
        this.matrix = initMatrix(this.matrix);
        
        String id = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i%2==0){
                    if(j%2==0){
                        id+= matrix[i][j];
                    }
                }
                if(i%2!=0){
                    if(j%2!=0){
                        id+= matrix[i][j];
                    }
                }
            }
        }
        return id;  
    }
    public int[][] initMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=(int)(Math.random()*10);
            }
        }
        return matrix;
    }
    

}