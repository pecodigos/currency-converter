package com.pecodigos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the currency's code you want to check (example USD, BRL, EUR): ");
        String currencyCode = sc.nextLine();

        String url = "https://v6.exchangerate-api.com/v6/e7eb64c556eca5a1e312199c/latest/" + currencyCode.toUpperCase();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        sc.close();
    }
}