package ui;

import model.GardenCenter;
import model.TypeOfPlant;

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

        String msj, plantName, fruitname = "";
        Double plantprice, plantHeight = 0.0;
        int typeOfPlant = 0;

        switch(option){
            case 1:
            System.out.println("You are know adding a plant to the garden");
            System.out.println("Write the name of the plant");
            plantName = reader.next();
            
            System.out.println("Write the price of the plant");
            plantprice = reader.nextDouble();
            System.out.println("Choose the type of plant");
            System.out.println("1. Ornament Plant \n" +
            "2. Fruity Plant");
            typeOfPlant = reader.nextInt();

            if(typeOfPlant == 1){
                System.out.println("Write the height in meters of the plant");
                plantHeight = reader.nextDouble();

                msj = garden.addPlant(plantName, plantprice, plantHeight, "", TypeOfPlant.ORNAMENT);
                System.out.println(msj);

            }else if(typeOfPlant == 2){
                System.out.println("Write the fruit name");
                fruitname = reader.next();

                msj = garden.addPlant(plantName, plantprice, 0,fruitname, TypeOfPlant.FRUITY);
                System.out.println(msj);
            }else{
                System.out.println("This is not an option");

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
