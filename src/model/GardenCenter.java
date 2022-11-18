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
        this.plants = new Plant[12][6];
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

    public String addFruityPlant(String name, double cost, String fruitName){
        return addPlant(new Fruity(name,cost,fruitName));
    }

    public String addOrnamentalPlant(String name, double cost, double height){
        return addPlant(new Ornamental(name,cost,height));
    }

    public boolean nameExist(String name){
        boolean exist = false;
        for(int i = 0; i < plantsList.size() && !exist;i++){
            if(plantsList.get(i).getName().equals(name)){
                exist = true;
            }
        }
        return exist;
    }

    public String addPlant(Plant plant){
        String msg = "El nombre introducido ya existe.";
        boolean added = false;

        if(!nameExist(plant.getName())){
            msg = "No parece haber más espacio para otra planta.";
            for(int i=0; i <plants.length && !added;i++){
                for(int j = 0; j < plants[0].length&& !added;j++){
                    if(plant instanceof Fruity && i%2 ==0){
                      if(plants[i][j] == null){
                        plants[i][j] = plant;
                        plantsList.add(plant);
                        added = true;
                        msg = "Se ha añadido correctamente";
                      }
                    }else if(plant instanceof Ornamental && i %2 != 0){
                        if(plants[i][j] == null){
                            plants[i][j] = plant;
                            plantsList.add(plant);
                            added = true;
                            msg = "Se ha añadido correctamente";
                        }
                    }
                
                }
            }
        }

        
        return msg;
    }

    public String listOrnamentalsByHeight(int mts){
        String msg = "\n";

        for(int i=0; i <plants.length;i++){
            for(int j = 0; j < plants[0].length;j++){
               if(plants[i][j] instanceof Ornamental){
                    if(((Ornamental)plants[i][j]).getHeight() >mts){
                       msg += plants[i][j].toString()+"\n";
                    }
                }
                
            }
        }
        return msg;
    }

    public String listAllPlants(){
        String msg = "";

        for(int i = 0; i < plantsList.size();i++){
            msg += plantsList.get(i).toString() + "\n";
        }
        return msg;
    }

    public String sellPlant(String name){
        String msg = "Planta no encontrada. ";

        if(nameExist(name)){
            deletePlantFromList(name);
            deletePlantFromMatrix(name);

            msg = "Factura numero: " +  generateBillNumber();
        }
        return msg;
    }

    private String generateBillNumber(){
        String code = "";

        int[][] matrix_1 = MatrixUtil.randomMatrix(4,4);
        int[][] matrix_2 = MatrixUtil.randomMatrix(4,4);
        int[][] matrix_result = new int[4][4];

        for(int i=0; i <matrix_result.length;i++){
            for(int j = 0; j < matrix_result[0].length;j++){
                matrix_result[i][j] = matrix_1[i][j] *matrix_2[i][j];
                if(i == 0 || i == 3){
                    if(j == 0 || j ==3){
                        code+= matrix_result[i][j];
                    }
                }else if(i == 1 || i == 2){
                    if(j == 1 || j ==1){
                        code+= matrix_result[i][j];
                    }
                }
            }
        }

        code += "\nMatrices utilizadas:\n " + MatrixUtil.matrixToString(matrix_1)+"\n"+ MatrixUtil.matrixToString(matrix_2)+"\n";

        return code;
    }

    private void deletePlantFromMatrix(String name){
        boolean deleted = false;
        for(int i = 0; i <plantsList.size() && !deleted;i++){
            if(plantsList.get(i).equals(name)){
                plantsList.remove(i);
            }
        }
    }

    private void deletePlantFromList(String name){
        boolean deleted = false;
        for(int i=0; i <plants.length && !deleted;i++){
            for(int j = 0; j < plants[0].length&& !deleted;j++){
               if(plants[i][j] != null){
                    if(plants[i][j].getName().equals(name)){
                        plants[i][j] = null;
                        deleted = true;
                    }
                }  
            }
        }
    }

}