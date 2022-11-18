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
            case 1 -> addPlant();

            case 2 -> listOrnamentals();

            case 3 -> sellProduct();

            

            default ->  System.out.println("Invalip Option.");
        
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

    public void addPlant(){
        String msj = "";
        System.out.println("Que tipo de planta deseas añadir: "+
        "\n 1. Frutales"+
        "\n 2. Ornamentales"+
        "\n Opcion: ");
        int type = reader.nextInt();
        reader.nextLine();

        System.out.println("Dime el nombre de esta planta: ");
        String name = reader.nextLine();

        System.out.println("Dime el costo: ");
        double cost = reader.nextDouble();
        reader.nextLine();

        switch(type){
            case 1: 
                System.out.println("Dime el nombre de la fruta");
                String nameOfFruit = reader.nextLine();
                System.out.println(garden.addPlantFruitTrees(name, cost, nameOfFruit));
                break;
            case 2:
                System.out.println("Dime la altura de esta ornamental en (mts): ");
                double height = reader.nextDouble();
                System.out.println(garden.addPlantOrnamentals(name,cost, height));
                break;    
        }
    }

    public void listOrnamentals(){
        System.out.println(garden.listPlantsHeight());
    }

    //No acabe este profe :c
    public void sellProduct(){
        String msj = "";
        System.out.println(garden.listPlants());

        System.out.println("Dime el nombre de la planta que deseas comprar: ");
        String name = reader.nextLine();


      
    }
    
}
