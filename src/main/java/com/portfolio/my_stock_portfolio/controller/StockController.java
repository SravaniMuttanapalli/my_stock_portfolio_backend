package com.portfolio.my_stock_portfolio.controller;

import com.portfolio.my_stock_portfolio.model.Stock;
import com.portfolio.my_stock_portfolio.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockRepository stockRepository;
    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        try {
            logger.info("Fetching all stocks...");
            List<Stock> stocks = stockRepository.findAll();
            return ResponseEntity.ok(stocks);
        } catch (Exception e) {
            logger.error("Error occurred while fetching stocks: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {
        try {
            Optional<Stock> stock = stockRepository.findByTicker(ticker);
            if (stock.isPresent()) {
                return ResponseEntity.ok(stock.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            // Log the exception for better insight into what went wrong
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        try {
            Stock savedStock = stockRepository.save(stock);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStock);
        } catch (Exception e) {
            logger.error("Error occurred while adding stock: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        try {
            Optional<Stock> existingStock = stockRepository.findById(id);

            if (existingStock.isPresent()) {
                Stock stockToUpdate = existingStock.get();
                stockToUpdate.setTicker(stock.getTicker());
                stockToUpdate.setPrice(stock.getPrice());
                Stock updatedStock = stockRepository.save(stockToUpdate);
                return ResponseEntity.ok(updatedStock);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            logger.error("Error occurred while updating stock with ID {}: ", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) {
        try {
            if (stockRepository.existsById(id)) {
                stockRepository.deleteById(id);
                return ResponseEntity.ok("Stock deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found.");
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting stock with ID {}: ", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the stock.");
        }
    }
}
