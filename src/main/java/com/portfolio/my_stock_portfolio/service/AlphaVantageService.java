package com.portfolio.my_stock_portfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlphaVantageService {

    @Value("${alphavantage.api.key}")
    private String apiKey; // Injected API key from application.properties

    public String fetchStockData(String symbol) {
        // Use the injected API key here
        System.out.println("Using API Key: " + apiKey);

        // Add logic to fetch stock data here
        return "Stock Data for symbol: " + symbol + " fetched using API Key: " + apiKey;
    }
}
