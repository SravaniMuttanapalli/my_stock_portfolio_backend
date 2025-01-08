package com.portfolio.my_stock_portfolio.service;

import java.math.BigDecimal;

public class StockPriceService {

    public BigDecimal getCurrentPrice(String ticker) {
        // Here you would normally interact with an external service or database to get
        // the current stock price.
        // For testing, we'll return a hardcoded value.
        if ("AAPL".equals(ticker)) {
            return new BigDecimal("150.00"); // Example stock price for AAPL
        }
        throw new UnsupportedOperationException("Ticker not supported");
    }
}
