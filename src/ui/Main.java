package ui;

import model.GardenCenter;
import java.util.Scanner;

public class Main {


    private Scanner reader;
    private GardenCenter garden;
    private double mts; 

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
				"1. agregar planta ornamental\n"+
                "2. agregar planta frutal\n"+
				"3. listar ortalizas con mas de un metro de altura. \n"+
                "4. vender producto \n"+
				"0. Exit. "); 
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
        switch(option){
            case 1:

                System.out.println("\nHa iniciado, registrar planta ornamental.");
                System.out.print("\nIngresa el nombre de esta planta: ");
                String name = reader.next();
                if(garden.searchPlant(name)==null){
                    System.out.print("\nIngresa el costo que tendra esta planta: ");
                    double cost = reader.nextDouble();
                    System.out.print("\nIngresa la altura en metros que tiene la planta ornamental: ");
                    double mts = reader.nextDouble();

                    System.out.println(garden.addOrnamentalPlant(name, cost, mts));

                }else{
                    System.out.println("\nLo sentimos, ya existe una planta en el sistema con ese nombre.");
                }

            break;

            case 2: 

                System.out.println("\nHa iniciado, registrar planta frutal.");
                System.out.print("\nIngresa el nombre de esta planta: ");
                name = reader.next();
                if(garden.searchPlant(name)==null){
                    System.out.print("\nIngresa el costo que tendra esta planta: ");
                    double cost = reader.nextDouble();
                    System.out.print("\nIngresa el fruto que dara esta planta frutal: ");
                    String givesFruit = reader.next();

                    System.out.println(garden.addFruitPlant(name, cost, givesFruit));

                }else{
                    System.out.println("\nLo sentimos, ya existe una planta en el sistema con ese nombre.");
                }

            break;

            case 3: 

                System.out.println("\nHa iniciado, listar ortalizas con mas de un metro de altura.");

                System.out.print("\nLas plantas de tipo ornamental que superan 1 metro de altura son: ");
                System.out.println(garden.searchCalculateMts(mts));

            break;

            case 0:
                System.out.println("\nHasta luego administrador.");
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
