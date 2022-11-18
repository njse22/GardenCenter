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
    public void print(String text){
        System.out.println(text);
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
                registerPlant();
                break;

            case 2:
                listOrnamentalHeight();
                break;

            case 3:
                sellPlant();
                break;
            case 0:
                print("\n Bye");
                break;

            default:
                System.out.println("Invalip Option.");
           
        }
    }
    public void registerPlant(){
        String msj = "";
        String name = "";
        String type = "";
        String fruit = "";
        int pos = -1;
        int sw = 0;
        double height = 0;
        double cost = 0;
        print("\n Plant registration \n\n Enter Plant NAME :");
        name = reader.next();
        pos = garden.searchPlant(name);
        if(pos==-1){
            print("\n Enter Plant COST :");
            do{
                sw=0;
                if(reader.hasNextDouble()){
                    cost = reader.nextDouble();
                    if(cost<0){print("\n INVALID COST");sw=1;}
                }else{print("\n INVALID COST");sw=1;}
            }while(sw==1);
            print("\n Select Plant Type :");
            showPlantType();
            do{
                sw=0;
                type = reader.next();
                if(!type.equals("1") && !type.equals("2")){print("\n INVALID PLANT TYPE");sw = 1;}
            }while(sw==1);
            switch(type){
                case "1":
                    print("\n Enter FRUIT NAME :");
                    fruit = reader.next();
                    msj = garden.addFrutal(name,cost,fruit);
                    break;
                case "2":
                    print("\n Enter Plant HEIGHT :");
                    height = reader.nextDouble();
                    msj = garden.addOrnamental(name,cost,height);
                    break;
            }      
        }else{msj = "\n PLANT ALREADY REGISTERED";}
        print(msj);
    }
    public void listOrnamentalHeight(){
        String msj = "";
        msj = garden.listOrnamentalHeight();
        print(msj);
    }
    public void sellPlant(){
        String msj = "";
        String name = "";
        String bill = "";
        int pos = -1;
        msj = garden.showPlantList();
        print(msj);
        print("\n Enter Plant to Sell");
        name = reader.next();
        pos = garden.searchPlant(name);
        if(pos!=-1){
            bill = generateBill();
            msj = "\n SOLD PLANT : "+name+
            "\n BILL : "+ bill;
        }else{msj = "\n PLANT NOT FOUND";}
        print(msj);
    }
    public String generateBill(){
        int[][] matriz1 = new int[4][4];
        int[][] matriz2 = new int[4][4];
        int[][] matriz3 = new int[4][4];
        String bill = "";
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                matriz1[i][j] = (int)Math.floor(Math.random()*10);
                matriz2[i][j] = (int)Math.floor(Math.random()*10);
                matriz3[i][j] = matriz1[i][j]*matriz2[i][j];
            }
        }
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==0 || i==3){
                    bill += ""+ matriz3[i][0]+""+matriz3[i][3];
                }else{
                    bill += ""+ matriz3[i][1]+""+matriz3[i][2];
                }
                
            }
        }
        return bill;
    }
    public void showPlantType(){
        String msj = "\n"+
        "(1) FRUTAL \n"+
        "(2) ORNAMENTAL";
        print(msj);
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
