package model;

import java.util.ArrayList;
import java.lang.Math;

public class GardenCenter{

    private String name; 
    private String direcction;

    public static final int ROWS = 12; 
    public static final int COLUMNS = 6; 

    private Plant[][] plants;
    private int[][] code;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        plants= new Plant[ROWS][COLUMNS];
        code= new int[4][4];
        plantsList=new ArrayList<Plant>(72);
        ;

    }

    public String addPlant(String name, double cost, String fruitName, double heightPlant, int choose){
        String msj="the plant cant be added";
        int posPlant=searchPlantByName(name);
        boolean isEmpty=false;
        if(posPlant==-1){
            switch(choose){
                case 1:
                  for(int i=0; i<ROWS && !isEmpty;i++){
                    for(int j=0; j<COLUMNS && !isEmpty;j++){
                        if(plants[i][j]==null){
                            if(i%2==0){
                                Plant newFruit = new FruitsPlants(name, cost, fruitName);
                                plantsList.add(newFruit);
                                plants[i][j]=newFruit;
                                isEmpty=true;
                                msj="new plant added";
                            }
                            
                        }
                    }
            
                  }
                  if(isEmpty=false){
                    msj="the space of fruits plants is full";
                  }
                break;

                case 2:
                  for(int i=0; i<ROWS && !isEmpty;i++){
                    for(int j=0; j<COLUMNS && !isEmpty;j++){
                        if(plants[i][j]==null){
                            if(i%2!=0){
                                Plant newOrnamental = new OrnamentalsPlants(name, cost, heightPlant);
                                plantsList.add(newOrnamental);
                                plants[i][j]=newOrnamental;
                                isEmpty=true;
                                msj="new plant added";
                            }
                            
                        }
                    }
            
                  }
                  if(isEmpty==false){
                    msj="the space of ornamental plants is full";
                  }
                 
                break;
            }
        }else{
            msj="the plant is repeat";
        }
        
      
        return msj;

    }
    public String generateCode(){
        String msj="";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                code[i][j]=(int) Math.random();
                msj+=code[i][j] + " ";
            }
            msj+="\n";
        }
        return msj;
    }
    public int searchPlantByName(String name){
        int posPlant=-1;
        boolean isFound=false;
        for(int i = 0; i < plantsList.size() && !isFound; i++){
            if(plantsList.get(i)!=null){
                if(plantsList.get(i).getName().equals(name)){
                    posPlant = i;
                    isFound=true;
                }
            }
        }
        return posPlant;    
    }

    public String listOrnamentalPlants(){
        String msj="";
        for(int i=0; i < plantsList.size(); i++){
            if(plantsList.get(i) instanceof OrnamentalsPlants){
                if(((OrnamentalsPlants)(plantsList.get(i))).getHeightPlant()>1){
                    msj+=((OrnamentalsPlants)(plantsList.get(i))).getName() + "\n";
                }
            }
        }
        return msj;
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