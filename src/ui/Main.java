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
        do {
            option = main.optionMenu();
            main.executeOption(option);
        } while (option != 0);

        main.reader.close();
    }

    public int optionMenu() {
        int option = 0;

        System.out.println("\n" + "<<<<<Garden Center>>>>> \n" +
                "1. agregar planta\n" +
                "2. listar ortalizas con mas de un metro de altura. \n" +
                "3. vender producto \n" +
                "0. Exit. ");
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                String nameFruit = "";
                double height = 0;

                System.out.println("Seleccione el tipo de planta que desea crear: " + "\n");
                boolean optionPlant = chooseOptionUser("Ornamental", "Frutal");
                if (optionPlant == true) {
                    System.out.println("Escriba el nombre");
                    String name = reader.next();
                    System.out.println("Escriba el nombre del fruto");
                    nameFruit = reader.next();
                    System.out.println("Escriba el costo de la planta");
                    double cost = validateDoubleOption();
                    while (cost == -1) {
                        reader.next();
                        System.out.println(
                                "Este apartado no acepta letras. Escriba un dato valido");
                        System.out.println("Recuerde elegir una opcion valida");
                        cost = validateDoubleOption();
                    }
                    System.out.print(garden.addPlantSystem(name, cost, nameFruit, height, optionPlant));
                } else {
                    System.out.println("Escriba el nombre");
                    String name = reader.next();
                    System.out.println("Escriba la altura de la planta");
                    height = validateDoubleOption();
                    while (height == -1) {
                        reader.next();
                        System.out.println(
                                "Este apartado no acepta letras. Escriba un dato valido");
                        System.out.println("Recuerde elegir una opcion valida");
                        height = validateDoubleOption();
                    }
                    System.out.println("Escriba el costo de la planta");
                    double cost = reader.nextDouble();
                    while (cost == -1) {
                        reader.next();
                        System.out.println(
                                "Este apartado no acepta letras. Escriba un dato valido");
                        System.out.println("Recuerde elegir una opcion valida");
                        cost = validateDoubleOption();
                    }
                    System.out.print(garden.addPlantSystem(name, cost, nameFruit, height, optionPlant));
                }

                break;

            case 2:
                System.out.println(garden.listPlantsMoreThan1Meter());
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid Option.");
                break;
        }
    }

    public int validateIntegerInput() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            reader.nextLine();
            option = -1;
        }
        return option;
    }

    /**
     * validateDoubleOption: This method checks if a number is an double
     * 
     * @return option - int: Returns the entered number if it is an double or
     *         returns -1 if it is not an double
     */
    public double validateDoubleOption() {
        double option = 0;

        if (reader.hasNextDouble()) {
            option = reader.nextDouble();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    public boolean chooseOptionUser(String condition0False, String condition1True) {

        int option = 0;
        System.out.println("0." + condition0False + "\n" + "1." + condition1True);
        option = validateIntegerInput();
        while (option > 1 || option < 0 || option == -1) {
            reader.next();
            System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
            System.out.println("Recuerde que las opciones son 0 y 1");
            option = validateIntegerInput();

        }

        if (option == 0) {
            return false;
        } else {
            return true;
        }

    }

}
