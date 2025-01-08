package com.portfolio.my_stock_portfolio.repository;

import com.portfolio.my_stock_portfolio.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    // Custom method to find stock by ticker
    Optional<Stock> findByTicker(String ticker);
}
