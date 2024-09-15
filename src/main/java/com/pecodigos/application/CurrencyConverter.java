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
                case 1:
                    ui.convertCurrency();
                    ui.clearScreen();
                    break;
                case 2:
                    ui.showHistory();
                    ui.clearScreen();
                    break;
                default:
                    ui.goodbyeMessage();
                    ui.clearScreen();
                    break;
            }
            if (n == 0) {
                exit = true;
            }
        }
        sc.close();
    }
}