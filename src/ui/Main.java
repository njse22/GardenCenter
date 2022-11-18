package ui;

import model.GardenCenter;
import java.util.Scanner;

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
        /* Test Cases
         *   main.garden.addPlant("Rosa",5, "Rosita", 0);
         *   main.garden.addPlant("Amapola",3, null, 5);
         *   main.garden.addPlant("Girasol",2, null, 0.5);
        */
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
                uiAddPlant();
                break;

            case 2:
                System.out.println(garden.listOrnamentalPlants());
                break;

            case 3:
                uiSellPlant();
                break;

            default:
            System.out.println("Invalip Option.");
            break;
        }
    }
    public void uiAddPlant(){
        System.out.println("Name: ");
        String name = reader.next();
        System.out.println("Cost: ");
        double cost = reader.nextDouble();
        System.out.println("0 - Fruity \n1 - Ornamental");
        int typePlant = reader.nextInt();
        switch (typePlant){
            case 0 -> {
                System.out.println("Name fruit: ");
                String nameFruit = reader.next();
                System.out.println(garden.addPlant(name, cost, nameFruit, 0));
            }
            case 1 -> {
                System.out.println("Height: ");
                double height = reader.nextDouble();
                System.out.println(garden.addPlant(name, cost, null, height));

            }
        }
    }

    public void uiSellPlant(){
        System.out.println(garden.showPlants());
        System.out.println("Name plant: ");
        String namePlant = reader.next();
        System.out.println(garden.sellPlant(namePlant));
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
