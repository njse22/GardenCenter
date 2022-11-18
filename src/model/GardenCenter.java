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
        initMatrix();
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
    public void initMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j]=(int)(Math.random()*9);
            }
        }
    }
    

}