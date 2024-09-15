package com.pecodigos.application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pecodigos.models.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class UI {

    public void convertCurrency() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the currency's code you want to check (example USD, BRL, EUR): ");
        String currencyCode = sc.nextLine();

        String url = "https://v6.exchangerate-api.com/v6/e7eb64c556eca5a1e312199c/latest/" + currencyCode.toUpperCase();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        System.out.println(gson.fromJson(response.body(), Currency.class));
        System.out.println();
    }

    public void showHistory() {
        System.out.println("\nHistory here.\n");
    }

    public void goodbyeMessage() {
        System.out.println("""
                ************************************************
                ------------------------------------------------
                
                         ORACLE NEXT EDUCATION CHALLENGE
                                MADE BY PECODIGOS
                        THANKS FOR USING THIS APPLICATION
                
                ------------------------------------------------
                ************************************************
                """);

    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
