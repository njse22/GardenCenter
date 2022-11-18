package ui;

import model.GardenCenter;

import java.security.Principal;
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
				"2. Listar ortalizas con mas de un metro de altura. \n"+
                "3. Vender producto \n"+
				"0. Exit. "); 
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
        String name, nameFruto = "";
        double cost, height = 0.0;
        int type = 0;
        switch(option){
            case 1:
            System.out.println("Estas agregando una planta al vivero pero primero se pediran unos datos");
            System.out.println("Cual es el nombre de la planta");
            name = reader.next();
            System.out.println("Escribe el costo de la planta");
            cost = reader.nextDouble();
            System.out.println("Digita el tipo de planta a ingresar \n" +
            "1.Planta Frutal \n"+
            "2.Planta Ornamental");

            type = validateIntegerInput();
            
            switch(type){
                case 1:
                System.out.println("Escribe el nombre del fruto de esta planta");
                nameFruto = reader.next();
            

                System.out.println(garden.createPlant(nameFruto, name, cost, height, type));
                break;
                
                case 2:
                System.out.println("Escribe la altura de la planta");
                height = reader.nextDouble();

                System.out.println(garden.createPlant(nameFruto, name, cost, height, type));
                break;
            
            }

            


            break;

            case 2: 
            break;

            case 3: 
            break;

            default:
            System.out.println("Invalid Option.");
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
