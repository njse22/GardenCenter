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
            list1mtsPlants();
            break;

            case 3: 
            sellPlant();
            break;

            default:
            System.out.println("Invalid Option.");
            break;
        }
    }

    public void addPlant(){
        System.out.println("Escribe el nombre de la planta");
        String name=reader.next();
        System.out.println("Escribe el costo de la plnata");
        double cost=validateDoubleInput();
        while (cost==-1) {
            System.out.println("Escribe un valor valido");
            cost=validateDoubleInput();
        }
        System.out.println("¿Que tipo de planta es?" + "\n1)Frutal"+ "\n2)Ornamental");
        int option=validateIntegerInput();
        while (option<1 || option>2) {
            System.out.println("Escribe un valor valido");
            option=validateIntegerInput();
        }
        switch (option) {
            case 1:
                System.out.println("Escribe el nombre del fruto");
                String fruitName=reader.next();
                System.out.println(garden.addPlant(name, cost, fruitName, 0.0, option));
                break;
        
            case 2:
                System.out.println("Escribe la altura maxima en metros");
                double maxHeight=validateDoubleInput();
                while (maxHeight==-1) {
                    System.out.println("Escribe un valor valido");
                    maxHeight=validateDoubleInput();
                }
                System.out.println(garden.addPlant(name, cost, "", maxHeight, option));
                break;
        }
    }

    public void list1mtsPlants(){
        System.out.println(garden.list1mtsPlants());
    }

    public void sellPlant(){
        System.out.println(garden.listPlants());
        System.out.println("Escriba el nombre de la planta");
        String name=reader.next();
        System.out.println(garden.sellPlant(name));
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
