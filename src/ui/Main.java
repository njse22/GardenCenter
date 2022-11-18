package ui;

import java.util.Scanner;
import model.*;

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
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
        switch(option){
            case 1:
                addPlant();
            break;

            case 2: 
                listPlantsHigherThanOneMt();
            break;

            case 3: 
                sellPlant();
            break;

            default:
            System.out.println("Invalip Option.");
            break;
        }
    }

    public void addPlant() {
        String plantName, fruitName, idPlant;
        double plantCost, plantHeight;
        boolean isAvailable, isOnRange, register;
        int plantType;

        System.out.println("Ingresa el nombre de la planta: ");
        plantName = reader.next();

        isAvailable = garden.checkPlantName(plantName);

        if(isAvailable) {
            System.out.println("Ingresa el costo de la planta: ");
            plantCost = reader.nextDouble(); 

            System.out.println("Escoge una opción de planta: \n" + "1. Frutal \n" + "2. Ornamental");   
            plantType = reader.nextInt();        

            isOnRange = garden.checkRange(1,2,plantType);

            if (isOnRange) {
                switch(plantType) {
                    case 1:
                        System.out.println("Ingresa el nombre del fruto de la planta: ");
                        fruitName = reader.next();
                        reader.nextLine();
                        idPlant = garden.generateIdPlant(0, 9);
                        Plant fruit = new Fruit(1, plantName, plantCost, fruitName);
                        register = garden.addPlant(fruit);                
                    break;

                    case 2:
                        System.out.println("Ingresa la altura máxima de la planta: ");
                        plantHeight = reader.nextDouble();
                        idPlant = garden.generateIdPlant(0, 9);
                        Plant ornamental = new Ornamental(2, plantName, plantCost, plantHeight);
                        register = garden.addPlant(ornamental);                
                    break;
                }
                
            } else {
                System.out.println("Error. Opción fuera de rango.");
            }


        } else {
            System.out.println("Error. El nombre de la planta ya existe.");
        }


    }

    public void listPlantsHigherThanOneMt() {
        System.out.println(garden.listPlants());
    }

    public void sellPlant() {
        System.out.println(garden.printPlants());
    }


     public int validateIntegerInput(){
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
    
}
