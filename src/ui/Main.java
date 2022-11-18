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
				"1. Agregar planta\n"+
				"2. Listar ornamentales con mas de un metro de altura. \n"+
                "3. Mostrar lista de plantas \n"+
                "4. Vender producto \n"+
				"0. Exit. "); 
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
        switch(option){
            case 1 -> addPlant();

            case 2 -> ornameltalPlantsWithMoreThanOneMeter();

            case 3 -> listPlants();

            case 4 -> sellProduct();

            case 0 -> System.out.println("Bye");

            default -> System.out.println("Invalid Option.");
        }
    }


     public int validateIntegerInput(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
            reader.nextLine();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;
    }

    public void addPlant(){
        int type;
        String name;
        double cost = -1;
        String fruitName = "";
        double maxHeight = -1;
        System.out.println("Ingrese el nombre");
        name = reader.nextLine();
        System.out.println("Ingrese el costo");
        do{
            if(reader.hasNextDouble()){
                cost = reader.nextDouble();
            } else {
                reader.nextLine();
            }
        } while (cost == -1);
        System.out.println("Ingrese el tipo de planta\n" + 
        "1. Frutal\n" + 
        "2. Ornamental");
        type = validateIntegerInput();
        switch(type){
            case 1:
                System.out.println("Ingrese el nombre de los frutos");
                fruitName = reader.nextLine();
            break;
            
            case 2:
                System.out.println("Ingrese la altura maxima en metros");
                do{
                    if(reader.hasNextDouble()){
                        maxHeight = reader.nextDouble();
                    } else {
                        reader.nextLine();
                    }
                } while (maxHeight == -1);
            break;

            default:
                System.out.println("Tipo incorrecto");
                return;
        }
        System.out.println(garden.addPlant(type, name, cost, fruitName, maxHeight));
    }
    

    public void ornameltalPlantsWithMoreThanOneMeter(){
        System.out.println(garden.ornameltalPlantsWithMoreThanOneMeter());
    }

    public void listPlants(){
        System.out.println(garden.listPlants());
    }

    public void sellProduct(){
        String name;
        System.out.println("Ingrese el nombre de la planta que desea vender\n" +
                           "Si desea ver la lista de plantas use la opcion 3 desde el menu.");
        name = reader.nextLine();
        System.out.println(garden.sellProduct(name));
    }
    
}
