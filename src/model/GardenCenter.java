package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{

    private String name; 
    private String direcction;

    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 
    public static final int ROWS = 4;
    public static final int COLUMNS= 4;


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

    public String createPlant(String name,String namePlant, double cost, double height, int option){
        String msj ="";
        Plant plant = findNamePlant(name);

        if(plant != null){
            msj = "This plant doesnt exists";
        }
        else {
            if(option ==1){
                int [][] matriz =createIdMatrix();
                String code = generateCode(matriz);
                Frutal frutal = ((Frutal)(plant));
                plantsList.add(new Frutal(name, namePlant, cost));
                msj = "This is a Frutal plant";
            }
            else{
                int [][] matriz =createIdMatrix();
                String code = generateCode(matriz);
                Ornamental ornamental = ((Ornamental)(plant));
                plantsList.add(new Ornamental(height, namePlant, cost));
                msj = "This is a Ornamental plant";
            }
        }
        return msj;
    }

    public Plant findNamePlant(String name){
        Plant plant = null;
        boolean isFound = false;
        for(int i = 0; i<plantsList.size() && !isFound; i++){
            if(plantsList.get(i).getName().equalsIgnoreCase(name)){
                plant = plantsList.get(i);
                isFound = true;
            }
        }
        return plant;
    }

    public int generateIdRandom(){

        Random r = new Random();
        int value = r.nextInt(8+1)+1;

        return value;
    }

    public int[][] createIdMatrix(){
        int matriz[][] = new int[ROWS][COLUMNS];

        for(int i = 0;i<ROWS; i++){
            for(int j =0; j<COLUMNS; j++){
                matriz[i][j] = generateIdRandom();
            }
        }
        return matriz;
    }

    public String generateCode(int[][] matriz){
        String code = null;

        for(int i =4; i<=0;i--){
            for(int j = 4; j<=0; j--){
                int sum = i+j;
                if(sum%2 !=0){
                    if(sum !=1){
                        code +=matriz[i][j]+ "";
                    }
                }

            }
        }
        return code;
    }

    public String createFrutal(String name,String namePlant, double cost){
        String msj = "Nueva planta frutal creada";

        Plant plant  = findNamePlant(namePlant);

        if(plant == null){
            msj = "Esta planta no existe";
        }
        else{
            if(plant instanceof Frutal){
            
            }
        }
        return msj;
    }

    

}