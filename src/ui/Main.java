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
        double cost = 0;
        double height = 0;
        String fruitName = "";
        int selection = 0;
        String msj = "";
        switch(option){
            case 1:
                System.out.println("Elige el tipo dde planta\n"+
                                    "1.Ornamental\n"+
                                    "2.Frutal\n"); 
                selection = reader.nextInt();
                if(selection==-1){
                    System.out.println("valor invalido");
                    break;
                }
                System.out.println("Escribe el nombre de la planta");
                name = reader.next();
                if(garden.verifyName(name)){
                    System.out.println("El nombre de la planta ya esta registrado");
                    break;
                }
                System.out.println("Escribe el costo de la planta");
                cost = validateDoubleInput();
                if(cost==-1){
                    System.out.println("valor invalido");
                    break;
                }
                switch(selection){
                    case 1:
                    System.out.println("escribe la altura de la planta");
                    height = reader.nextDouble();
                    if(height==-1){
                        System.out.println("valor invalido");
                        break;
                    }
                    msj = garden.addOrnamentalPlant(name, cost, height);
                    break;
                    case 2:
                    System.out.println("escribe el nombre del fruto  de la planta");
                    fruitName = reader.next();
                    msj = garden.addFruityPlant(name, cost, fruitName);
                    break;
                    default:
                    System.out.println("Invalip Option.");
                    break;
                }
                System.out.println(msj);
            break;

            case 2: 
            msj = garden.listOrnamentalPlantsBySize();
            System.out.println(msj);
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
            reader.nextLine();
            option = -1;
        }
        return option;
    }
    
}
