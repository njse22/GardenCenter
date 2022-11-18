package ui;

import model.GardenCenter;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class Main {


    private Scanner reader;
    private GardenCenter garden; 

    /**
     * 
     */
    public Main() {
        this.reader = new Scanner(System.in); 
        this.garden = new GardenCenter("Garden", "Center");

    }
    
    public static void main(String[] args) {
        Main main = new Main(); 
        int option = 0; 
        do{
            option = main.optionMenu(); 
            main.executeOption(option);
        }while(option != 0); 

        main.reader.close();
    }

     public int optionMenu( ){
        int option = 0;
        
       System.out.println("<<<<<Garden Center>>>>> \n" +
				"1. agregar planta\n"+
				"2. listar ortalizas con mas de un metro de altura. \n"+
                "3. vender producto \n"+
				"0. Exit. "); 
        option = validateIntegerOption();
        return option;
    }

    public void executeOption(int option){
        String msj="";
        String name="";
        double cost=0;
        String fruitName=""; 
        double heightPlant=0; 
        int choose=0;
        int counter=0;
        switch(option){
            case 1:
            case1(msj, name, cost, fruitName, heightPlant, choose, counter);
            break;

            case 2: 
            msj=garden.listOrnamentalPlants();
            System.out.println(msj);
            break;

            case 3: 
            msj=garden.generateCode();
            System.out.println(msj);
            break;

            case 0:
            System.out.println("bye");
            break;

            default:
            System.out.println("Invalip Option.");
            break;
        }
    }

    public void case1(String msj, String name, double cost, String fruitName, double heightPlant, int choose, int counter){
        System.out.println("escriba el nombre de la planta");
        name=reader.next();
        counter=garden.searchPlantByName(name);
        if(counter==-1){
            do{
                System.out.println("escriba el costo de la planta");
                cost=validateIntegerOption();
                if(cost<0){
                    System.out.println("opcion invalida intente de nuevo");
                }
            }while(cost<0);
            
                do{
                    System.out.println("si su planta es una fruta marque 1, si su planta es una ornamental marque 2");
                    choose=validateIntegerOption();
                    if(choose!=1 && choose !=2){
                        System.out.println("opcion invalida intente de nuevo");
                    }
                }while(choose !=1 && choose !=2);
                if(choose==1){
                    System.out.println("escriba el nombre de la fruta de su planta");
                    fruitName=reader.next();

                }else if(choose==2){
                    do{
                        System.out.println("escriba la altura de la planta ornamental");
                        heightPlant=validateDoubleOption();
                        if(heightPlant<0){
                            System.out.println("opcion invalida intente de nuevo");
                        }
                    }while(heightPlant<0);
                }
                
                msj=garden.addPlant(name, cost, fruitName, heightPlant, choose);
                System.out.println(msj);
            
        }else{
            System.out.println("el nombre de la planta ya esta agragado");
        }
        
        
        
    }

     public int validateIntegerOption(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;
    }

    public double validateDoubleOption(){
        double option = 0; 

        if(reader.hasNextDouble()){
            option = reader.nextDouble(); 
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }
    
}
