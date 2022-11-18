package model;

import java.util.ArrayList;
import java.util.Random;

public class GardenCenter{
    public static final int  ROWS =4;
    public static final int  COLUMNS =4;
    private String name; 
    private String direcction;
    Random random=new Random();
    private Plant[][] plants;
    private ArrayList<Plant> plantsList; 


    /**
     * @param name
     * @param direcction
     */
    public GardenCenter(String name, String direcction) {
        this.name = name;
        this.direcction = direcction;
        plantsList=new ArrayList<Plant>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
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

    public void generateMatrix(){
        int [][] matrix =new int [4][4];
        for (int i =0;i<4;i++){
            for (int j=0;j<4;i++){
                matrix [i][j]=random.nextInt(9);
            }
        }
    }

    public String addPlant (String name,double cost,String nameFrut,int type,double height){
        String msj="No se pudo crear la planta";
        boolean create=false;
        if(validateNamePlant(name)==false){
            if(type==1){
                Frutal frutal=new Frutal(name, cost, nameFrut);
                create=plantsList.add(frutal);
                if(create==true){
                    msj="Se creo el frutal con exito";
                }else{
                    msj="No se pudo crear el frutal";
                }
            }else{
                Ornamental ornamental=new Ornamental(name, cost, height);
                create=plantsList.add(ornamental);
                if(create==true){
                    msj="Se creo la ornamental con exito";
                }else{
                    msj="No se pudo crear el ornamental";
                }
            }
        }else{
            msj="Ya existe el nombre";
        }
        
      
        return msj;
    }
    public String printOrnamentales(){
        String msj="Crea primero la planta";
        Ornamental ornamental=null;
        for(int i=0;i<plantsList.size();i++){
            name=plantsList.get(i).getName();
            ornamental=searchPlant(name);
            if(ornamental.getHeight()>1){
                msj+="nombre de la planta es "+ name +" su altura es "+ ornamental.getHeight()+"\n";
            }
        }

        return msj;
    }
    public Ornamental searchPlant(String name){
        Ornamental ornamental=null;
        for(int i=0;i<plantsList.size();i++){
            if(plantsList.get(i).getName().equals(name) && plantsList.get(i) instanceof Ornamental){
                ornamental=(Ornamental) plantsList.get(i);
            }
        }
        return ornamental;
    }
    public boolean validateNamePlant(String name){
        boolean exist=false;
        boolean flag=false;
        for (int i=0;i<plantsList.size() & ! flag;i++){
            if(plantsList.get(i).getName().equals(name)){
                flag=false;
                exist=false;
            }
        }
        return exist;
    }

    

}