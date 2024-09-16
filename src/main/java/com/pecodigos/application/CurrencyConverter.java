package com.pecodigos.application;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        UI ui = new UI();

        while (!exit) {
            System.out.println("""
                    ************************************************
                    
                    -------------- CURRENCY CONVERTER --------------
                    
                                  1- Convert currency.
                                  2- Show history.
                                  0- Exit the program.
                    
                    ------------------------------------------------
                    
                    ************************************************
                    """);
            System.out.print("Enter the option's number: ");
            int n = sc.nextInt();

            switch (n) {
                case 0:
                    ui.goodbyeMessage();
                    ui.pressAnyKey();
                    ui.clearScreen();
                    exit = true;
                    break;
                case 1:
                    ui.convertCurrency();
                    ui.pressAnyKey();
                    ui.clearScreen();
                    break;
                case 2:
                    ui.showHistory();
                    ui.pressAnyKey();
                    ui.clearScreen();
                    break;
                default:
                    System.out.println("\nThere's no option with that number.");
                    ui.pressAnyKey();
                    ui.clearScreen();
                    break;
            }
        }
        sc.close();
    }
}
