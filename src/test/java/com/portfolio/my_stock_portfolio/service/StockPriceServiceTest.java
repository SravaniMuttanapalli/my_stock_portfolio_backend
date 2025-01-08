package com.portfolio.my_stock_portfolio.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class StockPriceServiceTest {

    private StockPriceService stockPriceService;

    @BeforeEach
    void setUp() {
        // Create an instance of StockPriceService before each test
        stockPriceService = new StockPriceService();
    }

    @Test
    void testGetCurrentPrice_validTicker() {
        // Test that AAPL returns the expected price
        String ticker = "AAPL";
        BigDecimal expectedPrice = new BigDecimal("150.00");

        BigDecimal actualPrice = stockPriceService.getCurrentPrice(ticker);

        assertEquals(expectedPrice, actualPrice, "The price should be 150.00 for AAPL");
    }

    @Test
    void testGetCurrentPrice_invalidTicker() {
        // Test that an unsupported ticker throws an exception
        String ticker = "GOOG";

        assertThrows(UnsupportedOperationException.class,
                () -> stockPriceService.getCurrentPrice(ticker),
                "Ticker not supported");
    }
}
