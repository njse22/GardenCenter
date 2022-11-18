package ui;

import model.GardenCenter

import javax.sound.sampled.SourceDataLine;

import javax.sound.sampled.SourceDataLine;;
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

    public int optionMenu() {
      int option = 0;

      System.out.println("<<<<<Garden Center>>>>> \n" +
          "1. agregar planta\n" +
          "2. listar ortalizas con mas de un metro de altura. \n" +
          "3. vender producto \n" +
          "0. Exit. ");
      option = validateIntegerInput();
      return option;
    }
    
    public void addPlant() {
      int choice;
      System.out.println("¿Qué planta desea agregar?");
      System.out.println(
        "(1) Frutal \n" + 
        "(2) Ornamental"
      );
      choice = reader.nextInt();
      switch(choice){
  case 1:
  System.out.println("Ingrese el nombre de la planta.");
  String name = reader.next();
  System.out.println("Ingrese el costo de la planta.");
  double cost = reader.nextDouble();
  System.out.println("Ingrese el nombre del fruto de la planta.");
  String nameFruto = reade.next();
  
  System.out.println(garden.addFrutalPlant(name, cost, nameFruto));
  break;

  case 2:
  System.out.println("Ingrese el nombre de la planta.");
  String name2 = reader.next();
  System.out.println("Ingrese el costo de la planta.");
  double cost2 = reader.nextDouble();
  System.out.println("Ingrese la altura de la planta en metros.");
  double altura = reader.nextDouble();

  System.out.println(garden.addOrnamentalPlant(name2, cost2, altura));
        break;
  
      default:
      System.out.println("Opción inválida.");
        break;
      }
    }

    public void executeOption(int option){
        switch(option){
            case 1:
            System.out.println("Añadir planta.");
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
