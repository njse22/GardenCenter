package ui;

import model.*;
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

        String plantType = "";
        String name = "";
        double cost = 0;
        String fruitName = "";
        double height = 0;
        String msj = "";

        switch(option){
            case 1:
            System.out.println("Ingrese el tipo de planta a agregar. (Frutal o Ornamental): ");
            plantType = reader.next();

            if(plantType.equalsIgnoreCase("Frutal")){
                System.out.println("Ingrese el nombre de la planta: ");
                name = reader.next();
                reader.nextLine();
                System.out.println("Ingrese el costo de la planta: ");
                cost = reader.nextDouble();
                System.out.println("Ingrese el nombre del fruto de la planta: ");
                fruitName = reader.next();
                reader.nextLine();

                Plant fruity = new Fruity(name, cost, fruitName);
                garden.addPlant(fruity);

                if(garden.addPlant(fruity) == true){
                    msj = "Planta frutal agregada.";
                    System.out.println(msj);
                }else{
                    msj = "No se agrego la planta.";
                    System.out.println(msj);
                }

            }else if(plantType.equalsIgnoreCase("Ornamental")){
                System.out.println("Ingrese el nombre de la planta: ");
                name = reader.next();
                reader.nextLine();
                System.out.println("Ingrese el costo de la planta: ");
                cost = reader.nextDouble();
                System.out.println("Ingrese la altura de la planta: ");
                height = reader.nextDouble();

                Plant ornamental = new Ornamental(fruitName, cost, height);
                garden.addPlant(ornamental);

                if(garden.addPlant(ornamental) == true){
                    msj = "Planta ornamental agregada.";
                    System.out.println(msj);
                }else{
                    msj = "No se pudo agregar a la planta.";
                    System.out.println(msj);
                }
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
