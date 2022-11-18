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
        String name = ""; 
        double cost = 0.0; 
        int type = 0; 
        String nameFruit = "";
        double high = 0.0; 
        switch(option){
            case 1:
            System.out.println("ingresa el nombre de la planta");
            name = reader.next();
            System.out.println("ingresa el costo de la planta");
            cost = validateDoubleInput();
            if(cost == -1){
                System.out.println("ingresa un costo valido");
            }

            System.out.println("ingrese el tipo de planta 1 frutales 2 ornamentales");
            type = validateIntegerInput(); 
            if(type == -1 ||  type <1  || type >2 ){
                System.out.println("ingresa un tipo valido ");
            }
            if(type  == 1){
                System.out.println("ingrese el nombre del fruto");
                nameFruit = reader.next(); 
                System.out.println(garden.addFruity(name, cost, nameFruit));

            } 
             else if(type == 2){
                System.out.println("ingresa la altura maxima de la planta en mts");
                high = validateDoubleInput();
                if(high == -1){
                System.out.println("ingresa una altura valida");
                }
                System.out.println(garden.addOrnamental(name, cost, high));

            }

            break;

            case 2: 
            System.out.println(garden.highOrnamentals()); 
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
    public double validateDoubleInput(){
        double option = 0; 

        if(reader.hasNextDouble()){
            option = reader.nextDouble(); 
        }
        else{
            // clear reader. 
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }
    
}
