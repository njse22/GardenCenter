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
        reader.nextLine();
        return option;
    }

    public void executeOption(int option){
        switch(option){
            case 1:
                addPlant();
            break;
                
            case 2: 
                list1MeterPlants();
            break;
                
            case 3: 
                sellProduct();
            break;
            case 0:
                System.out.println("Exit program");
            break;
            default:
            System.out.println("Invalip Option.");
            break;
        }
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
    
    public void addPlant(){
        String name = null;
        String frute = null;
        double cost = 0.0;
        double maxHeight = 0.0;
        String option = null;
        System.out.println("Inserte el nombre de la planta");
        name = reader.nextLine();
        System.out.println("Inserte el costo de la planta");
        cost = reader.nextDouble();
        reader.nextLine();
        System.out.println("De que tipo es la planta? \n"+
        "1. Frutal \n"+
        "2. Ornamental \n");
        option = reader.nextLine();
        if(option.equals("1") || option.equals("2")){
            if(option.equals("1")){
                System.out.println("Inserte el nombre del fruto");
                frute = reader.nextLine();
            }
            if(option.equals("2")){
                System.out.println("Inserte la altura maxima (en metros)");
                maxHeight = reader.nextDouble();
            }
            System.out.println(garden.addPlant(garden.createPlant(name, cost, maxHeight, frute, Integer.parseInt(option))));

        }else{
            System.out.println("Opcion invalida");
        }
    }

    public void list1MeterPlants(){
        System.out.println(garden.list1MeterPlants());
    }

    public void sellProduct(){
        String name = null;
        System.out.println(garden.listPlants());
        System.out.println("Inserte el nombre de la planta que desea comprar");
        name = reader.nextLine();
        System.out.println(garden.sellPlant(name));
    }
    
}
