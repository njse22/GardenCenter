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
        String msg = "";
        String name = "";
        double cost = 0.0;
        double height = 0.0;
        String fruitName = "";

        switch(option){
            case 1:
                System.out.print("Qué tipo de planta es?\n1.Frutal\n2.Ornamental\nInput: ");
                int input = validateIntegerInput();

                System.out.print("Cual es el nombre de la planta? ");
                name = reader.next();
                System.out.print("Cual es el costo de la planta? ");
                cost = validateDobleInput();

                msg = "Invalid Input";
                if(cost > 0){
                    if(input == 1){
                        System.out.print("Cual es el nombre de su fruto? ");
                        fruitName = reader.next();
                        msg = garden.addFruityPlant(name,cost,fruitName);
                    }else if(input == 2){
                        System.out.print("Cual es la altura de la planta? ");
                        height = validateDobleInput();
                        msg = garden.addOrnamentalPlant(name,cost,height);
                    }else{
                        msg = "Not recognized plant type.";
                    }
                }
            break;

            case 2: 
                msg = garden.listOrnamentalsByHeight(1);
            break;

            case 3: 
                String plants = garden.listAllPlants();
                msg = "Parece que no hay plantas por el momento";
                if(!plants.isEmpty()){
                    System.out.println("\n"+plants);
                    System.out.print("Cual es el nombre de la planta que desea comprar? ");
                    name = reader.next();

                    msg = garden.sellPlant(name);
                }
                
            break;

            default:
            msg = "Invalip Option.";
            break;
        }
        System.out.println(msg);
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
    
    public double validateDobleInput(){
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
