package com.portfolio.my_stock_portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.portfolio.my_stock_portfolio.model")
@EnableJpaRepositories(basePackages = "com.portfolio.my_stock_portfolio.repository")
public class MyStockPortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStockPortfolioApplication.class, args);
    }
}
