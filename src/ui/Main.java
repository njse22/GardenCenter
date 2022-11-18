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

    public void plantRegister(){
        String msj = "This plant name is already use.";
        System.out.println("Type plant name.");
        String plantName = reader.next();
        int plantPos = garden.searchPlant(plantName);
        if (plantPos == -1){
            System.out.println("Type plant cost.");
            double plantCost = getDoubleData();
            int option = 0;
            String fruitName = "";
            double alture = 0;

            while(option == 0){
                System.out.println("Type plant type: 1)Fruity plant  2)Ornamental plant.");
                option = getIntegerData();

                switch(option){
                case 1 : System.out.println("Type plant fruit name.");
                    fruitName = reader.next();
                    break;

                case 2 : System.out.println("Type plant alture.");
                    alture = getDoubleData();
                    break;

                default: System.out.println("Invalid Option. Type another.");
                    option = 0;
                    break;
                }
            }

            msj = garden.plantRegister(option, plantName, plantCost, fruitName, alture);
            
        }

        System.out.println(msj);

    }

    public void showOrnamentalPlantsList(){
        String msj = garden.printOrnamentalPlants();
        System.out.println(msj);
    }

    public void executeOption(int option){
        switch(option){
            case 1:
                plantRegister();
            break;

            case 2:
                 showOrnamentalPlantsList();
            break;

            case 3: 
            break;

            case 0:
                System.out.println("Byeee!");
            break;

            default:
            System.out.println("Invalip Option.");
            break;
        }
    }

    public int getIntegerData(){
        String msj = "Invalid character. Type another.";
        int data = -1;
        while(data == -1){
            data = validateIntegerInput();
            if (data == -1){
                System.out.println(msj);
            }
        }
        return data;
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

    public double getDoubleData(){
        String msj = "Invalid character. Type another.";
        double data = -1;
        while(data == -1){
            data = validateDoubleInput();
            if (data == -1){
                System.out.println(msj);
            }
        }
        return data;
    }


    public double validateDoubleInput(){
        double option = 0;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;
    }
    
}
