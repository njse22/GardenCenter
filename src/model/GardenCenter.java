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
    public int searchPlant(String name){
        int pos = -1;
        boolean isFound = false;
        for(int i =0; i<plantsList.size();i++){
            if(plantsList.get(i).getName().equals(name)){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }
    public String generateId(){
        int[][] matriz = new int[4][4];
        String id = "";
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                matriz[i][j] = (int)Math.floor(Math.random()*10);
            }
        }

        for(int i =0;i<4;i++){
            for(int j=0;j<4;j+=2){
                if(i==1 || i==3){j++;}
                id+=""+matriz[i][j];
                if(i==1 || i==3){j--;}
                
            }
        }
        return id;

    }
    public String addFrutal(String name, double cost, String fruit){
        String id = generateId();
        Plant plant = new Frutal(name,cost,id,fruit);
        plantsList.add(plant);
        return "\n FRUTAL PLANT REGISTERED SUCCESFULLY";
    }
    public String addOrnamental(String name, double cost, double height){
        String id = generateId();
        Plant plant = new Ornamental(name,cost,id,height);
        plantsList.add(plant);
        return "\n ORNAMENTAL PLANT REGISTERED SUCCESFULLY";
    }
    public String listOrnamentalHeight(){
        String msj = "";
        Ornamental plant = null;
        for(int i = 0;i<plantsList.size();i++){
            if(plantsList.get(i) instanceof Ornamental){
                plant = (Ornamental)plantsList.get(i);
                if(plant.getHeight() > 1){
                    msj += "\n NAME : "+plant.getName()+
                        "\n HEIGHT : "+plant.getHeight()+"m\n";
                }
            }
        }
        if(msj.equals("")){
            msj = "\n NO ORNAMENTAL TALLER THAN 1m.....";
        }
        return msj;
    }
    public String showPlantList(){
        String msj = "";
        for(int i=0; i<plantsList.size();i++){
            msj += plantsList.get(i).toString()+"\n";
        }
        if(msj.equals("")){msj = "\n NO PLANTS REGISTERED YET....";}
        return msj;
    }

    

}