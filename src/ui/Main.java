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
         int typeOfPlant=0;
            String namePlant="";
            String possiblePlantsToadd=
                            "1. Fruit\n"+
                            "2. Ornamental";
            double costPlant=0;
            String nameFruit="";
            double heigth=0;
            String msj="";
        switch(option){
            case 1:
            System.out.println("Enter the type of plant");
            System.out.println(possiblePlantsToadd);

            typeOfPlant=reader.nextInt();
            
            System.out.println("Enter the name of the plant");
            namePlant=reader.next();
            System.out.println("Enter the cost of the plant");
            costPlant=reader.nextDouble();
            System.out.println("In case that the plant is a fruit, enter the name of the fruit");
            nameFruit=reader.next();
            System.out.println("In case that the plant is ornamental, enter the heigth (in mts)");
            heigth=reader.nextDouble();
            msj=garden.addPlant(typeOfPlant,namePlant,costPlant,nameFruit, heigth);
            System.out.println(msj);
            break;

            case 2:
            msj=garden.listOrnamentalPlants();
            System.out.println(msj);
            break;

            case 3: 
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
