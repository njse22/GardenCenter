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
        switch(option){
            case 1:
                addPlant();

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

    public double validateDouble(){
        double option = -1;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            reader.next();
            option = -1;
        }
        return option;
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

    public void addPlant(){
        String msj = "";
        
        System.out.println("Escribe el nombre de la planta");
        String name = reader.next();
        System.out.println("Escribe el costo de la planta");
        double cost = validateDouble();

        System.out.println("Escribe que tipo de planta deseas agregar: \n"+
        "1) Fruta \n"+
        "2) Ornamental ");
        int opt = validateIntegerInput();
        

        if(opt == -1 || opt < 1 || opt > 2){
            System.out.println("Escribe un valor válido. ");
        }
        else if(opt == 1){
            System.out.println("Para finalizar, que tipo de fruta da esta planta: ");
            String fruit = reader.next();
            msj = garden.addPlantFruit(name, cost, fruit);
        }
        else if(opt == 2){
            System.out.println("Para finalizar, que altura tiene la planta: ");
            double height = validateDouble();
            msj = garden.addPlantOrnamental(name, cost, height);
        }

    }
    
}
