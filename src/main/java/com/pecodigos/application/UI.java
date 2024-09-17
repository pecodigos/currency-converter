package com.pecodigos.application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pecodigos.dtos.CurrencyDTO;
import com.pecodigos.models.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private final List<String> historyList = new ArrayList<>();
    DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");

    public void convertCurrency() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the currency's code you want to check (example USD, BRL, EUR): ");
        String fromCurrencyCode = sc.nextLine().toUpperCase();

        System.out.printf("\nEnter the currency code you want to compare %s with: ", fromCurrencyCode);
        String toCurrencyCode = sc.nextLine().toUpperCase();

        String url = "https://v6.exchangerate-api.com/v6/e7eb64c556eca5a1e312199c/latest/" + fromCurrencyCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        CurrencyDTO currencyDTO = gson.fromJson(response.body(), CurrencyDTO.class);
        Currency currency = new Currency(currencyDTO);

        Double conversionRate = currency.getRate(toCurrencyCode);

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = localDateTime.format(dateTimeFormatter);

        historyList.add(String.format("$1.00 %s was $%.3f %s at %s\n", fromCurrencyCode, conversionRate, toCurrencyCode, formattedTime));

        clearScreen();

        if (conversionRate != null) {
            System.out.println("""
                    **************************************************************************
                                               CONVERSION INFORMATION:
                    """);
            System.out.printf("\t\t$1.00 %s is $%.3f %s at %s\n", fromCurrencyCode, conversionRate, toCurrencyCode, formattedTime);
        }
    }

    public void showHistory() {
        clearScreen();
        System.out.println("""
                
                **************************************************************************
                --------------------------- CONVERSION HISTORY ---------------------------
                """);
        int i = 1;

        if (historyList.isEmpty()) {
            System.out.println("\t\t    You didn't convert anything yet.");
        }

        for (String history : historyList) {
            System.out.printf("\t\t%d- %s", i, history);
            i++;
        }
    }

    public void goodbyeMessage() {
        clearScreen();
        System.out.println("""
                
                **************************************************************************
                --------------------------------------------------------------------------
                
                                     ORACLE NEXT EDUCATION CHALLENGE
                                            MADE BY PECODIGOS
                                    THANKS FOR USING THIS APPLICATION
                
                --------------------------------------------------------------------------
                **************************************************************************
                """);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressAnyKey() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n**************************************************************************\n");

        System.out.print("Press enter to continue: ");
        sc.nextLine();

        System.out.println();
    }
}
