package model;

import java.util.ArrayList;

public class GardenCenter{

    private String name;
    private String direction;
    private Plant[][] plants;
    private ArrayList<Plant> plantsList;
    private int[][] ids; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direction) {
        this.name = name;
        this.direction = direction;
        plantsList=new ArrayList <Plant>(10);
        plants=new Plant[12][6];
        ids=new int[5][5];
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
    public String getDirection() {
        return direction;
    }

    /**
     * @param direcction the direcction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
    public int[][] fillMatriz1(){
        int upperBound=9;
        int lowerBound=1;
        int range=(upperBound-lowerBound)+1;
        for (int i=0;i<5;i++ ) {
            for (int j =0;j<5;j++ ) {
                if (ids[i][j]==0) {
                    ids[i][j]= (int)(Math.random() * range) + lowerBound;
                }
            }
        }   
        return ids; 
    }
    public String showIdPlant(){
        String msj="";
        int[][] matrizFill=fillMatriz1();
        msj="";
             for(int i = 0; i<4; i++){
                 for (int j=0;j<4 ;j++ ) {
                     if((i+j)%2==0){
                        msj=msj+matrizFill[i][j];
                     }                   
                }
            }
        return msj;
        }
    public String addPlant(int typePlant, String namePlant, double costPlant, String nameFruit, double heigth){
        String msj="";
        boolean isAdded=false;
        String id=showIdPlant();
        if(typePlant==1){
            for (int i=0;i<plants.length&&!isAdded;i++ ) {
                for (int j=0;j<plants[0].length&&!isAdded; j++) {
                        if((i+j)%2==0){
                            Frutal newFrutal= new Frutal(namePlant,costPlant,nameFruit,id);
                            plants[i][j]=newFrutal;
                            isAdded=true;
                            plantsList.add(newFrutal);
                            msj="New Fruit added, id "+id;
                        }
                    }
                }
            }
        else{
            for (int i=0;i<plants.length&&!isAdded;i++ ) {
                for (int j=0;j<plants[0].length&&!isAdded; j++ ) {
                    if((i+j)%2==1){
                        Ornamental newOrnamental=new Ornamental(namePlant,costPlant, heigth,id);
                        plants[i][j]=newOrnamental;
                        isAdded=true;
                        plantsList.add(newOrnamental);
                        msj="new Ornamental added, id "+id;
                    }
                }
            }
        }
        return msj;
    }
    public String listOrnamentalPlants(){
        String msj="";
        for (int i=0;i<plantsList.size();i++ ) {
            if(plantsList.get(i) instanceof Ornamental){
                if(((Ornamental)(plantsList.get(i))).getHeight()>1){
                    msj=msj+plantsList.get(i).getName()+"\n";
                }
            }
        }
        return msj;
    }
    public String listPlants(){
        String msj="";
        for (int i=0;i<plantsList.size() ;i++ ) {
            if(plantsList.get(i)!=null){
                msj= msj+plantsList.get(i).toString();
            }
        }
        return msj;
    }

}