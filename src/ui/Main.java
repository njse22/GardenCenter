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
        return option;
    }

    public void executeOption(int option){
        String msj = "";
        int numPrueba = 0;
        int typePlant = 0;
        switch(option){
            case 1: 
                System.out.print("Type the type of the plant you want to add: \n" +
                                 "1. Frutal \n" +
                                 "2. Ornamental \n");
                while (!reader.hasNextInt()){
                    reader.next();
                    System.out.println("Enter a valid integer number ");
                }
                numPrueba = reader.nextInt();
                if(garden.validateCorrectOption(numPrueba)){
                    typePlant = numPrueba;
                    if(typePlant == 1){
                        System.out.print("Type the name of the plant: ");
                        String plantName = reader.next();
                        System.out.print("Type the cost of the plant: ");
                        while (!reader.hasNextDouble()){
                            reader.next();
                            System.out.println("Enter a valid double number ");
                        }
                        double plantCost = reader.nextDouble();
                        System.out.print("Type the name of fruts of this plant: ");
                        String plantFrutsName = reader.next();
                        msj = garden.addFrutalPlant(plantName,plantCost,plantFrutsName);
                        System.out.println(msj);
                    }else if(typePlant == 2){
                        System.out.print("Type the name of the plant: ");
                        String plantName = reader.next();
                        System.out.print("Type the cost of the plant: ");
                        while (!reader.hasNextDouble()){
                            reader.next();
                            System.out.println("Enter a valid double number ");
                        }
                        double plantCost = reader.nextDouble();
                        System.out.print("Type the size of this plant: ");
                        while (!reader.hasNextDouble()){
                            reader.next();
                            System.out.println("Enter a valid double number ");
                        }
                        int size = reader.nextInt();
                        msj = garden.addOrnamentalPlant(plantName,plantCost,size);
                        System.out.println(msj);
                    }
                }else{
                    System.out.print("Invalid option");
                }
            break;

            case 2: 
            break;

            case 3: 
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
    
}
