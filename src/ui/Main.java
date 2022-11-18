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

        System.out.println("<<<<<Garden Center>>>>> \n" +
                "1. agregar planta\n" +
                "2. listar ortalizas con mas de un metro de altura. \n" +
                "3. vender producto \n" +
                "0. Exit. ");
        option = validateIntegerInput();
        return option;
    }

    public void executeOption(int option) {
        String msg = "";
        switch (option) {
            case 1:
                msg = uiAddPlant();
                System.out.println(msg);
                break;

            case 2:
                msg = uiMoreThanOneMeter();
                System.out.println(msg);
                break;

            case 3:
                break;

            default:
                System.out.println("Invalip Option.");
                break;
        }
    }

    public String uiAddPlant() {
        String msg = "";
        boolean isOrnamental = true;
        double height = 0;
        String fruitName = "";

        System.out.println("La planta que va a ingresar es ornamental?\n" +
                            "1. Si\n" + 
                            "2. No");
        int choose = validateIntegerInput();

        if (choose == -1) {
            return "Ingrese un numero valido";
        }

        if (choose == 2) {
            isOrnamental = false;

            System.out.println("Ingrese el nombre de su fruto: ");
            fruitName = reader.next();
        } else {
            System.out.println("Ingrese la altura en metros de la planta: ");
            height = validateDoubleInput();

            if (height == -1) {
                return "Ingrese una altura valida";
            }
        }

        System.out.println("Ingrese el nombre de la planta: ");
        String name = reader.next();

        System.out.println("Ingrese el precio de la planta: ");
        double cost = validateDoubleInput();

        if (cost == -1) {
            return "Ingrese un precio valido";
        }

        msg = garden.addPlant(isOrnamental, name, cost, height, fruitName);

        return msg;
    }

    public String uiMoreThanOneMeter() {
        String msg = "";

        msg = garden.oneMeterHigher();

        return msg;
    }

    public String uiSellPlant() {
        String msg = "";

        System.out.println("Estas son las matrices disponibles: ");
        System.out.println(garden.showAllPlants());

        return msg;
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

    public double validateDoubleInput() {
        double option = 0;

        if (reader.hasNextDouble()) {
            option = reader.nextDouble();
        } else {
            reader.nextLine();
            option = -1;
        }
        return option;
    }

}
