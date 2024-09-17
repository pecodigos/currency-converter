package com.pecodigos.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        UI ui = new UI();
        int n;

        while (!exit) {
            try {
                ui.clearScreen();
                System.out.println("""
                    **************************************************************************
                    
                    --------------------------- CURRENCY CONVERTER ---------------------------
                    
                                               1- Convert currency.
                                               2- Show history.
                                               0- Exit the program.
                    
                    --------------------------------------------------------------------------
                    
                    **************************************************************************
                    """);

                System.out.print("Enter the option's number: ");
                n = sc.nextInt();
                sc.nextLine();

                switch (n) {
                    case 0:
                        ui.goodbyeMessage();
                        ui.pressEnter(sc);
                        ui.clearScreen();
                        exit = true;
                        break;
                    case 1:
                        ui.convertCurrency(sc);
                        ui.pressEnter(sc);
                        break;
                    case 2:
                        ui.showHistory();
                        ui.pressEnter(sc);
                        break;
                    default:
                        System.out.println("\nThere's no option with that number.");
                        ui.pressEnter(sc);
                        break;
                }
            } catch (InputMismatchException e) {
                ui.invalidInputOutput();
                sc.nextLine();
                ui.pressEnter(sc);
            }
        }
        sc.close();
    }
}
