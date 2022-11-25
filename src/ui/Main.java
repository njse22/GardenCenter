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
                "3. vender producto. \n"+
				"0. Exit. "); 
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option){
        switch(option){
            case 1:
            System.out.println();
            String messageOne = "";


            System.out.println("Por favor escriba el nombre de la planta: ");
            String name = reader.next();
            System.out.println("Por favor escriba el costo de la planta: ");
            double cost = validateDoubleInput();
            System.out.println("Por favor seleccione el tipo de planta: \n" +
            "1. Frutal. \n" +
            "2. Ornamental.");
            int type = validateIntegerInput();

            if(type < 1 || type > 2){
                System.out.println("Opcion no valida.");
            }
            else{
                if(type == 1){
                    System.out.println("Porfavor escriba el nombre del fruto: ");
                    String fruit = reader.next();
                    messageOne = garden.addFruit(name, cost, fruit);
                }
                else{
                    System.out.println("Porfavor escriba en metros la altura promedio de la planta: ");
                    double height = validateDoubleInput();
                    messageOne = garden.addOrnamental(name, cost, height);
                }
                
            }

            System.out.println(messageOne);

            break;

            case 2: 
                System.out.println();
                
                String messageTwo = garden.listHighOrnamental();

                System.out.println(messageTwo);

            break;

            case 3: 
                System.out.println();
                String messageThree;
                String list = garden.printList();
                System.out.println(list);

                System.out.println("Porfavor escriba el nombre de la planta que desea comprar: ");
                String nameToBuy = reader.next();

                messageThree = garden.buyPlant(nameToBuy);

                System.out.println(messageThree);

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
            reader.nextLine();
            option = -1;
        }
        return option;
    }
    
}
