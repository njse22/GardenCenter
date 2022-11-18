package model;

import java.util.ArrayList;
import java.util.Random;

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
        plantsList= new ArrayList<Plant>();
        Plant plants[][]=new Plant[12][6];

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
    public Plant searchPlant(String nickname){
        Plant plant = null; 
        boolean isFound = false; 
        for(int i = 0; i < plantsList.size() && !isFound; i++ ){
            if(plantsList.get(i) != null && plantsList.get(i).getName().equalsIgnoreCase(nickname)){
                plant = plantsList.get(i); 
                isFound = true; 
            } 
        }
        return plant; 
    }
    public int[][] generateMatrizId(){
        // izquierda es fila y derecha es columna xd
      int matriz[][]=new int[4][4];

      for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            matriz[i][j]=generateNumber();
        }
      }
      return matriz;

    }
    public int generateNumber(){
        
         Random r= new Random();
       
         int value = r.nextInt(8 + 1) + 1;
       
        return value;
       
    }
    public String generateCode(int[][]matriz){
       String code = ""; 
        for(int i =0; i<matriz.length; i++){
            if(matriz[0][i] == matriz[0][0] || matriz[0][i] == matriz[0][2]){
                code += matriz[0][i]; 
            }
        }
        for(int i =0; i < matriz.length; i++){
            if(matriz[1][i] == matriz[1][1] || matriz[1][i] == matriz[1][3]){
                code += matriz [1][i];
            }
        }
        for(int i =0; i<matriz.length; i++){
            if(matriz[2][i] == matriz[2][0] || matriz[2][i] == matriz[2][2]){
                code += matriz[2][i]; 
            }
        }
        for(int i =0; i < matriz.length; i++){
            if(matriz[3][i] == matriz[3][1] || matriz[3][i] == matriz[3][3]){
                code += matriz [3][i];
            }
        } 
        return code; 
    }
        



    public String addFruity(String name, double cost, String nameFruit){
        String msj = ""; 
        Plant plant = searchPlant(name);

         if (plant != null){

            msj = "the plant exist... :/";
        } else {
                int [][]matriz=generateMatrizId();
                String code= generateCode(matriz);
                Fruity fruit =  new Fruity(name,cost,code, nameFruit); 
                plantsList.add(fruit);
                msj = "nueva planta de tipo frutal agregada y su id es " + code;  
                
                
        }
        return msj;
    }
    public String addOrnamental(String name, double cost, double high){
        String msj = ""; 
        Plant plant = searchPlant(name);

         if (plant != null){

            msj = "the plant exist... :/";
        } else {
                int [][]matriz=generateMatrizId();
                String code= generateCode(matriz);
                Ornamental ornamental = new Ornamental(name,cost,code, high);
                plantsList.add(ornamental);
                msj = "nueva planta de tipo ornamental agregada y su id es " +  code ;
                 
        }
        return msj;
    }

    public boolean addMatrizFruit(Fruity fruit){
        boolean isAdded = false;
        for(int i =0; i< 12-1; i++){
            for(int j =0; j< 6-1; j++){
                if(plants[i][j] != null && i%2 == 0){
                    plants[i][j] = fruit; 
                    isAdded = true; 
                }
            }
        }
        return isAdded; 

    }
    public boolean addMatrizOrnamental(Ornamental ornamental){
        boolean isAdded = false;
        for(int i =0; i< 12-1; i++){
            for(int j =0; j< 6-1; j++){
                if( plants[i][j] != null && i%2 !=0){
                    plants[i][j] = ornamental; 
                    isAdded = true; 
                }
            }
        }
        return isAdded; 

    }
    public String highOrnamentals(){
        String msj = "las plantas ornamentales que miden mas de 1 metro son: \n "; 

        for(int i = 0; i< plantsList.size(); i++){
            if(plantsList.get(i) instanceof Ornamental){
                        Ornamental ornamental = ( (Ornamental) (plantsList.get(i)) );
                        if(ornamental.getHigh() > 1){    
                            msj += ornamental.getName() + "\n"; 
                        } 
                    }
        }
        return msj; 
    }

}