package com.portfolio.my_stock_portfolio.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor to initialize the password encoder
    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Hash the plain password
    public String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    // Match the plain password with the hashed password
    public boolean matchPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}
