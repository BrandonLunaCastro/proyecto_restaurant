package model;

import java.util.Scanner;

public class ImputValidator {
    ImputValidator(){}

    public static int readInt(Scanner sc, String prompt){
        while(true){
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.println("Dato invalido. Ingrese un numero entero");
            }
        }
    }

    public static double readDouble(Scanner sc, String prompt){
        while(true){
            System.out.print(prompt);
            try{
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e ) {
                 System.out.println("Dato invalido. Ingrese un numero (ej: 10.5 )");
            }
        }
    }

}
