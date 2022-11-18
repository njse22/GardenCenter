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
        String name="";
        String nameFruit="";
        String msj="";
        int select=0;
        double height=0;
        double cost=0;
        boolean exist=false;
        switch(option){
            case 1:
            System.out.println("Cual es el tipo de planta 1)Frutal o 2)Ornamental");
            select=reader.nextInt();
            if(select==1){
                System.out.println("Cual es el nombre");
                name=reader.next();

                System.out.println("Cual es el costo");
                cost=reader.nextDouble();
                System.out.println("Cual es el nombre del fruto");
                nameFruit=reader.next();
                msj=garden.addPlant(name,cost,nameFruit,select,height);
            }if(select ==2){
                System.out.println("Cual es el nombre");
                name=reader.next();
                System.out.println("Cual es el costo");
                cost=reader.nextDouble();
                System.out.println("Cual es la altura");
                height=reader.nextDouble();
                msj=garden.addPlant(name,cost,nameFruit,select,height);

            }if(select <1 | select>2){
                msj="No existe ese tipo de planta";
            }
            
            System.out.println(msj);
            break;

            case 2: 
             msj=garden.printOrnamentales();
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
    
}
