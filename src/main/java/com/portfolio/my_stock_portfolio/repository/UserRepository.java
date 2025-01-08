package com.portfolio.my_stock_portfolio.repository;

import com.portfolio.my_stock_portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
